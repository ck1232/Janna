package com.JJ.controller.paymentmanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.model.Expense;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.validator.PaymentFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/payment")
public class PaymentManagementController {
	private static final Logger logger = Logger.getLogger(PaymentManagementController.class);
	
	private PaymentManagementService paymentManagementService;
	private ExpenseManagementService expenseManagementService;
	private ExpenseTypeLookup expenseTypeLookup;
	private PaymentFormValidator paymentFormValidator;
	
	@Autowired
	public PaymentManagementController(PaymentManagementService paymentManagementService,
			ExpenseManagementService expenseManagementService,
			ExpenseTypeLookup expenseTypeLookup,
			PaymentFormValidator paymentFormValidator) {
		this.paymentManagementService = paymentManagementService;
		this.expenseManagementService = expenseManagementService;
		this.expenseTypeLookup = expenseTypeLookup;
		this.paymentFormValidator = paymentFormValidator;
	}
	
	@RequestMapping(value = "/createPayExpense", method = RequestMethod.POST)
	public String createPayExpense(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes, Model model) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:/expense/listExpense";
		}
		
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids){
			idList.add(Integer.valueOf(id));
		}
		List<Expense> expenseList = expenseManagementService.getAllExpenseByIdList(idList);
		for(Expense expense : expenseList) {
			expense.setExpensedateString(new SimpleDateFormat("dd/MM/yyyy").format(expense.getExpensedate()));
			expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpensetypeid()));
		}
		
		PaymentVo paymentvo = new PaymentVo();
		model.addAttribute("paymentForm", paymentvo);
		model.addAttribute("expenseList", expenseList);
		model.addAttribute("idList", idList);
		model.addAttribute("posturl", "/JJ/payment/createExpensePayment");
		return "createPayExpense";
	}
	
	@InitBinder("paymentForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(paymentFormValidator);
	}
	
	@RequestMapping(value = "/createExpensePayment", method = RequestMethod.POST)
    public String saveExpensePayment(
    		@RequestParam(value = "expenseIds", required=false) List<Integer> expenseIdList,
    		@ModelAttribute("paymentForm") @Validated PaymentVo paymentVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveExpensePayment() : " + paymentVo.toString());
		if (result.hasErrors()) {
			List<Expense> expenseList = expenseManagementService.getAllExpenseByIdList(expenseIdList);
			for(Expense expense : expenseList) {
				expense.setExpensedateString(new SimpleDateFormat("dd/MM/yyyy").format(expense.getExpensedate()));
				expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpensetypeid()));
			}
			model.addAttribute("paymentForm", paymentVo);
			model.addAttribute("expenseList", expenseList);
			model.addAttribute("idList", expenseIdList);
			model.addAttribute("posturl", "/JJ/payment/createExpensePayment");
			return "createPayExpense";
		} else {
			paymentVo.setReferenceType("expense");
			try{ 
				paymentVo.setPaymentDate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getPaymentdateString()));
				if(paymentVo.getPaymentmodecash())
					paymentVo.setChequedate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getChequedateString()));
			}catch(Exception e) {
				logger.info("Error parsing date string");
			}
			paymentManagementService.saveExpensePayment(paymentVo, expenseIdList);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Payment saved successfully!");
	        return "redirect:/expense/listExpense";  
		}
    }  
	


}