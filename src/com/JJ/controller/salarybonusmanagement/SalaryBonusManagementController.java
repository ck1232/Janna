package com.JJ.controller.salarybonusmanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/salarybonus")
public class SalaryBonusManagementController {
	private static final Logger logger = Logger.getLogger(SalaryBonusManagementController.class);
	
	private SalaryBonusManagementService salaryBonusManagementService;
	
	@Autowired
	public SalaryBonusManagementController(SalaryBonusManagementService salaryBonusManagementService) {
		this.salaryBonusManagementService = salaryBonusManagementService;
	}
	
	@RequestMapping("/listSalaryBonus")  
    public String listSalaryBonus() {  
    	logger.debug("loading listSalaryBonus");
        return "listSalaryBonus";  
    }  
	
	@RequestMapping(value = "/getSalaryBonusList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSalaryBonusList() {
		logger.debug("getting salary and bonus list");
		List<SalaryBonusVo> salaryBonusVoList = salaryBonusManagementService.getAllSalaryBonusVo();
		return GeneralUtils.convertListToJSONString(salaryBonusVoList);
	}
	
}