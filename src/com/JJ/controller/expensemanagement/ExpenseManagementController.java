package com.JJ.controller.expensemanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.JJ.controller.paymentmanagement.PaymentManagementController;
import com.JJ.helper.GeneralUtils;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.lookup.PaymentModeLookup;
import com.JJ.model.Expense;
import com.JJ.model.Paymentdetail;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.validator.ExpenseFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/expense")
public class ExpenseManagementController {
	private static final Logger logger = Logger.getLogger(ExpenseManagementController.class);
	
	private ExpenseManagementService expenseManagementService;
	private PaymentManagementService paymentManagementService;
	private PaymentManagementController paymentManagementController;
	private ExpenseTypeLookup expenseTypeLookup;
	private PaymentModeLookup paymentModeLookup;
	private ExpenseFormValidator expenseFormValidator;
	@Autowired
	public ExpenseManagementController(ExpenseManagementService expenseManagementService, 
			PaymentManagementService paymentManagementService,
			PaymentManagementController paymentManagementController,
			ExpenseTypeLookup expenseTypeLookup,
			PaymentModeLookup paymentModeLookup,
			ExpenseFormValidator expenseFormValidator) {
		this.expenseManagementService = expenseManagementService;
		this.paymentManagementService = paymentManagementService;
		this.expenseTypeLookup = expenseTypeLookup;
		this.paymentModeLookup = paymentModeLookup;
		this.expenseFormValidator = expenseFormValidator;
		this.paymentManagementController = paymentManagementController;
	}
	
	
	@RequestMapping(value = "/listExpense", method = RequestMethod.GET)  
    public String listExpense(Model model) {  
    	logger.debug("loading listExpense");
        return "listExpense";  
    }

	
	@RequestMapping(value = "/getExpenseList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getExpenseList() {
		logger.debug("getting expense list");
		List<Expense> expenseList = expenseManagementService.getAllExpense();
		if(expenseList != null && expenseList.size() > 0) {
			for(Expense expense : expenseList) {
				expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpensetypeid()));
			}
		}
		return GeneralUtils.convertListToJSONString(expenseList);
	}
	
	
	@RequestMapping(value = "/deleteExpense", method = RequestMethod.POST)
	public String deleteExpense(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listExpense";
		}
		for (String id : ids) {
			expenseManagementService.deleteExpense(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Expense(s) deleted successfully!");
		return "redirect:listExpense";
	}
	
	@RequestMapping(value = "/createExpense", method = RequestMethod.GET)
    public String showAddExpenseForm(Model model) {  
    	logger.debug("loading showAddExpenseForm");
    	Expense expense = new Expense();
    	Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
    	model.addAttribute("expenseForm", expense);
    	model.addAttribute("expenseTypeList", expenseTypeList);
        return "createExpense";  
    }  
	
	@InitBinder("expenseForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(expenseFormValidator);
	}
	
	@RequestMapping(value = "/createExpense", method = RequestMethod.POST)
    public String saveExpense(@ModelAttribute("expenseForm") @Validated Expense expense, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("saveExpense() : " + expense.toString());
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
	
	@RequestMapping(value = "/createExpenseAndPay", method = RequestMethod.POST)
    public String saveExpenseAndPay(@ModelAttribute("expenseForm") @Validated Expense expense, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		List<String> idList = new ArrayList<String>();
		logger.debug("saveExpense() : " + expense.toString());
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
			idList.add(expense.getExpenseid().toString());
		}
		return paymentManagementController.createPayExpense(idList, redirectAttributes, model);
    }  
	
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
	}
	
	@RequestMapping(value = "/payExpense", method = RequestMethod.POST)
    public String payExpense(@RequestParam("payBtn") String id, Model model,
    		final RedirectAttributes redirectAttributes) {
		List<String> idList = new ArrayList<String>();
		idList.add(id);
		return paymentManagementController.createPayExpense(idList, redirectAttributes, model);
    } 

}