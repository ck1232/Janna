package com.JJ.controller.customermanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.customeraddressmanagement.VO.CustomerAddressVO;
import com.JJ.controller.customermanagement.VO.CustomerVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.customeraddressmanagement.CustomerAddressManagementService;
import com.JJ.service.customermanagement.CustomerManagementService;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/customer")
public class CustomerManagementController {
	private static final Logger logger = Logger.getLogger(CustomerManagementController.class);
	
	private CustomerManagementService customerManagementService;
	private CustomerAddressManagementService customerAddressManagementService;
	
	@Autowired
	public CustomerManagementController(CustomerManagementService customerManagementService,
			CustomerAddressManagementService customerAddressManagementService) {
		this.customerManagementService = customerManagementService;
		this.customerAddressManagementService = customerAddressManagementService;
	}
	
	
	@RequestMapping("/listCustomer")  
    public String listCustomer() {  
    	logger.debug("loading listCustomer");
        return "listCustomer";  
    }  
	
	@RequestMapping(value = "/getCustomerList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCustomerList() {
		logger.debug("getting customer list");
		List<CustomerVO> customerList = customerManagementService.getAllCustomers();
		return GeneralUtils.convertListToJSONString(customerList);
	}
	
	@RequestMapping(value = "/viewCustomer", method = RequestMethod.POST)
	public String viewCustomer(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		CustomerVO customerVO = customerManagementService.findById(new Integer(id));
		if (customerVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Customer not found");
			return "listCustomer";
		}
		List<CustomerAddressVO> customerAddressVOList = customerAddressManagementService.getAllCustomerAddressByCustomerId(Integer.parseInt(id));
		model.addAttribute("customer", customerVO);
		for(CustomerAddressVO vo: customerAddressVOList) {
			if(vo.getDeleteInd().equals("Y")) {
				model.addAttribute("contactNo", vo.getContactNumber());
				break;
			}
		}
		model.addAttribute("addressList", customerAddressVOList);
		return "viewCustomer";
	}
	
	@RequestMapping(value = "/viewCustomer/{id}", method = RequestMethod.GET)
	public String viewCustomerForRedirect(@PathVariable String id, Model model) {
		logger.debug("id = " + id);
		CustomerVO customerVO = customerManagementService.findById(new Integer(id));
		if (customerVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Customer not found");
			return "listCustomer";
		}
		List<CustomerAddressVO> customerAddressVOList = customerAddressManagementService.getAllCustomerAddressByCustomerId(Integer.parseInt(id));
		model.addAttribute("customer", customerVO);
		for(CustomerAddressVO vo: customerAddressVOList) {
			if(vo.getDeleteInd().equals("Y")) {
				model.addAttribute("contactNo", vo.getContactNumber());
				break;
			}
		}
		model.addAttribute("addressList", customerAddressVOList);
		return "viewCustomer";
	}
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.GET)
    public String showAddCustomerForm(Model model) {  
    	logger.debug("loading showAddCustomerForm");
    	CustomerVO customerVO = new CustomerVO();
    	customerVO.setIsActive("1");
    	customerVO.setGender("M");
    	model.addAttribute("customerForm", customerVO);
        return "createCustomer";  
    }  
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customerForm") /*@Validated*/ CustomerVO customerVO, 
    		/*BindingResult result,*/ Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveCustomer() : " + customerVO.toString());
