package com.JJ.controller.expensemanagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.JJ.helper.GeneralUtils;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.model.Expense;
import com.JJ.model.Promotion;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.validator.ExpenseFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/expense")
public class ExpenseManagementController {
	private static final Logger logger = Logger.getLogger(ExpenseManagementController.class);
	
	private ExpenseManagementService expenseManagementService;
	private ExpenseTypeLookup expenseTypeLookup;
	private ExpenseFormValidator expenseFormValidator;
	@Autowired
	public ExpenseManagementController(ExpenseManagementService expenseManagementService, 
			ExpenseTypeLookup expenseTypeLookup,
			ExpenseFormValidator expenseFormValidator) {
		this.expenseManagementService = expenseManagementService;
		this.expenseTypeLookup = expenseTypeLookup;
		this.expenseFormValidator = expenseFormValidator;
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
    	Date now = new Date();
    	Date date = new Date(now.getYear(), now.getMonth(), now.getDate());
    	if(expense.getExpensedate() == null){
    		expense.setExpensedate(date);
    	}
    	Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
    	model.addAttribute("expenseForm", expense);
    	model.addAttribute("expenseTypeList", expenseTypeList);
        return "createExpense";  
    }  
	
	@InitBinder("expenseForm")
	protected void initBinder(WebDataBinder binder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	binder.registerCustomEditor(Date.class, "expensedate", new CustomDateEditor(dateFormat, false));
		binder.setValidator(expenseFormValidator);
	}
	
	@RequestMapping(value = "/createExpense", method = RequestMethod.POST)
    public String saveExpense(@ModelAttribute("expenseForm") @Validated Expense expense, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		expense.setDeleteind(GeneralUtils.NOT_DELETED);
		logger.debug("saveExpense() : " + expense.toString());
		if (result.hasErrors()) {
			Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
	    	model.addAttribute("expenseTypeList", expenseTypeList);
			return "createExpense";
		} else {
			expenseManagementService.saveExpense(expense);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Expense added successfully!");
		}
		
		
        return "redirect:listExpense";  
    }  
	

}