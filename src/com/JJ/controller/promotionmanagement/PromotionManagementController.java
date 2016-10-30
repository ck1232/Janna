package com.JJ.controller.promotionmanagement;

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
import com.JJ.model.Promotion;
import com.JJ.service.promotionmanagement.PromotionManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/promotion")
public class PromotionManagementController {
	private static final Logger logger = Logger.getLogger(PromotionManagementController.class);
	
	private PromotionManagementService promotionManagementService;
	
	@Autowired
	public PromotionManagementController(PromotionManagementService promotionManagementService) {
		this.promotionManagementService = promotionManagementService;
	}
	
	
	@RequestMapping("/listPromotion")  
    public String listPromotion() {  
    	logger.debug("loading listPromotion");
        return "listPromotion";  
    }  
	
	@RequestMapping(value = "/getPromotionList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getPromotionList() {
		logger.debug("getting promotion list");
		List<Promotion> promotionList = promotionManagementService.getAllPromotions();
		return GeneralUtils.convertListToJSONString(promotionList);
	}
	
	
}