//		if (result.hasErrors()) {
//			return "createCustomer";
//		} else {
			customerVO.setDeleteInd(GeneralUtils.NOT_DELETED);
			customerManagementService.saveCustomer(customerVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Customer added successfully!");
//		}
		
		
        return "redirect:viewCustomer/" + customerVO.getCustomerId();  
    }  
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public String deleteCustomer(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listCustomer";
		}
		List<Integer> customerIdList = new ArrayList<Integer>();
		for (String id : ids) {
			customerIdList.add(Integer.valueOf(id));
		}
		//check if customer has pending order, if have stop from deleting
		customerManagementService.deleteCustomer(customerIdList);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Customer(s) deleted successfully!");
		return "redirect:listCustomer";
	}
	
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
	public String deleteAddress(@RequestParam("deleteBtn") String id, Model model, 
			RedirectAttributes redirectAttributes) {
		customerAddressManagementService.deleteCustomerAddress(Integer.valueOf(id));
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Address deleted successfully!");
		CustomerAddressVO customerAddressVO = customerAddressManagementService.findById(Integer.parseInt(id));
		return "redirect:viewCustomer/"+customerAddressVO.getCustomerId();
	}
	
	@RequestMapping(value = "/createCustomerAddress", method = RequestMethod.POST)
    public String createCustomerAddress(@RequestParam(value="customerid", required=false) String customerid,
    		@RequestParam(value="recipientname", required=false) String recipientname,
			@RequestParam(value="address", required=false) String address,
			@RequestParam(value="postalcode", required=false) String postalcode,
			@RequestParam(value="contactnumber", required=false) String contactnumber,
			@RequestParam(value="country", required=false) String country,
			RedirectAttributes redirectAttributes) {  
		CustomerAddressVO customerAddressVO = new CustomerAddressVO();
		customerAddressVO.setCustomerId(Integer.parseInt(customerid));
		customerAddressVO.setRecipientName(recipientname);
		customerAddressVO.setAddress(address);
		customerAddressVO.setContactNumber(Long.parseLong(contactnumber));
		customerAddressVO.setPostalCode(Integer.parseInt(postalcode));
		customerAddressVO.setCountry(country);
		List<CustomerAddressVO> addressList = customerAddressManagementService.getAllCustomerAddressByCustomerId(Integer.parseInt(customerid));
		if(addressList.size() == 0){
			customerAddressVO.setDefaultInd("Y");
		}else{
			customerAddressVO.setDefaultInd("N");
		}
		customerAddressManagementService.saveCustomerAddress(customerAddressVO);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Address added successfully!");

        return "redirect:viewCustomer/" + customerid;  
    } 
	
	@RequestMapping(value = "/saveCustomerAddressToDb", method = RequestMethod.POST)
	public String saveAddress(@RequestParam(value="addressid", required=false) String addressid, 
			@RequestParam(value="recipientname", required=false) String recipientname,
			@RequestParam(value="address", required=false) String address,
			@RequestParam(value="postalcode", required=false) String postalcode,
			@RequestParam(value="contactnumber", required=false) String contactnumber,
			RedirectAttributes redirectAttributes) {
		CustomerAddressVO addressToSave = customerAddressManagementService.findById(Integer.parseInt(addressid));
		addressToSave.setRecipientName(recipientname);
		addressToSave.setAddress(address);
		addressToSave.setPostalCode(Integer.parseInt(postalcode));
		addressToSave.setContactNumber(Long.parseLong(contactnumber));
		customerAddressManagementService.updateCustomerAddress(addressToSave);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Address updated successfully!");
		return "redirect:viewCustomer/"+addressToSave.getCustomerId();
	}
	
	@RequestMapping(value = "/setAddressDefault", method = RequestMethod.POST)
	public String getAddressToUpdate(@RequestParam("setDefaultBtn") String id, Model model) {
		CustomerAddressVO customerAddress = customerAddressManagementService.findById(Integer.parseInt(id));
		customerAddressManagementService.updateCustomerAddressToUndefault(customerAddress.getCustomerId());
		customerAddress.setDefaultInd("Y");
		customerAddressManagementService.updateCustomerAddress(customerAddress);
		return "redirect:viewCustomer/"+customerAddress.getCustomerId();
	}
	
	@RequestMapping(value = "/activateOrDeactivateCustomer", method = RequestMethod.POST)
	public String activateOrDeactivateCustomer(@RequestParam("customerId") String id, Model model, 
			RedirectAttributes redirectAttributes) {
		CustomerVO customerVO = customerManagementService.findById(Integer.parseInt(id));
		if(customerVO.getIsActive().equals("1")){
			customerVO.setIsActive("0");
			redirectAttributes.addFlashAttribute("msg", "Customer deactivated successfully!");
		}else if(!customerVO.getIsActive().equals("1")){
			customerVO.setIsActive("0");
			redirectAttributes.addFlashAttribute("msg", "Customer activated successfully!");
		}
		customerManagementService.updateCustomer(customerVO);
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:viewCustomer/"+customerVO.getCustomerId();
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String getCustomerToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		CustomerVO customer = customerManagementService.findById(new Integer(id));
		logger.debug("Loading update customer page for " + customer.toString());
		
		model.addAttribute("customerForm", customer);
		return "updateCustomer";
	}
	
	@RequestMapping(value = "/updateCustomerToDb", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("customerForm") CustomerVO customerVO,
			/*BindingResult result, */Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateUser() : " + customerVO.toString());
		
		/*if (result.hasErrors()) {
			return "updateUser";
		} else {*/
			CustomerVO toSaveCustomer = customerManagementService.findById(customerVO.getCustomerId());
			toSaveCustomer.setName(customerVO.getName());
			toSaveCustomer.setDob(customerVO.getDob());
			toSaveCustomer.setEmailAddress(customerVO.getEmailAddress());
			toSaveCustomer.setIsActive(customerVO.getIsActive());
			customerManagementService.updateCustomer(toSaveCustomer);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Customer updated successfully!");
//		}
		
		return "redirect:viewCustomer/" + customerVO.getCustomerId();
	}
	
}