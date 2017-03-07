package com.JJ.controller.paymentmanagement;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.JJ.model.Invoice;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.validator.PaymentFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/payment")
public class PaymentManagementController {
	private static final Logger logger = Logger.getLogger(PaymentManagementController.class);
	
	private PaymentManagementService paymentManagementService;
	private ExpenseManagementService expenseManagementService;
	private InvoiceManagementService invoiceManagementService;
	private ExpenseTypeLookup expenseTypeLookup;
	private PaymentFormValidator paymentFormValidator;
	
	@Autowired
	public PaymentManagementController(PaymentManagementService paymentManagementService,
			ExpenseManagementService expenseManagementService,
			InvoiceManagementService invoiceManagementService,
			ExpenseTypeLookup expenseTypeLookup,
			PaymentFormValidator paymentFormValidator) {
		this.paymentManagementService = paymentManagementService;
		this.expenseManagementService = expenseManagementService;
		this.invoiceManagementService = invoiceManagementService;
		this.expenseTypeLookup = expenseTypeLookup;
		this.paymentFormValidator = paymentFormValidator;
	}
	
	/* Expense Payment Start */
	
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
		BigDecimal totalamount = BigDecimal.ZERO;
		for(Expense expense : expenseList) {
			expense.setExpensedateString(new SimpleDateFormat("dd/MM/yyyy").format(expense.getExpensedate()));
			expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpensetypeid()));
			totalamount = totalamount.add(expense.getTotalamount());
		}
		
		PaymentVo paymentvo = new PaymentVo();
		model.addAttribute("paymentForm", paymentvo);
		model.addAttribute("expenseList", expenseList);
		model.addAttribute("idList", idList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", expenseList.get(expenseList.size()-1).getExpensedateString());
		model.addAttribute("posturl", "/JJ/payment/createExpensePayment");
		return "createPayExpense";
	}
	
	@InitBinder("paymentForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(paymentFormValidator);
	}
	
	@RequestMapping(value = "/createExpensePayment", method = RequestMethod.POST)
    public String saveExpensePayment(
    		@RequestParam(value = "referenceIds", required=false) List<Integer> expenseIdList,
    		@RequestParam(value = "totalamount", required=false) BigDecimal totalamount,
    		@RequestParam(value = "lastdate", required=false) String lastdate,
    		@ModelAttribute("paymentForm") @Validated PaymentVo paymentVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveExpensePayment() : " + paymentVo.toString());
		if (!result.hasErrors()) {
			boolean hasErrors = false;
			if(!validateInputAmount(totalamount, paymentVo)){
				hasErrors = true;
				result.rejectValue("cashamount", "error.notequal.paymentform.expensetotalamount");
				result.rejectValue("chequeamount", "error.notequal.paymentform.expensetotalamount");
			}
			if(!validateInputDate(lastdate, paymentVo.getPaymentdateString())){
				hasErrors = true;
				result.rejectValue("paymentdateString", "error.paymentform.paymentdate.before.expenselastdate");
			}
			
			if(!validateInputDate(lastdate, paymentVo.getChequedateString())){
				hasErrors = true;
				result.rejectValue("chequedateString", "error.paymentform.chequedate.before.expenselastdate");
			}
			
			if(!hasErrors){
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
		List<Expense> expenseList = expenseManagementService.getAllExpenseByIdList(expenseIdList);
		for(Expense expense : expenseList) {
			expense.setExpensedateString(new SimpleDateFormat("dd/MM/yyyy").format(expense.getExpensedate()));
			expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpensetypeid()));
		}
		model.addAttribute("paymentForm", paymentVo);
		model.addAttribute("expenseList", expenseList);
		model.addAttribute("idList", expenseIdList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", expenseList.get(expenseList.size()-1).getExpensedateString());
		model.addAttribute("posturl", "/JJ/payment/createExpensePayment");
		return "createPayExpense";
    }  
	
	/* Expense Payment End */
	
	/* Invoice Payment Start */
	
	@RequestMapping(value = "/createPayInvoice", method = RequestMethod.POST)
	public String createPayInvoice(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes, Model model) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:/invoice/listInvoice";
		}
		
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids){
			idList.add(Integer.valueOf(id));
		}
		List<Invoice> invoiceList = invoiceManagementService.getAllInvoiceByIdList(idList);
		BigDecimal totalamount = BigDecimal.ZERO;
		for(Invoice invoice : invoiceList) {
			invoice.setInvoicedateString(new SimpleDateFormat("dd/MM/yyyy").format(invoice.getInvoicedate()));
			totalamount = totalamount.add(invoice.getTotalprice());
		}
		
		PaymentVo paymentvo = new PaymentVo();
		model.addAttribute("paymentForm", paymentvo);
		model.addAttribute("invoiceList", invoiceList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", invoiceList.get(invoiceList.size()-1).getInvoicedateString());
		model.addAttribute("idList", idList);
		model.addAttribute("posturl", "/JJ/payment/createInvoicePayment");
		return "createPayInvoice";
	}
	
	@RequestMapping(value = "/createInvoicePayment", method = RequestMethod.POST)
    public String saveInvoicePayment(
    		@RequestParam(value = "referenceIds", required=false) List<Integer> invoiceIdList,
    		@RequestParam(value = "totalamount", required=false) BigDecimal totalamount,
    		@RequestParam(value = "lastdate", required=false) String lastdate,
    		@ModelAttribute("paymentForm") @Validated PaymentVo paymentVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveInvoicePayment() : " + paymentVo.toString());
		if (!result.hasErrors()) {
			boolean hasErrors = false;
			if(!validateInputAmount(totalamount, paymentVo)){
				hasErrors = true;
				result.rejectValue("cashamount", "error.notequal.paymentform.invoicetotalamount");
				result.rejectValue("chequeamount", "error.notequal.paymentform.invoicetotalamount");
			}
			if(!validateInputDate(lastdate, paymentVo.getPaymentdateString())){
				hasErrors = true;
				result.rejectValue("paymentdateString", "error.paymentform.paymentdate.before.invoicelastdate");
			}
			
			if(!validateInputDate(lastdate, paymentVo.getChequedateString())){
				hasErrors = true;
				result.rejectValue("chequedateString", "error.paymentform.chequedate.before.invoicelastdate");
			}
			
			if(!hasErrors){
				paymentVo.setReferenceType("invoice");
				try{ 
					paymentVo.setPaymentDate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getPaymentdateString()));
					if(paymentVo.getPaymentmodecash())
						paymentVo.setChequedate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getChequedateString()));
				}catch(Exception e) {
					logger.info("Error parsing date string");
				}
				paymentManagementService.saveInvoicePayment(paymentVo, invoiceIdList);
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg", "Payment saved successfully!");
		        return "redirect:/invoice/listInvoice"; 
			}
		}
		List<Invoice> invoiceList = invoiceManagementService.getAllInvoiceByIdList(invoiceIdList);
		for(Invoice invoice : invoiceList) {
			invoice.setInvoicedateString(new SimpleDateFormat("dd/MM/yyyy").format(invoice.getInvoicedate()));
		}
		model.addAttribute("paymentForm", paymentVo);
		model.addAttribute("invoiceList", invoiceList);
		model.addAttribute("idList", invoiceIdList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", invoiceList.get(invoiceList.size()-1).getInvoicedateString());
		model.addAttribute("posturl", "/JJ/payment/createInvoicePayment");
		return "createPayInvoice";
		
    }  
	
	private boolean validateInputAmount(BigDecimal totalamount, PaymentVo paymentVo) {
		BigDecimal inputAmount = BigDecimal.ZERO;
		if(paymentVo.getPaymentmodecash()) {
			inputAmount = inputAmount.add(paymentVo.getCashamount());
		}
		if(paymentVo.getPaymentmodecheque()) {
			inputAmount = inputAmount.add(paymentVo.getChequeamount());
		}
		if(totalamount.compareTo(inputAmount) == 0){
			return true;
		}
		return false;
	}
	
	private boolean validateInputDate(String lastdateString, String dateString) {
		try {
			Date lastdate = new SimpleDateFormat("dd/MM/yyyy").parse(lastdateString);
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
			
			if(date.compareTo(lastdate) >= 0) {
				return true;
			}
		} catch (ParseException e) {
			logger.info("Error parsing date.");
		}
		return false;
	}
	
	/* Invoice Payment End */

}