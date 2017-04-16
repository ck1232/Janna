package com.JJ.controller.paymentmanagement;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.controller.paymentmanagement.vo.PaymentVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
import com.JJ.validator.PaymentFormValidator;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/payment")
public class PaymentManagementController {
	private static final Logger logger = Logger.getLogger(PaymentManagementController.class);
	
	private PaymentManagementService paymentManagementService;
	private ExpenseManagementService expenseManagementService;
	private InvoiceManagementService invoiceManagementService;
	private SalaryBonusManagementService salaryBonusManagementService;
	private ExpenseTypeLookup expenseTypeLookup;
	private PaymentFormValidator paymentFormValidator;
	
	@Autowired
	public PaymentManagementController(PaymentManagementService paymentManagementService,
			ExpenseManagementService expenseManagementService,
			InvoiceManagementService invoiceManagementService,
			SalaryBonusManagementService salaryBonusManagementService,
			ExpenseTypeLookup expenseTypeLookup,
			PaymentFormValidator paymentFormValidator) {
		this.paymentManagementService = paymentManagementService;
		this.expenseManagementService = expenseManagementService;
		this.invoiceManagementService = invoiceManagementService;
		this.salaryBonusManagementService = salaryBonusManagementService;
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
		List<ExpenseVO> expenseList = expenseManagementService.getAllExpenseByIdList(idList);
		BigDecimal totalamount = BigDecimal.ZERO;
		for(ExpenseVO expense : expenseList) {
			totalamount = totalamount.add(expense.getTotalAmt());
		}
		
		PaymentVO paymentvo = new PaymentVO();
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
    		@ModelAttribute("paymentForm") @Validated PaymentVO paymentVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveExpensePayment() : " + paymentVo.toString());
		List<ExpenseVO> expenseList = expenseManagementService.getAllExpenseByIdList(expenseIdList);
		for(ExpenseVO expense : expenseList) {
			expense.setExpensedateString(new SimpleDateFormat("dd/MM/yyyy").format(expense.getExpenseDate()));
			expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpenseTypeId()));
		}
		if (!result.hasErrors()) {
			boolean hasErrors = false;
			if(!expenseList.get(0).getexpensetype().toLowerCase().contains("china")&& !validateInputAmount(totalamount, paymentVo)){
				hasErrors = true;
				result.rejectValue("cashamount", "error.notequal.paymentform.expensetotalamount");
				result.rejectValue("chequeamount", "error.notequal.paymentform.expensetotalamount");
			}
			if(!validateInputDate(lastdate, "dd/MM/yyyy", paymentVo.getPaymentdateString())){
				hasErrors = true;
				result.rejectValue("paymentdateString", "error.paymentform.paymentdate.before.expenselastdate");
			}
			
			if(paymentVo.getPaymentmodecheque() && !validateInputDate(lastdate, "dd/MM/yyyy", paymentVo.getChequedateString())){
				hasErrors = true;
				result.rejectValue("chequedateString", "error.paymentform.chequedate.before.expenselastdate");
			}
			
			if(!hasErrors){
				paymentVo.setReferenceType("expense");
				try{ 
					paymentVo.setPaymentDate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getPaymentdateString()));
					if(paymentVo.getPaymentmodecheque())
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
		List<InvoiceVO> invoiceList = invoiceManagementService.getAllInvoiceByIdList(idList);
		BigDecimal totalamount = BigDecimal.ZERO;
		for(InvoiceVO invoice : invoiceList) {
			invoice.setInvoicedateString(new SimpleDateFormat("dd/MM/yyyy").format(invoice.getInvoiceDate()));
			totalamount = totalamount.add(invoice.getTotalAmt());
		}
		
		PaymentVO paymentvo = new PaymentVO();
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
    		@ModelAttribute("paymentForm") @Validated PaymentVO paymentVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveInvoicePayment() : " + paymentVo.toString());
		if (!result.hasErrors()) {
			boolean hasErrors = false;
			if(!validateInputAmount(totalamount, paymentVo)){
				hasErrors = true;
				result.rejectValue("cashamount", "error.notequal.paymentform.invoicetotalamount");
				result.rejectValue("chequeamount", "error.notequal.paymentform.invoicetotalamount");
			}
			if(!validateInputDate(lastdate, "dd/MM/yyyy", paymentVo.getPaymentdateString())){
				hasErrors = true;
				result.rejectValue("paymentdateString", "error.paymentform.paymentdate.before.invoicelastdate");
			}
			
			if(paymentVo.getPaymentmodecheque().compareTo(Boolean.TRUE) == 0 &&
					!validateInputDate(lastdate, "dd/MM/yyyy", paymentVo.getChequedateString())){
				hasErrors = true;
				result.rejectValue("chequedateString", "error.paymentform.chequedate.before.invoicelastdate");
			}
			
			if(!hasErrors){
				paymentVo.setReferenceType("invoice");
				try{ 
					paymentVo.setPaymentDate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getPaymentdateString()));
					if(paymentVo.getPaymentmodecheque())
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
		List<InvoiceVO> invoiceList = invoiceManagementService.getAllInvoiceByIdList(invoiceIdList);
		for(InvoiceVO invoice : invoiceList) {
			invoice.setInvoicedateString(new SimpleDateFormat("dd/MM/yyyy").format(invoice.getInvoiceDate()));
		}
		model.addAttribute("paymentForm", paymentVo);
		model.addAttribute("invoiceList", invoiceList);
		model.addAttribute("idList", invoiceIdList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", invoiceList.get(invoiceList.size()-1).getInvoicedateString());
		model.addAttribute("posturl", "/JJ/payment/createInvoicePayment");
		return "createPayInvoice";
		
    }  
	
	private boolean validateInputAmount(BigDecimal totalamount, PaymentVO paymentVo) {
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
	
	private boolean validateInputDate(String lastdateString, String lastdateformat, String dateString) {
		try {
			Date lastdate = new SimpleDateFormat(lastdateformat).parse(lastdateString);
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
	
	/* Salary Payment Start */
	
	@RequestMapping(value = "/createPaySalary", method = RequestMethod.POST)
	public String createPaySalary(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes, Model model) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:/salarybonus/listSalaryBonus";
		}
		
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids){
			idList.add(Integer.valueOf(id));
		}
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllSalaryByIdList(idList);
		BigDecimal totalamount = BigDecimal.ZERO;
		for(SalaryBonusVO salaryBonusVo : salaryBonusVoList) {
			salaryBonusVo.setDateString(GeneralUtils.convertDateToString(salaryBonusVo.getDate(), "MM-yyyy"));
			totalamount = totalamount.add(salaryBonusVo.getTakehomeAmt());
		}
		
		PaymentVO paymentvo = new PaymentVO();
		model.addAttribute("paymentForm", paymentvo);
		model.addAttribute("salaryList", salaryBonusVoList);
		model.addAttribute("idList", idList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", salaryBonusVoList.get(salaryBonusVoList.size()-1).getDateString());
		model.addAttribute("posturl", "/JJ/payment/createSalaryPayment");
		return "createPaySalary";
	}
	
	@RequestMapping(value = "/createSalaryPayment", method = RequestMethod.POST)
    public String saveSalaryPayment(
    		@RequestParam(value = "referenceIds", required=false) List<Integer> salaryIdList,
    		@RequestParam(value = "totalamount", required=false) BigDecimal totalamount,
    		@RequestParam(value = "lastdate", required=false) String lastdate,
    		@ModelAttribute("paymentForm") @Validated PaymentVO paymentVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveSalaryPayment() : " + paymentVo.toString());
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllSalaryByIdList(salaryIdList);
		for(SalaryBonusVO salaryBonusVo : salaryBonusVoList) {
			salaryBonusVo.setDateString(GeneralUtils.convertDateToString(salaryBonusVo.getDate(), "MM-yyyy"));
		}
		if (!result.hasErrors()) {
			boolean hasErrors = false;
			if(!validateInputAmount(totalamount, paymentVo)){
				hasErrors = true;
				result.rejectValue("cashamount", "error.notequal.paymentform.salarytotalamount");
				result.rejectValue("chequeamount", "error.notequal.paymentform.salarytotalamount");
			}
			if(!validateInputDate(lastdate, "MM-yyyy", paymentVo.getPaymentdateString())){
				hasErrors = true;
				result.rejectValue("paymentdateString", "error.paymentform.paymentdate.before.salarylastdate");
			}
			
			if(paymentVo.getPaymentmodecheque() && !validateInputDate(lastdate, "MM-yyyy", paymentVo.getChequedateString())){
				hasErrors = true;
				result.rejectValue("chequedateString", "error.paymentform.chequedate.before.salarylastdate");
			}
			
			if(!hasErrors){
				paymentVo.setReferenceType("salary");
				try{ 
					paymentVo.setPaymentDate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getPaymentdateString()));
					if(paymentVo.getPaymentmodecheque())
						paymentVo.setChequedate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getChequedateString()));
				}catch(Exception e) {
					logger.info("Error parsing date string");
				}
				paymentManagementService.saveSalaryPayment(paymentVo, salaryIdList);
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg", "Payment saved successfully!");
		        return "redirect:/salarybonus/listSalaryBonus";  
			}
		}
		model.addAttribute("paymentForm", paymentVo);
		model.addAttribute("salaryList", salaryBonusVoList);
		model.addAttribute("idList", salaryIdList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", salaryBonusVoList.get(salaryBonusVoList.size()-1).getDateString());
		model.addAttribute("posturl", "/JJ/payment/createSalaryPayment");
		return "createPaySalary";
    }  
	
	/* Salary Payment End */
	
	/* Bonus Payment Start */
	
	@RequestMapping(value = "/createPayBonus", method = RequestMethod.POST)
	public String createPayBonus(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes, Model model) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:/salarybonus/listSalaryBonus";
		}
		
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids){
			idList.add(Integer.valueOf(id));
		}
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllBonusByIdList(idList);
		BigDecimal totalamount = BigDecimal.ZERO;
		for(SalaryBonusVO salaryBonusVo : salaryBonusVoList) {
			salaryBonusVo.setDateString(GeneralUtils.convertDateToString(salaryBonusVo.getDate(), "yyyy"));
			totalamount = totalamount.add(salaryBonusVo.getBonusAmt());
		}
		
		PaymentVO paymentvo = new PaymentVO();
		model.addAttribute("paymentForm", paymentvo);
		model.addAttribute("bonusList", salaryBonusVoList);
		model.addAttribute("idList", idList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", salaryBonusVoList.get(salaryBonusVoList.size()-1).getDateString());
		model.addAttribute("posturl", "/JJ/payment/createBonusPayment");
		return "createPayBonus";
	}
	
	@RequestMapping(value = "/createBonusPayment", method = RequestMethod.POST)
    public String saveBonusPayment(
    		@RequestParam(value = "referenceIds", required=false) List<Integer> bonusIdList,
    		@RequestParam(value = "totalamount", required=false) BigDecimal totalamount,
    		@RequestParam(value = "lastdate", required=false) String lastdate,
    		@ModelAttribute("paymentForm") @Validated PaymentVO paymentVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveBonusPayment() : " + paymentVo.toString());
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllBonusByIdList(bonusIdList);
		for(SalaryBonusVO salaryBonusVo : salaryBonusVoList) {
			salaryBonusVo.setDateString(GeneralUtils.convertDateToString(salaryBonusVo.getDate(), "yyyy"));
		}
		if (!result.hasErrors()) {
			boolean hasErrors = false;
			if(!validateInputAmount(totalamount, paymentVo)){
				hasErrors = true;
				result.rejectValue("cashamount", "error.notequal.paymentform.bonustotalamount");
				result.rejectValue("chequeamount", "error.notequal.paymentform.bonustotalamount");
			}
			if(!validateInputDate(lastdate, "yyyy", paymentVo.getPaymentdateString())){
				hasErrors = true;
				result.rejectValue("paymentdateString", "error.paymentform.paymentdate.before.bonuslastdate");
			}
			
			if(paymentVo.getPaymentmodecheque() && !validateInputDate(lastdate, "yyyy", paymentVo.getChequedateString())){
				hasErrors = true;
				result.rejectValue("chequedateString", "error.paymentform.chequedate.before.bonuslastdate");
			}
			
			if(!hasErrors){
				paymentVo.setReferenceType("bonus");
				try{ 
					paymentVo.setPaymentDate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getPaymentdateString()));
					if(paymentVo.getPaymentmodecheque())
						paymentVo.setChequedate(new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getChequedateString()));
				}catch(Exception e) {
					logger.info("Error parsing date string");
				}
				paymentManagementService.saveBonusPayment(paymentVo, bonusIdList);
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg", "Payment saved successfully!");
		        return "redirect:/salarybonus/listSalaryBonus";  
			}
		}
		model.addAttribute("paymentForm", paymentVo);
		model.addAttribute("bonusList", salaryBonusVoList);
		model.addAttribute("idList", bonusIdList);
		model.addAttribute("totalamount", totalamount);
		model.addAttribute("lastdate", salaryBonusVoList.get(salaryBonusVoList.size()-1).getDateString());
		model.addAttribute("posturl", "/JJ/payment/createBonusPayment");
		return "createPayBonus";
    }  
	
	/* Salary Payment End */

}