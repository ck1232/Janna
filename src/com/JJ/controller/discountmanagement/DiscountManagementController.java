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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Discount;
import com.JJ.model.Promotion;
import com.JJ.service.discountmanagement.DiscountManagementService;
import com.JJ.service.promotionmanagement.PromotionManagementService;
import com.JJ.validator.DiscountFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/discount")
public class DiscountManagementController {
	private static final Logger logger = Logger.getLogger(DiscountManagementController.class);
	
	private DiscountManagementService discountManagementService;
	private PromotionManagementService promotionManagementService;
	private DiscountFormValidator discountFormValidator;
	
	@Autowired
	public DiscountManagementController(DiscountManagementService discountManagementService,
			PromotionManagementService promotionManagementService,
			DiscountFormValidator discountFormValidator) {
		this.discountManagementService = discountManagementService;
		this.promotionManagementService = promotionManagementService;
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
    	discount.setDeleteInd(GeneralUtils.NOT_DELETED);
    	
    	List<String> discTypeList = new ArrayList<String>();
    	discTypeList.add("Percentage %");
    	discTypeList.add("Value $");
    	
    	List<String> applyTypeList = new ArrayList<String>();
    	applyTypeList.add("Product");
    	applyTypeList.add("Delivery");
    	applyTypeList.add("Total");
    	
    	model.addAttribute("discTypeList", discTypeList);
    	model.addAttribute("applyTypeList", applyTypeList);
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
	    	
	    	List<String> applyTypeList = new ArrayList<String>();
	    	applyTypeList.add("Product");
	    	applyTypeList.add("Delivery");
	    	applyTypeList.add("Total");
	    	
	    	model.addAttribute("discTypeList", discTypeList);
	    	model.addAttribute("applyTypeList", applyTypeList);
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
		
    	List<String> applyTypeList = new ArrayList<String>();
    	applyTypeList.add("Product");
    	applyTypeList.add("Delivery");
    	applyTypeList.add("Total");
    	
    	model.addAttribute("discTypeList", discTypeList);
    	model.addAttribute("applyTypeList", applyTypeList);
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
	
	@RequestMapping(value = "/manageDiscount", method = RequestMethod.POST)
	public String getDiscountToManage(@RequestParam("editBtn") String id, Model model) {
		
		logger.debug("Loading manage discount page for " + id);
		Promotion promotion = promotionManagementService.findById(new Integer(id));
		model.addAttribute("promotion", promotion);
		return "manageDiscount";
	}
	
	@RequestMapping(value = "/manageDiscount/{id}", method = RequestMethod.GET)
	public String getDiscountToManageForRedirect(@PathVariable String id, Model model) {
		
		logger.debug("Loading manage discount page for " + id);
		Promotion promotion = promotionManagementService.findById(new Integer(id));
		model.addAttribute("promotion", promotion);
		return "manageDiscount";
	}
	
	@RequestMapping(value = "/getDiscountListInPromotion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getDiscountListInPromotion(@RequestParam("promotionid") String id, Model model) {
		logger.debug("getting discount list");
		List<Discount> discountList = discountManagementService.getAllDiscountsInPromotion(new Integer(id));
		return GeneralUtils.convertListToJSONString(discountList);
	}
	
	@RequestMapping(value = "/editDiscountList", method = RequestMethod.POST)
	public String getDiscountListToEdit(@RequestParam("editBtn") String id, Model model) {
		
		logger.debug("Loading edit discount list page for " + id);
		Promotion promotion = promotionManagementService.findById(new Integer(id));
		model.addAttribute("promotion", promotion);
		return "editDiscountList";
	}
	
	@RequestMapping(value = "/getDiscountListNotInPromotion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getDiscountListNotInPromotion(@RequestParam("promotionid") String id, Model model) {
		logger.debug("getting discount list");
		List<Discount> discountList = discountManagementService.getAllDiscountsNotInPromotion(new Integer(id));
		return GeneralUtils.convertListToJSONString(discountList);
	}
	
	@RequestMapping(value = "/addDiscount", method = RequestMethod.POST)
	public String addDiscountToPromo(@RequestParam(value = "checkboxId2", required=false) List<String> ids,
			@RequestParam("promotionid") String promotionid,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:manageDiscount/" + promotionid;
		}
		for (String id : ids) {
			Discount discount = discountManagementService.findById(new Integer(id));
			discount.setPromoid(new Integer(promotionid));
			discountManagementService.updateDiscount(discount);
			logger.debug("added to promotion: "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Discount(s) added successfully!");
		return "redirect:manageDiscount/" + promotionid;
	}
	
	
	
	@RequestMapping(value = "/removeDiscount", method = RequestMethod.POST)
	public String removeDiscountFromPromo(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			@RequestParam("promotionid") String promotionid,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:manageDiscount/" + promotionid;
		}
		for (String id : ids) {
			Discount discount = discountManagementService.findById(new Integer(id));
			discount.setPromoid(0);
			discountManagementService.updateDiscount(discount);
			logger.debug("removed from promotion: "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Discount(s) removed successfully!");
		return "redirect:manageDiscount/" + promotionid;
	}
	
	
	
}