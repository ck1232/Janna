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

import com.JJ.controller.employeemanagement.vo.EmployeeVO;
import com.JJ.controller.paymentmanagement.PaymentManagementController;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
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
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllSalaryBonusVo();
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
    	SalaryBonusVO salaryBonusVo = new SalaryBonusVO();
    	initData();
    	model.addAttribute("salaryBonusForm", salaryBonusVo);
    	model.addAttribute("employeeList", employeeList);
    	model.addAttribute("typeList", typeList);
        return "createSalaryBonus";  
    }  
	
	//initialise for employment type dropdown
	private void initData(){
		employeeList = new LinkedHashMap<Integer,String>();
		List<EmployeeVO> voList = employeeManagementService.getAllEmployeeInAscendingName();
		if(voList != null && voList.size() > 0){
			for(EmployeeVO vo : voList) {
				employeeList.put(vo.getEmployeeId(), vo.getName());
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
    public String saveSalaryBonus(@ModelAttribute("salaryBonusForm") @Validated SalaryBonusVO salaryBonusVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("saveSalaryBonus() : " + salaryBonusVO.toString());
		if (result.hasErrors()) {
			initData();
			model.addAttribute("employeeList", employeeList);
	    	model.addAttribute("typeList", typeList);
			return "createSalaryBonus";
		} else {
			salaryBonusVO.setDate(GeneralUtils.convertStringToDate(salaryBonusVO.getDateString(), "dd/MM/yyyy"));
			salaryBonusManagementService.saveSalaryBonus(salaryBonusVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Salary/Bonus added successfully!");
		}
        return "redirect:listSalaryBonus";  
    }  
	
	@RequestMapping(value = "/createSalaryBonusAndPay", method = RequestMethod.POST)
    public String saveSalaryBonusAndPay(@ModelAttribute("salaryBonusForm") @Validated SalaryBonusVO salaryBonusVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		List<String> idList = new ArrayList<String>();
		logger.debug("saveSalaryBonus() : " + salaryBonusVO.toString());
		if (result.hasErrors()) {
			initData();
			model.addAttribute("employeeList", employeeList);
	    	model.addAttribute("typeList", typeList);
			return "createSalaryBonus";
		} else {
			salaryBonusVO.setDate(GeneralUtils.convertStringToDate(salaryBonusVO.getDateString(), "dd/MM/yyyy"));
			salaryBonusManagementService.saveSalaryBonus(salaryBonusVO);
			
		}

		idList.add(salaryBonusVO.getId().toString());
		if(salaryBonusVO.getType().equals(TypeEnum.SALARY.toString())) {
			return paymentManagementController.createPaySalary(idList, redirectAttributes, model);
		}else if(salaryBonusVO.getType().equals(TypeEnum.BONUS.toString())) {
			return paymentManagementController.createPayBonus(idList, redirectAttributes, model);
		}
		return "redirect:listSalaryBonus";
    }  
	
	@RequestMapping(value = "/updateSalaryBonus", method = RequestMethod.POST)
	public String getSalaryBonusToUpdate(@RequestParam("editBtn") String id, Model model) {
		SalaryBonusVO salaryBonusVO = null;
		String[] splitId = id.split("-");
		if(splitId[0] != null && splitId[1] != null){
			if(splitId[1].toLowerCase().equals("salary")) {
				salaryBonusVO = salaryBonusManagementService.findSalaryById(Integer.valueOf(splitId[0]));
			}else if(splitId[1].toLowerCase().equals("bonus")) {
				salaryBonusVO = salaryBonusManagementService.findBonusById(Integer.valueOf(splitId[0]));
			}
		}
		salaryBonusVO.setDateString(GeneralUtils.convertDateToString(salaryBonusVO.getDate(), "dd/MM/yyyy"));

		logger.debug("Loading update salary bonus page for " + salaryBonusVO.toString());
		initData();
		model.addAttribute("salaryBonusForm", salaryBonusVO);
    	model.addAttribute("employeeList", employeeList);
    	model.addAttribute("typeList", typeList);
		return "updateSalaryBonus";
	}
	
	@RequestMapping(value = "/updateSalaryBonusToDb", method = RequestMethod.POST)
	public String updateSalaryBonus(@ModelAttribute("salaryBonusForm") @Validated SalaryBonusVO salaryBonusVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateSalaryBonus() : " + salaryBonusVO.toString());
		
		if (result.hasErrors()) {
			initData();
	    	model.addAttribute("employeeList", employeeList);
	    	model.addAttribute("typeList", typeList);
			return "updateSalaryBonus";
		} else {
			salaryBonusManagementService.updateSalaryBonus(salaryBonusVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Salary/Bonus updated successfully!");
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