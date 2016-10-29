package com.JJ.controller.productsubcategorymanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Productsubcategory;
import com.JJ.model.Submodule;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.validator.ProductCategoryFormValidator;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/subcategory")
public class ProductSubCategoryManagementController {
	private static final Logger logger = Logger.getLogger(ProductSubCategoryManagementController.class);
	
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	
	@Autowired
	public ProductSubCategoryManagementController(ProductSubCategoryManagementService productSubCategoryManagementService){
		this.productSubCategoryManagementService = productSubCategoryManagementService;
	}
	
	
	@RequestMapping(value = "/getProductSubCategoryListByCategory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductSubCategoryListByCategory(@RequestParam("productcategoryid") String id, Model model) {
		logger.debug("getting product subcategory list by category");
		List<Productsubcategory> subcategoryList = productSubCategoryManagementService.getAllProductSubCategoryByCategory(new Integer(id));
		return GeneralUtils.convertListToJSONString(subcategoryList);
	}
	

	
	
}
