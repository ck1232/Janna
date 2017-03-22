package com.JJ.controller.customermanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Customer;
import com.JJ.model.Customeraddress;
import com.JJ.service.customeraddressmanagement.CustomerAddressManagementService;
import com.JJ.service.customermanagement.CustomerManagementService;


@Controller  
@EnableWebMvc
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
		List<Customer> customerList = customerManagementService.getAllCustomers();
		return GeneralUtils.convertListToJSONString(customerList);
	}
	
	@RequestMapping(value = "/viewCustomer", method = RequestMethod.POST)
	public String viewCustomer(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		Customer customer = customerManagementService.findById(new Integer(id));
		if (customer == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Customer not found");
			return "listCustomer";
		}
		List<Customeraddress> addressList = customerAddressManagementService.getAllCustomerAddressByCustomerId(Integer.parseInt(id));
		model.addAttribute("customer", customer);
		for(Customeraddress address: addressList) {
			if(address.getDefaultind().equals("Y")) {
				model.addAttribute("contactNo", address.getContactnumber());
				break;
			}
		}
		model.addAttribute("addressList", addressList);
		return "viewCustomer";
	}
	
	@RequestMapping(value = "/viewCustomer/{id}", method = RequestMethod.GET)
	public String viewCustomerForRedirect(@PathVariable String id, Model model) {
		logger.debug("id = " + id);
		Customer customer = customerManagementService.findById(new Integer(id));
		if (customer == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Customer not found");
			return "listCustomer";
		}
		List<Customeraddress> addressList = customerAddressManagementService.getAllCustomerAddressByCustomerId(Integer.parseInt(id));
		model.addAttribute("customer", customer);
		for(Customeraddress address: addressList) {
			if(address.getDefaultind().equals("Y")) {
				model.addAttribute("contactNo", address.getContactnumber());
				break;
			}
		}
		model.addAttribute("addressList", addressList);
		return "viewCustomer";
	}
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.GET)
    public String showAddCustomerForm(Model model) {  
    	logger.debug("loading showAddCustomerForm");
    	Customer customer = new Customer();
    	customer.setIsactive(true);
    	customer.setGender("M");
    	model.addAttribute("customerForm", customer);
        return "createCustomer";  
    }  
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customerForm") /*@Validated*/ Customer customer, 
    		/*BindingResult result,*/ Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveCustomer() : " + customer.toString());
//		if (result.hasErrors()) {
//			return "createCustomer";
//		} else {
			customer.setDeleteInd(GeneralUtils.NOT_DELETED);
			customerManagementService.saveCustomer(customer);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Customer added successfully!");
//		}
		
		
        return "redirect:viewCustomer/" + customer.getCustomerid();  
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
		Customeraddress address = customerAddressManagementService.findById(Integer.parseInt(id));
		return "redirect:viewCustomer/"+address.getCustomerid();
	}
	
	@RequestMapping(value = "/createCustomerAddress", method = RequestMethod.POST)
    public String createCustomerAddress(@RequestParam(value="customerid", required=false) String customerid,
    		@RequestParam(value="recipientname", required=false) String recipientname,
			@RequestParam(value="address", required=false) String address,
			@RequestParam(value="postalcode", required=false) String postalcode,
			@RequestParam(value="contactnumber", required=false) String contactnumber,
			@RequestParam(value="country", required=false) String country,
			RedirectAttributes redirectAttributes) {  
		Customeraddress customerAddress = new Customeraddress();
		customerAddress.setCustomerid(Integer.parseInt(customerid));
		customerAddress.setRecipientname(recipientname);
		customerAddress.setAddress(address);
		customerAddress.setContactnumber(Long.parseLong(contactnumber));
		customerAddress.setPostalcode(Integer.parseInt(postalcode));
		customerAddress.setCountry(country);
		List<Customeraddress> addressList = customerAddressManagementService.getAllCustomerAddressByCustomerId(Integer.parseInt(customerid));
		if(addressList.size() == 0){
			customerAddress.setDefaultind("Y");
		}else{
			customerAddress.setDefaultind("N");
		}
		customerAddressManagementService.saveCustomerAddress(customerAddress);
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
		Customeraddress addressToSave = customerAddressManagementService.findById(Integer.parseInt(addressid));
		addressToSave.setRecipientname(recipientname);
		addressToSave.setAddress(address);
		addressToSave.setPostalcode(Integer.parseInt(postalcode));
		addressToSave.setContactnumber(Long.parseLong(contactnumber));
		customerAddressManagementService.updateCustomerAddress(addressToSave);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Address updated successfully!");
		return "redirect:viewCustomer/"+addressToSave.getCustomerid();
	}
	
	@RequestMapping(value = "/setAddressDefault", method = RequestMethod.POST)
	public String getAddressToUpdate(@RequestParam("setDefaultBtn") String id, Model model) {
		Customeraddress customerAddress = customerAddressManagementService.findById(Integer.parseInt(id));
		customerAddressManagementService.updateCustomerAddressToUndefault(customerAddress.getCustomerid());
		customerAddress.setDefaultind("Y");
		customerAddressManagementService.updateCustomerAddress(customerAddress);
		return "redirect:viewCustomer/"+customerAddress.getCustomerid();
	}
	
	@RequestMapping(value = "/activateOrDeactivateCustomer", method = RequestMethod.POST)
	public String activateOrDeactivateCustomer(@RequestParam("customerId") String id, Model model, 
			RedirectAttributes redirectAttributes) {
		Customer customer = customerManagementService.findById(Integer.parseInt(id));
		if(customer.getIsactive()){
			customer.setIsactive(false);
			redirectAttributes.addFlashAttribute("msg", "Customer deactivated successfully!");
		}else if(!customer.getIsactive()){
			customer.setIsactive(true);
			redirectAttributes.addFlashAttribute("msg", "Customer activated successfully!");
		}
		customerManagementService.updateCustomer(customer);
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:viewCustomer/"+customer.getCustomerid();
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String getCustomerToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		Customer customer = customerManagementService.findById(new Integer(id));
		logger.debug("Loading update customer page for " + customer.toString());
		
		model.addAttribute("customerForm", customer);
		return "updateCustomer";
	}
	
	@RequestMapping(value = "/updateCustomerToDb", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("customerForm") Customer customer,
			/*BindingResult result, */Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateUser() : " + customer.toString());
		
		/*if (result.hasErrors()) {
			return "updateUser";
		} else {*/
			Customer toSaveCustomer = customerManagementService.findById(customer.getCustomerid());
			toSaveCustomer.setName(customer.getName());
			toSaveCustomer.setDob(customer.getDob());
			toSaveCustomer.setEmailaddress(customer.getEmailaddress());
			toSaveCustomer.setIsactive(customer.getIsactive());
			customerManagementService.updateCustomer(toSaveCustomer);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Customer updated successfully!");
//		}
		
		return "redirect:viewCustomer/" + customer.getCustomerid();
	}
	
}