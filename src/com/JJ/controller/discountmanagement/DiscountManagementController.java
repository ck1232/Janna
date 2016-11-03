package com.JJ.controller.discountmanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Discount;
import com.JJ.model.User;
import com.JJ.service.discountmanagement.DiscountManagementService;
import com.JJ.validator.DiscountFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/discount")
public class DiscountManagementController {
	private static final Logger logger = Logger.getLogger(DiscountManagementController.class);
	
	private DiscountManagementService discountManagementService;
	private DiscountFormValidator discountFormValidator;
	
	@Autowired
	public DiscountManagementController(DiscountManagementService discountManagementService,
			DiscountFormValidator discountFormValidator) {
		this.discountManagementService = discountManagementService;
		this.discountFormValidator = discountFormValidator;
	}
	
	
	@RequestMapping("/listDiscount")  
    public String listDiscount() {  
    	logger.debug("loading listDiscount");
        return "listDiscount";  
    }  
	
	@RequestMapping(value = "/getDiscountList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getDiscountList() {
		logger.debug("getting discount list");
		List<Discount> discountList = discountManagementService.getAllDiscounts();
		return GeneralUtils.convertListToJSONString(discountList);
	}
	
	@RequestMapping(value = "/createDiscount", method = RequestMethod.GET)
    public String showAddDiscountForm(Model model) {  
    	logger.debug("loading showAddDiscountForm");
    	Discount discount = new Discount();
    	discount.setDeleteind(GeneralUtils.NOT_DELETED);
    	
    	List<String> discTypeList = new ArrayList<String>();
    	discTypeList.add("Percentage %");
    	discTypeList.add("Value $");
    	
    	model.addAttribute("discTypeList", discTypeList);
    	model.addAttribute("discountForm", discount);
        return "createDiscount";  
    }  
	
	@InitBinder("discountForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(discountFormValidator);
	}
	
	@RequestMapping(value = "/createDiscount", method = RequestMethod.POST)
    public String saveDiscount(@ModelAttribute("discountForm") @Validated Discount discount, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveDiscount() : " + discount.toString());
		if (result.hasErrors()) {
			List<String> discTypeList = new ArrayList<String>();
	    	discTypeList.add("Percentage %");
	    	discTypeList.add("Value $");
	    	
	    	model.addAttribute("discTypeList", discTypeList);
			return "createDiscount";
		} else {
			discountManagementService.saveDiscount(discount);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Discount added successfully!");
		}
        return "redirect:listDiscount";  
    }  
	
	@RequestMapping(value = "/deleteDiscount", method = RequestMethod.POST)
	public String deleteDiscount(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listDiscount";
		}
		for (String id : ids) {
			discountManagementService.deleteDiscount(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Discount(s) deleted successfully!");
		return "redirect:listDiscount";
	}
	
	@RequestMapping(value = "/updateDiscount", method = RequestMethod.POST)
	public String getDiscountToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		Discount discount = discountManagementService.findById(new Integer(id));
		logger.debug("Loading update discount page for " + discount.toString());
		List<String> discTypeList = new ArrayList<String>();
    	discTypeList.add("Percentage %");
    	discTypeList.add("Value $");
		
    	model.addAttribute("discTypeList", discTypeList);
		model.addAttribute("discountForm", discount);
		return "updateDiscount";
	}
	
	@RequestMapping(value = "/updateDiscountToDb", method = RequestMethod.POST)
	public String updateDiscount(@ModelAttribute("discountForm") @Validated Discount discount,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateDiscount() : " + discount.toString());
		
		if (result.hasErrors()) {
			return "updateDiscount";
		} else {
			discountManagementService.updateDiscount(discount);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Discount updated successfully!");
		}
		
		return "redirect:listDiscount";
	}
	
	@RequestMapping(value = "/viewDiscount", method = RequestMethod.POST)
	public String viewDiscount(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		Discount discount = discountManagementService.findById(new Integer(id));
		if (discount == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Discount not found");
		}
		model.addAttribute("discount", discount);

		return "viewDiscount";

	}
	
	
}