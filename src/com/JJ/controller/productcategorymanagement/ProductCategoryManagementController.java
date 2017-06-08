package com.JJ.controller.productcategorymanagement;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.validator.ProductCategoryFormValidator;

@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/product/category")
public class ProductCategoryManagementController {
	private static final Logger logger = Logger.getLogger(ProductCategoryManagementController.class);
	
	private ProductCategoryManagementService productCategoryManagementService;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	private ProductService productService;
	private ProductCategoryFormValidator productCategoryFormValidator;
	

	@Autowired
	public ProductCategoryManagementController(ProductCategoryManagementService productCategoryManagementService, 
			ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductService productService,
			ProductCategoryFormValidator productCategoryFormValidator){
		this.productCategoryManagementService = productCategoryManagementService;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productService = productService;
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
		List<ProductCategoryVO> productCategoryList = productCategoryManagementService.getAllCategories();
		return GeneralUtils.convertListToJSONString(productCategoryList);
	}
	
	@RequestMapping(value = "/createProductCategory", method = RequestMethod.GET)
    public String showAddProductCategoryForm(Model model) {  
    	logger.debug("loading showAddProductCategoryForm");
    	ProductCategoryVO productCategoryVO = new ProductCategoryVO();
    	productCategoryVO.setIsParent("1");
    	productCategoryVO.setDisplayInd("1");
    	
    	model.addAttribute("categoryForm", productCategoryVO);
        return "createProductCategory";  
    }  
	
	@InitBinder("categoryForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(productCategoryFormValidator);
	}
	
	@RequestMapping(value = "/createProductCategory", method = RequestMethod.POST)
    public String saveProductCategory(@ModelAttribute("categoryForm") @Validated ProductCategoryVO productCategoryVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
		productCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
		logger.debug("saveProductcategory() : " + productCategoryVO.toString());
		if (result.hasErrors()) {
			return "createProductCategory";
		} else {
			productCategoryManagementService.saveProductCategory(productCategoryVO);
			if(productCategoryVO.getIsParentBoolean()) {
				ProductSubCategoryVO productSubCategoryVO = new ProductSubCategoryVO();
				productSubCategoryVO.setName(productCategoryVO.getCategoryName());
		    	productSubCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
		    	productSubCategoryVO.setCategoryId(new Integer(productCategoryVO.getCategoryId()));
		    	productSubCategoryVO.setDisplayIndBoolean(productCategoryVO.getDisplayIndBoolean());
				productSubCategoryManagementService.saveProductSubCategory(productSubCategoryVO);
			}
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
		ProductCategoryVO productCategoryVO = productCategoryManagementService.findById(new Integer(id));
		if (productCategoryVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		model.addAttribute("categoryForm", productCategoryVO);
		return "updateProductCategory";
	}
	
	@RequestMapping(value = "/updateProductCategory/{id}", method = RequestMethod.GET)
	public String getCategoryToUpdateByRedirect(@PathVariable String id, Model model) {
		logger.debug("id = " + id);
		ProductCategoryVO productCategoryVO = productCategoryManagementService.findById(new Integer(id));
		if (productCategoryVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		model.addAttribute("categoryForm", productCategoryVO);
		return "updateProductCategory";
	}
	
	@RequestMapping(value = "/updateProductCategoryToDb", method = RequestMethod.POST)
	public String updateProductCategory(@ModelAttribute("categoryForm") @Validated ProductCategoryVO productCategoryVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateProductCategory() : " + productCategoryVO.toString());
		
		if (result.hasErrors()) {
			return "updateProductCategory";
		} else {
			ProductCategoryVO currentCategory = productCategoryManagementService.findById(productCategoryVO.getCategoryId());
			if(productCategoryVO.getIsParentBoolean() != currentCategory.getIsParentBoolean()){ // to parent
				//check if have products
				List<ProductSubCategoryVO> subcategoryList = productSubCategoryManagementService.getAllProductSubCategoryByCategory(productCategoryVO.getCategoryId());
				for(ProductSubCategoryVO psc: subcategoryList) {
					List<ProductVO> productList = productService.getAllProductsBySubCategory(psc.getSubCategoryId());
					if(productList.size() > 0){
						redirectAttributes.addFlashAttribute("css", "danger");
						redirectAttributes.addFlashAttribute("msg", "Please remove products from the category!");
						return "redirect:updateProductCategory/" + productCategoryVO.getCategoryId();
						
					}
				}
			}
			
			productCategoryManagementService.updateProductcategory(productCategoryVO);
			if(productCategoryVO.getIsParentBoolean()) {
				productSubCategoryManagementService.deleteProductSubCategoryByCategory(productCategoryVO.getCategoryId());
				ProductSubCategoryVO productSubCategoryVO = new ProductSubCategoryVO();
				productSubCategoryVO.setName(productCategoryVO.getCategoryName());
		    	productSubCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
		    	productSubCategoryVO.setCategoryId(new Integer(productCategoryVO.getCategoryId()));
		    	productSubCategoryVO.setDisplayIndBoolean(productCategoryVO.getDisplayIndBoolean());
				productSubCategoryManagementService.saveProductSubCategory(productSubCategoryVO);
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product Category updated successfully!");
		}
		
		return "redirect:listProductCategory";
	}
	
}
