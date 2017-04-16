package com.JJ.controller.productsubcategorymanagement;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.validator.ProductSubCategoryFormValidator;

@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/product/subcategory")
public class ProductSubCategoryManagementController {
	private static final Logger logger = Logger.getLogger(ProductSubCategoryManagementController.class);
	
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	private ProductCategoryManagementService productCategoryManagementService;
	private ProductSubCategoryFormValidator productSubCategoryFormValidator;
	
	@Autowired
	public ProductSubCategoryManagementController(ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductCategoryManagementService productCategoryManagementService,
			ProductSubCategoryFormValidator productSubCategoryFormValidator){
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productCategoryManagementService = productCategoryManagementService;
		this.productSubCategoryFormValidator = productSubCategoryFormValidator;
	}
	
	
	@RequestMapping(value = "/getProductSubCategoryListByCategory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductSubCategoryListByCategory(@RequestParam("categoryid") String id, Model model) {
		logger.debug("getting product subcategory list by category");
		List<ProductSubCategoryVO> subcategoryList = productSubCategoryManagementService.getAllProductSubCategoryByCategory(new Integer(id));
		return GeneralUtils.convertListToJSONString(subcategoryList);
	}
	
	
	@RequestMapping(value = "/listSubCategory", method = RequestMethod.POST)
	public String listSubCategory(@RequestParam("manageSubCategoryBtn") String id, Model model) {
		logger.debug("id = " + id);
		ProductCategoryVO productCategoryVO = productCategoryManagementService.findById(new Integer(id));
		if (productCategoryVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		model.addAttribute("category", productCategoryVO);
		return "listSubCategory";
	}
	
	@RequestMapping(value = "/listSubCategory/{id}", method = RequestMethod.GET)
	public String listSubCategoryForRedirect(@PathVariable String id, Model model) {
		logger.debug("id = " + id);
		ProductCategoryVO productCategoryVO = productCategoryManagementService.findById(new Integer(id));
		if (productCategoryVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		model.addAttribute("category", productCategoryVO);
		return "listSubCategory";
	}
	
	@RequestMapping(value = "/createSubCategory", method = RequestMethod.POST)
    public String showAddSubCategoryForm(@RequestParam("categoryid") String id, Model model, final RedirectAttributes redirectAttributes) {  
    	logger.debug("loading showAddProductCategoryForm");
    	
    	List<ProductSubCategoryVO> subcategoryList = productSubCategoryManagementService.getAllProductSubCategoryByCategory(new Integer(id));
    	if(subcategoryList.size() >= 10){
    		redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Only 10 subcategory are allowed in each category!");
			return "redirect:listSubCategory/"+id;
    	}
    	ProductSubCategoryVO productSubCategoryVO = new ProductSubCategoryVO();
    	productSubCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
    	productSubCategoryVO.setCategoryId(new Integer(id));
    	productSubCategoryVO.setDisplayInd("1");
    	model.addAttribute("subcategoryForm", productSubCategoryVO);
        return "createSubCategory";  
    }  
	
	@InitBinder("subcategoryForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(productSubCategoryFormValidator);
	}
	
	@RequestMapping(value = "/createSubCategoryToDb", method = RequestMethod.POST)
    public String saveSubCategory(@ModelAttribute("subcategoryForm") @Validated ProductSubCategoryVO productSubCategoryVO, 
    		BindingResult result, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveSubCategory() : " + productSubCategoryVO.toString());
		if (result.hasErrors()) {
			return "createSubCategory";
		} else {
			boolean pass = true;
			List<ProductSubCategoryVO> subcategoryList = productSubCategoryManagementService.getAllProductSubCategoryByCategory(productSubCategoryVO.getCategoryId());
			for(ProductSubCategoryVO psc: subcategoryList){
				if(productSubCategoryVO.getName().equals(psc.getName())) { //if exist name
					result.rejectValue("name", "error.exist.submoduleform.name");;
					pass = false;
					break;
				}
			}
			if(!pass){
				return "createSubCategory";
			}
			productSubCategoryManagementService.saveProductSubCategory(productSubCategoryVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "SubCategory added successfully!");
			
		}
		return "redirect:listSubCategory/"+productSubCategoryVO.getCategoryId();
    }  
	
	@RequestMapping(value = "/deleteSubCategory", method = RequestMethod.POST)
	public String deleteSubCategory(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			@RequestParam("categoryid") String categoryid, 
			Model model, final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listSubCategory/"+categoryid;
		}
		
		for (String id : ids) {
			productSubCategoryManagementService.deleteProductSubCategory(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Subcategory(s) deleted successfully!");
		return "redirect:listSubCategory/"+categoryid;
	}
	
	@RequestMapping(value = "/updateSubCategory", method = RequestMethod.POST)
	public String getSubCategoryToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		ProductSubCategoryVO productSubCategoryVO = productSubCategoryManagementService.findById(new Integer(id));
		logger.debug("Loading update subcategory page for " + productSubCategoryVO.toString());
		
		model.addAttribute("subcategoryForm", productSubCategoryVO);
		
		return "updateSubCategory";
	}
	
	@RequestMapping(value = "/updateSubCategoryToDb", method = RequestMethod.POST)
	public String updateSubCategory(@ModelAttribute("subcategoryForm") @Validated ProductSubCategoryVO productSubCategoryVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateSubCategory() : " + productSubCategoryVO.toString());
		
		if (result.hasErrors()) {
			return "updateSubCategory";
		} else {
			boolean pass = true;
			List<ProductSubCategoryVO> subcategoryList = productSubCategoryManagementService.getAllProductSubCategoryByCategory(productSubCategoryVO.getCategoryId());
			ProductSubCategoryVO currentpsc = productSubCategoryManagementService.findById(productSubCategoryVO.getSubCategoryId());
			for(ProductSubCategoryVO psc: subcategoryList){
				if(!currentpsc.getName().equals(psc.getName()) && productSubCategoryVO.getName().equals(psc.getName())) { //if exist name
					result.rejectValue("name", "error.exist.submoduleform.name");;
					pass = false;
					break;
				}
			}
			if(!pass){
				return "updateSubCategory";
			}
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Subcategory updated successfully!");
		}
		productSubCategoryManagementService.updateProductsubcategory(productSubCategoryVO);
		return "redirect:listSubCategory/"+productSubCategoryVO.getCategoryId();
	}

	
	
}
