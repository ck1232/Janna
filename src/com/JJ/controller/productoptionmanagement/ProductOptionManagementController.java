package com.JJ.controller.productoptionmanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.validator.ProductOptionFormValidator;


@Controller  
@EnableWebMvc
@Scope("request")
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
		List<ProductOptionVO> optionList = productOptionManagementService.getAllProductoptions();
		return GeneralUtils.convertListToJSONString(optionList);
	}
	
	@RequestMapping(value = "/createProductOption", method = RequestMethod.GET)
    public String showAddProductOptionForm(Model model) {  
    	logger.debug("loading showAddProductOptionForm");
    	ProductOptionVO productOptionVO = new ProductOptionVO();
    	productOptionVO.setDisplayInd("1");
    	model.addAttribute("productOptionForm", productOptionVO);
        return "createProductOption";  
    }  
	
	@InitBinder("productOptionForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(productOptionFormValidator);
	}
	
	@RequestMapping(value = "/createProductOption", method = RequestMethod.POST)
    public String saveProductOption(@ModelAttribute("productOptionForm") @Validated ProductOptionVO productOptionVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveProductOption() : " + productOptionVO.toString());
		if (result.hasErrors()) {
			return "createProductOption";
		} else {
			List<ProductOptionVO> productOptionVOList = productOptionManagementService.getAllProductoptions();
			for(ProductOptionVO o: productOptionVOList){
				if(productOptionVO.getName().equals(o.getName())) { //if exist name
					result.rejectValue("name", "error.exist.productoptionform.name");
					return "createProductOption";
				}
			}
			productOptionVO.setDeleteInd(GeneralUtils.NOT_DELETED);
			productOptionManagementService.saveProductoption(productOptionVO);
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
			ProductOptionVO option = productOptionManagementService.findById(new Integer(id));
			List<ProductOptionVO> optionList = productOptionManagementService.getAllProductoptionsByName(option.getName());
			for(ProductOptionVO o: optionList){
				productOptionManagementService.deleteProductoption(o);
				logger.debug("deleted "+ o.getProductOptionId());
			}
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Product Option(s) deleted successfully!");
		return "redirect:listProductOption";
	}
	
	@RequestMapping(value = "/updateProductOption", method = RequestMethod.POST)
	public String getProductOptionToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		ProductOptionVO option = productOptionManagementService.findById(new Integer(id));
		logger.debug("Loading update product option page for " + option.toString());
		
		model.addAttribute("productOptionForm", option);
		
		return "updateProductOption";
	}
	
	@RequestMapping(value = "/updateProductOptionToDb", method = RequestMethod.POST)
	public String updateProductOption(@ModelAttribute("productOptionForm") @Validated ProductOptionVO productOptionVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateProductOption() : " + productOptionVO.toString());
		
		if (result.hasErrors()) {
			return "updateProductOption";
		} else {
			if(productOptionVO.getDisplayInd() == null){
				productOptionVO.setDisplayInd(GeneralUtils.NOT_ALLOW_DISPLAY);
			}
			List<ProductOptionVO> optionList = productOptionManagementService.getAllProductoptions();
			ProductOptionVO currentOption = productOptionManagementService.findById(productOptionVO.getProductOptionId());
			for(ProductOptionVO o: optionList){
				if(!currentOption.getName().equals(o.getName()) && productOptionVO.getName().equals(o.getName())) { //if exist name
					result.rejectValue("name", "error.exist.productoptionform.name");
					return "updateProductOption";
				}
			}
			List<ProductOptionVO> optionListByName = productOptionManagementService.getAllProductoptionsByName(currentOption.getName());
			for(ProductOptionVO o: optionListByName){
				o.setName(productOptionVO.getName());
				o.setDisplayInd(productOptionVO.getDisplayInd());
				productOptionManagementService.updateProductoption(o);
				logger.debug("updated "+ o.getProductOptionId());
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product Option updated successfully!");
		}
		
		
		return "redirect:listProductOption";
	}
	
}