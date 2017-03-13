package com.JJ.controller.salarybonusmanagement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.JJ.controller.employeemanagement.EmployeeVo;
import com.JJ.controller.paymentmanagement.PaymentManagementController;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.employeemanagement.EmployeeManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
import com.JJ.validator.SalaryBonusFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/salarybonus")
public class SalaryBonusManagementController {
	private static final Logger logger = Logger.getLogger(SalaryBonusManagementController.class);
	
	private PaymentManagementController paymentManagementController;
	private SalaryBonusManagementService salaryBonusManagementService;
	private EmployeeManagementService employeeManagementService;
	private SalaryBonusFormValidator salaryBonusFormValidator;
	
	Map<Integer,String> employeeList;
	Map<String,String> typeList;
	
	@Autowired
	public SalaryBonusManagementController(PaymentManagementController paymentManagementController,
			SalaryBonusManagementService salaryBonusManagementService,
			EmployeeManagementService employeeManagementService,
			SalaryBonusFormValidator salaryBonusFormValidator) {
		this.paymentManagementController = paymentManagementController;
		this.salaryBonusManagementService = salaryBonusManagementService;
		this.employeeManagementService = employeeManagementService;
		this.salaryBonusFormValidator = salaryBonusFormValidator;
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
	
	@RequestMapping(value = "/deleteSalaryBonus", method = RequestMethod.POST)
	public String deleteSalaryBonus(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listSalaryBonus";
		}
		salaryBonusManagementService.deleteSalaryBonus(ids);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Salary/Bonus(s) deleted successfully!");
		return "redirect:listSalaryBonus";
	}
	
	@RequestMapping(value = "/createSalaryBonus", method = RequestMethod.GET)
    public String showAddSalaryBonusForm(Model model) {  
    	logger.debug("loading showAddSalaryBonusForm");
    	SalaryBonusVo salaryBonusVo = new SalaryBonusVo();
    	initData();
    	model.addAttribute("salaryBonusForm", salaryBonusVo);
    	model.addAttribute("employeeList", employeeList);
    	model.addAttribute("typeList", typeList);
        return "createSalaryBonus";  
    }  
	
	//initialise for employment type dropdown
	private void initData(){
		employeeList = new LinkedHashMap<Integer,String>();
		List<EmployeeVo> voList = employeeManagementService.getAllEmployeeVoInAscendingName();
		if(voList != null && voList.size() > 0){
			for(EmployeeVo vo : voList) {
				employeeList.put(vo.getEmployeeid(), vo.getName());
			}
		}
		typeList = new LinkedHashMap<String,String>(); 
		typeList.put(TypeEnum.SALARY.toString(),TypeEnum.SALARY.getType());
		typeList.put(TypeEnum.BONUS.toString(),TypeEnum.BONUS.getType());
	}
	
	@InitBinder("salaryBonusForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(salaryBonusFormValidator);
	}
	
	@RequestMapping(value = "/createSalaryBonus", method = RequestMethod.POST)
    public String saveSalaryBonus(@ModelAttribute("salaryBonusForm") @Validated SalaryBonusVo salaryBonusVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("saveSalaryBonus() : " + salaryBonusVo.toString());
		if (result.hasErrors()) {
			initData();
			model.addAttribute("employeeList", employeeList);
	    	model.addAttribute("typeList", typeList);
			return "createSalaryBonus";
		} else {
			salaryBonusVo.setDate(GeneralUtils.convertStringToDate(salaryBonusVo.getDateString(), "dd/MM/yyyy"));
			salaryBonusManagementService.saveSalaryBonus(salaryBonusVo);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Salary/Bonus added successfully!");
		}
        return "redirect:listSalaryBonus";  
    }  
	
	@RequestMapping(value = "/createSalaryBonusAndPay", method = RequestMethod.POST)
    public String saveSalaryBonusAndPay(@ModelAttribute("salaryBonusForm") @Validated SalaryBonusVo salaryBonusVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		List<String> idList = new ArrayList<String>();
		logger.debug("saveSalaryBonus() : " + salaryBonusVo.toString());
		if (result.hasErrors()) {
			initData();
			model.addAttribute("employeeList", employeeList);
	    	model.addAttribute("typeList", typeList);
			return "createSalaryBonus";
		} else {
			salaryBonusVo.setDate(GeneralUtils.convertStringToDate(salaryBonusVo.getDateString(), "dd/MM/yyyy"));
			salaryBonusManagementService.saveSalaryBonus(salaryBonusVo);
			
		}

		idList.add(salaryBonusVo.getId().toString());
		if(salaryBonusVo.getType().equals(TypeEnum.SALARY.toString())) {
			return paymentManagementController.createPaySalary(idList, redirectAttributes, model);
		}else if(salaryBonusVo.getType().equals(TypeEnum.BONUS.toString())) {
			return paymentManagementController.createPayBonus(idList, redirectAttributes, model);
		}
		return "redirect:listSalaryBonus";
    }  
	
	@RequestMapping(value = "/paySalaryBonus", method = RequestMethod.POST)
    public String paySalaryBonus(@RequestParam("payBtn") String id, Model model,
    		final RedirectAttributes redirectAttributes) {
		String[] idArray = id.split(",");
		List<String> idList = new ArrayList<String>();
		idList.add(idArray[0]);
		if(idArray[1].equals(TypeEnum.SALARY.getType())) {
			return paymentManagementController.createPaySalary(idList, redirectAttributes, model);
		}else if(idArray[1].equals(TypeEnum.BONUS.getType())) {
			return paymentManagementController.createPayBonus(idList, redirectAttributes, model);
		}
		return "redirect:listSalaryBonus";
    } 
	
	
}