package com.JJ.controller.productmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.Productcategory;
import com.JJ.model.Productsubcategory;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/product")
public class ProductManagementController {
	private static final Logger logger = Logger.getLogger(ProductManagementController.class);
	private ProductService productService;
	private ProductCategoryManagementService productCategoryManagementService;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	
	@Autowired
	public ProductManagementController(ProductService productService, ProductCategoryManagementService productCategoryManagementService,
			ProductSubCategoryManagementService productSubCategoryManagementService){
		this.productService = productService;
		this.productCategoryManagementService = productCategoryManagementService;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
	}
	
	public List<Productcategory> getProductCategoryList(){
		List<Productcategory> categoryList = productCategoryManagementService.getAllCategories();
		if(categoryList != null && categoryList.size() > 0){
			List<Productsubcategory> subcategoryList = productSubCategoryManagementService.getAllSubCategories();
			if(subcategoryList != null && subcategoryList.size() > 0){
				Map<Integer, List<Productsubcategory>> subcategoryMap = new HashMap<Integer, List<Productsubcategory>>();
				for(Productsubcategory subcategory : subcategoryList){
					if(!subcategoryMap.containsKey(subcategory.getProductcategoryid())){
						subcategoryMap.put(subcategory.getProductcategoryid(), new ArrayList<Productsubcategory>());
					}
					subcategoryMap.get(subcategory.getProductcategoryid()).add(subcategory);
				}
				for(Productcategory category : categoryList){
					category.setSubcategoryList(subcategoryMap.get(category.getId()));
				}
			}
			return categoryList;
		}else{
			return new ArrayList<Productcategory>();
		}
	}
	
	@RequestMapping("/listProduct")  
    public String listProduct(HttpSession session) {  
    	logger.debug("loading listProduct");
        return "listProduct";  
    } 
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductList() {
		logger.debug("getting Product list");
		List<Product> productList = productService.getAllProducts();
		return GeneralUtils.convertListToJSONString(productList);
	}
	
	@RequestMapping("/createProduct")
	public String createProduct(Model model){
		logger.debug("loading create product");
		Product product = new Product();
		model.addAttribute("productForm", product);
		model.addAttribute("categoryList", getProductCategoryList());
		return "createProduct";
	}
	
}
