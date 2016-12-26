package com.JJ.controller.productoptionmanagement;

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
import com.JJ.model.Productoption;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.validator.ProductOptionFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/option")
public class ProductOptionManagementController {
	private static final Logger logger = Logger.getLogger(ProductOptionManagementController.class);
	
	private ProductOptionManagementService productOptionManagementService;
	private ProductOptionFormValidator productOptionFormValidator;
	
	@Autowired
	public ProductOptionManagementController(ProductOptionManagementService productOptionManagementService,
			ProductOptionFormValidator productOptionFormValidator) {
		this.productOptionManagementService = productOptionManagementService;
		this.productOptionFormValidator = productOptionFormValidator;
	}
	
	
	@RequestMapping("/listProductOption")  
    public String listProductOption() {  
    	logger.debug("loading listProductOption");
        return "listProductOption";  
    }  
	
	@RequestMapping(value = "/getProductOptionList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductOptionList() {
		logger.debug("getting productOption list");
		List<Productoption> optionList = productOptionManagementService.getDistinctProductoptions();
		return GeneralUtils.convertListToJSONString(optionList);
	}
	
	@RequestMapping(value = "/createProductOption", method = RequestMethod.GET)
    public String showAddProductOptionForm(Model model) {  
    	logger.debug("loading showAddProductOptionForm");
    	Productoption productoption = new Productoption();
    	productoption.setDisplayind(true);
    	model.addAttribute("productOptionForm", productoption);
        return "createProductOption";  
    }  
	
	@InitBinder("productOptionForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(productOptionFormValidator);
	}
	
	@RequestMapping(value = "/createProductOption", method = RequestMethod.POST)
    public String saveProductOption(@ModelAttribute("productOptionForm") @Validated Productoption productoption, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveProductOption() : " + productoption.toString());
		if (result.hasErrors()) {
			return "createProductOption";
		} else {
			List<Productoption> optionList = productOptionManagementService.getAllProductoptions();
			for(Productoption o: optionList){
				if(productoption.getName().equals(o.getName())) { //if exist name
					result.rejectValue("name", "error.exist.productoptionform.name");
					return "createProductOption";
				}
			}
			productoption.setDeleteind(GeneralUtils.NOT_DELETED);
			for(int i = 1 ; i <= GeneralUtils.SIZE_PER_PRODUCT_OPTION ; i++) {
				productoption.setProductoptionid(null);
				productOptionManagementService.saveProductoption(productoption);
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product option added successfully!");
		}
		
		
        return "redirect:listProductOption";  
    }  
	
	
	@RequestMapping(value = "/deleteProductOption", method = RequestMethod.POST)
	public String deleteProductOption(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listProductOption";
		}
		for (String id : ids) {
			Productoption option = productOptionManagementService.findById(new Integer(id));
			List<Productoption> optionList = productOptionManagementService.getAllProductoptionsByName(option.getName());
			for(Productoption o: optionList){
				productOptionManagementService.deleteProductoption(o);
				logger.debug("deleted "+ o.getProductoptionid());
			}
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Product Option(s) deleted successfully!");
		return "redirect:listProductOption";
	}
	
	@RequestMapping(value = "/updateProductOption", method = RequestMethod.POST)
	public String getProductOptionToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		Productoption option = productOptionManagementService.findById(new Integer(id));
		logger.debug("Loading update product option page for " + option.toString());
		
		model.addAttribute("productOptionForm", option);
		
		return "updateProductOption";
	}
	
	@RequestMapping(value = "/updateProductOptionToDb", method = RequestMethod.POST)
	public String updateProductOption(@ModelAttribute("productOptionForm") @Validated Productoption option,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateProductOption() : " + option.toString());
		
		if (result.hasErrors()) {
			return "updateProductOption";
		} else {
			List<Productoption> optionList = productOptionManagementService.getAllProductoptions();
			Productoption currentOption = productOptionManagementService.findById(option.getProductoptionid());
			for(Productoption o: optionList){
				if(!currentOption.getName().equals(o.getName()) && option.getName().equals(o.getName())) { //if exist name
					result.rejectValue("name", "error.exist.productoptionform.name");
					return "updateProductOption";
				}
			}
			List<Productoption> optionListByName = productOptionManagementService.getAllProductoptionsByName(currentOption.getName());
			for(Productoption o: optionListByName){
				o.setName(option.getName());
				o.setDisplayind(option.getDisplayind());
				productOptionManagementService.updateProductoption(o);
				logger.debug("updated "+ o.getProductoptionid());
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product Option updated successfully!");
		}
		
		
		return "redirect:listProductOption";
	}
	
}