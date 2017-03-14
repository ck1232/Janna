package com.JJ.controller.employeemanagement;

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

import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.employeemanagement.EmployeeManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
import com.JJ.validator.EmployeeFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/employee")
public class EmployeeManagementController {
	private static final Logger logger = Logger.getLogger(EmployeeManagementController.class);
	
	private EmployeeManagementService employeeManagementService;
	private SalaryBonusManagementService salaryBonusManagementService;
	private EmployeeFormValidator employeeFormValidator;
	
	Map<String,String> employmentTypeList;
	
	@Autowired
	public EmployeeManagementController(EmployeeManagementService employeeManagementService,
			SalaryBonusManagementService salaryBonusManagementService,
			EmployeeFormValidator employeeFormValidator) {
		this.employeeManagementService = employeeManagementService;
		this.salaryBonusManagementService = salaryBonusManagementService;
		this.employeeFormValidator = employeeFormValidator;
	}
	
	
	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)  
    public String listEmployee(Model model) {  
    	logger.debug("loading listEmployee");
        return "listEmployee";  
    }

	
	@RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getEmployeeList() {
		logger.debug("getting employee list");
		List<EmployeeVo> employeeList = employeeManagementService.getAllEmployeeVo();
		return GeneralUtils.convertListToJSONString(employeeList);
	}
	
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listEmployee";
		}
		for (String id : ids) {
			employeeManagementService.deleteEmployee(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Employee(s) deleted successfully!");
		return "redirect:listEmployee";
	}
	
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {  
    	logger.debug("loading showAddEmployeeForm");
    	EmployeeVo employeeVo = new EmployeeVo();
    	initData();
    	model.addAttribute("employeeForm", employeeVo);
    	model.addAttribute("employmentTypeList", employmentTypeList);
        return "createEmployee";  
    }  
	
	//initialise for employment type dropdown
	private void initData(){
		employmentTypeList = new LinkedHashMap<String,String>();
    	employmentTypeList.put(EmploymentTypeEnum.FULL_LOCAL.toString(), EmploymentTypeEnum.FULL_LOCAL.getType());
    	employmentTypeList.put(EmploymentTypeEnum.FULL_FW.toString(), EmploymentTypeEnum.FULL_FW.getType());
    	employmentTypeList.put(EmploymentTypeEnum.PART_LOCAL.toString(), EmploymentTypeEnum.PART_LOCAL.getType());
    	employmentTypeList.put(EmploymentTypeEnum.PART_FW.toString(), EmploymentTypeEnum.PART_FW.getType());
	}
	
	@InitBinder("employeeForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeFormValidator);
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employeeForm") @Validated EmployeeVo employeeVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("saveEmployee() : " + employeeVo.toString());
		if (result.hasErrors()) {
			initData();
	    	model.addAttribute("employmentTypeList", employmentTypeList);
			return "createEmployee";
		} else {
			try{
				employeeVo.setDob(GeneralUtils.convertStringToDate(employeeVo.getDobString(), "dd/MM/yyyy"));
				employeeVo.setEmploystartdate(GeneralUtils.convertStringToDate(employeeVo.getEmploystartdateString(), "dd/MM/yyyy"));
				employeeVo.setEmployenddate(GeneralUtils.convertStringToDate(employeeVo.getEmployenddateString(), "dd/MM/yyyy"));
				employeeVo.setCdacind(employeeVo.getCdacindBoolean() == Boolean.TRUE ? "Y" : "N");
			}catch(Exception e) {
				logger.info("Error parsing date string");
			}
			employeeManagementService.saveEmployee(employeeVo);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Employee added successfully!");
		}
        return "redirect:listEmployee";  
    }  
	
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.POST)
	public String viewEmployee(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		EmployeeVo employeeVo = employeeManagementService.getEmployeeById(new Integer(id));
		if (employeeVo == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Employee not found");
		}else{
			model.addAttribute("employee", employeeVo);
			List<SalaryBonusVo> salaryList = salaryBonusManagementService.getAllSalaryByEmpId(employeeVo.getEmployeeid());
			model.addAttribute("salaryList", salaryList);
			List<SalaryBonusVo> bonusList = salaryBonusManagementService.getAllBonusByEmpId(employeeVo.getEmployeeid());
			model.addAttribute("bonusList", bonusList);
		}
		return "viewEmployee";

	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String getEmployeeToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		EmployeeVo employeeVo = employeeManagementService.getEmployeeById(new Integer(id));
		logger.debug("Loading update employee page for " + employeeVo.toString());
		initData();
		model.addAttribute("employmentTypeList", employmentTypeList);
		model.addAttribute("employeeForm", employeeVo);
		return "updateEmployee";
	}
	
	@RequestMapping(value = "/updateEmployeeToDb", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employeeForm") @Validated EmployeeVo employeeVo,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateEmployee() : " + employeeVo.toString());
		
		if (result.hasErrors()) {
			initData();
			model.addAttribute("employmentTypeList", employmentTypeList);
			return "updateEmployee";
		} else {
			employeeManagementService.updateEmployee(employeeVo);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Expense updated successfully!");
		}
		
		return "redirect:listEmployee";
	}
	
	

}