package com.JJ.controller.productoptionmanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Productoption;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/option")
public class ProductOptionManagementController {
	private static final Logger logger = Logger.getLogger(ProductOptionManagementController.class);
	
	private ProductOptionManagementService productOptionManagementService;
	
	@Autowired
	public ProductOptionManagementController(ProductOptionManagementService productOptionManagementService) {
		this.productOptionManagementService = productOptionManagementService;
	}
	
	
	@RequestMapping("/listProductOption")  
    public String listProductOption() {  
    	logger.debug("loading listProductOption");
        return "listProductOption";  
    }  
	
	@RequestMapping(value = "/getProductOptionList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductOptionList() {
		logger.debug("getting promotion list");
		List<Productoption> promotionList = productOptionManagementService.getAllProductoptions();
		return GeneralUtils.convertListToJSONString(promotionList);
	}
	
	
}