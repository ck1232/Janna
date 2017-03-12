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

import com.JJ.controller.invoicemanagement.InvoiceStatusEnum;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Employee;
import com.JJ.service.employeemanagement.EmployeeManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/employee")
public class EmployeeManagementController {
	private static final Logger logger = Logger.getLogger(EmployeeManagementController.class);
	
	private EmployeeManagementService employeeManagementService;
	
	Map<String,String> employmentTypeList;
	
	@Autowired
	public EmployeeManagementController(EmployeeManagementService employeeManagementService) {
		this.employeeManagementService = employeeManagementService;
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
    	employmentTypeList = new LinkedHashMap<String,String>();
    	employmentTypeList.put(EmploymentTypeEnum.FULL_LOCAL.toString(), EmploymentTypeEnum.FULL_LOCAL.getType());
    	employmentTypeList.put(EmploymentTypeEnum.FULL_FW.toString(), EmploymentTypeEnum.FULL_FW.getType());
    	employmentTypeList.put(EmploymentTypeEnum.PART_LOCAL.toString(), EmploymentTypeEnum.PART_LOCAL.getType());
    	employmentTypeList.put(EmploymentTypeEnum.PART_FW.toString(), EmploymentTypeEnum.PART_FW.getType());
    	model.addAttribute("employeeForm", employeeVo);
    	model.addAttribute("employmentTypeList", employmentTypeList);
        return "createEmployee";  
    }  
	
	@InitBinder("employeeForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeFormValidator);
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("expenseForm") @Validated Employee employee, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("saveEmployee() : " + employee.toString());
		if (result.hasErrors()) {
			Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
	    	model.addAttribute("expenseTypeList", expenseTypeList);
			return "createExpense";
		} else {
			try{
				expense.setExpensedate(new SimpleDateFormat("dd/MM/yyyy").parse(expense.getExpensedateString()));
			}catch(Exception e) {
				logger.info("Error parsing expense date string");
			}
			expenseManagementService.saveExpense(expense);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Expense added successfully!");
		}
        return "redirect:listExpense";  
    }  
	
	/*
	@RequestMapping(value = "/viewExpense", method = RequestMethod.POST)
	public String viewExpense(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		Expense expense = expenseManagementService.findById(new Integer(id));
		if (expense == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Expense not found");
		}else{
			expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpensetypeid()));
			expense.setExpensedateString(new SimpleDateFormat("dd/MM/yyyy").format(expense.getExpensedate()));
			model.addAttribute("expense", expense);
			List<Paymentdetail> paymentList = paymentManagementService.getAllPaymentByRefTypeAndRefId("expense", expense.getExpenseid());
			if(paymentList != null && paymentList.size() > 0){
				for(Paymentdetail payment : paymentList) {
					payment.setPaymentdateString(new SimpleDateFormat("dd/MM/yyyy").format(payment.getPaymentdate()));
					payment.setPaymentmodeString(paymentModeLookup.getPaymentModeById(payment.getPaymentmode()));
				}
			}
			model.addAttribute("paymentList", paymentList);
		}
		return "viewExpense";

	}
	
	@RequestMapping(value = "/updateExpense", method = RequestMethod.POST)
	public String getExpenseToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		Expense expense = expenseManagementService.findById(new Integer(id));
		logger.debug("Loading update expense page for " + expense.toString());
		expense.setExpensedateString(new SimpleDateFormat("dd/MM/yyyy").format(expense.getExpensedate()));
		
		Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
    	model.addAttribute("expenseTypeList", expenseTypeList);
		model.addAttribute("expenseForm", expense);
		return "updateExpense";
	}
	
	@RequestMapping(value = "/updateExpenseToDb", method = RequestMethod.POST)
	public String updateExpense(@ModelAttribute("expenseForm") @Validated Expense expense,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateExpense() : " + expense.toString());
		
		if (result.hasErrors()) {
			Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
	    	model.addAttribute("expenseTypeList", expenseTypeList);
			return "updateExpense";
		} else {
			try{
				expense.setExpensedate(new SimpleDateFormat("dd/MM/yyyy").parse(expense.getExpensedateString()));
			}catch(Exception e) {
				logger.info("Error parsing expense date string");
			}
			expenseManagementService.updateExpense(expense);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Expense updated successfully!");
		}
		
		return "redirect:listExpense";
	}*/
	
	

}