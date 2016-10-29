package com.JJ.controller.productcategorymanagement;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.JJ.model.Productcategory;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.validator.ProductCategoryFormValidator;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/category")
public class ProductCategoryManagementController {
	private static final Logger logger = Logger.getLogger(ProductCategoryManagementController.class);
	
	private ProductCategoryManagementService productCategoryManagementService;
	private ProductCategoryFormValidator productCategoryFormValidator;
	

	@Autowired
	public ProductCategoryManagementController(ProductCategoryManagementService productCategoryManagementService, 
			ProductCategoryFormValidator productCategoryFormValidator){
		this.productCategoryManagementService = productCategoryManagementService;
		this.productCategoryFormValidator = productCategoryFormValidator;
	}
	
	@RequestMapping("/listProductCategory")  
    public String listProductCategory(HttpSession session) {  
    	logger.debug("loading listProductCategory");
        return "listProductCategory";  
    } 
	
	@RequestMapping(value = "/getProductCategoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductCategoryList() {
		logger.debug("getting Product Category list");
		List<Productcategory> productCategoryList = productCategoryManagementService.getAllCategories();
		if(productCategoryList != null){
			for(Productcategory category: productCategoryList) {
				category.setDisplayindString();
				category.setIsparentString();
			}
		}
		
		
		return GeneralUtils.convertListToJSONString(productCategoryList);
	}
	
	@RequestMapping(value = "/createProductCategory", method = RequestMethod.GET)
    public String showAddProductCategoryForm(Model model) {  
    	logger.debug("loading showAddProductCategoryForm");
    	Productcategory productcategory = new Productcategory();
    	productcategory.setDisplayind(true);
    	
    	
    	model.addAttribute("categoryForm", productcategory);
        return "createProductCategory";  
    }  
	
	@InitBinder("categoryForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(productCategoryFormValidator);
	}
	
	@RequestMapping(value = "/createProductCategory", method = RequestMethod.POST)
    public String saveProductCategory(@ModelAttribute("categoryForm") @Validated Productcategory productcategory, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
		productcategory.setIsparent(false);
		productcategory.setDeleteind(GeneralUtils.NOT_DELETED);
		logger.debug("saveProductcategory() : " + productcategory.toString());
		if (result.hasErrors()) {
			return "createProductCategory";
		} else {
			productCategoryManagementService.saveProductCategory(productcategory);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product Category added successfully!");
		}
		
		
        return "redirect:listProductCategory";  
    }  
	
	@RequestMapping(value = "/deleteProductCategory", method = RequestMethod.POST)
	public String deleteProductCategory(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listProductCategory";
		}
		for (String id : ids) {
			productCategoryManagementService.deleteProductCategory(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Product Category(s) deleted successfully!");
		return "redirect:listProductCategory";
	}
	
	
	
	@RequestMapping(value = "/updateProductCategory", method = RequestMethod.POST)
	public String getCategoryToUpdate(@RequestParam("editBtn") String id, Model model) {
		logger.debug("id = " + id);
		Productcategory productcategory = productCategoryManagementService.findById(new Integer(id));
		if (productcategory == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		model.addAttribute("categoryForm", productcategory);
		return "updateProductCategory";
	}
	
	@RequestMapping(value = "/updateProductCategoryToDb", method = RequestMethod.POST)
	public String updateProductCategory(@ModelAttribute("categoryForm") @Validated Productcategory productcategory,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateProductCategory() : " + productcategory.toString());
		
		if (result.hasErrors()) {
			return "updateProductCategory";
		} else {
			productCategoryManagementService.updateProductcategory(productcategory);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product Category updated successfully!");
		}
		
		return "redirect:listProductCategory";
	}
	
	/*
	@RequestMapping(value = "/updateModule/{id}", method = RequestMethod.GET)
	public String getModuleToUpdateForRedirect(@PathVariable String id, Model model) {
		logger.debug("id = " + id);
		Module module = moduleManagementService.findById(new Integer(id));
		if (module == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Module not found");
		}
		model.addAttribute("module", module);
		return "updateModule";
	}*/
}
