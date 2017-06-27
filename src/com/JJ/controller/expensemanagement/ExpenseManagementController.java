package com.JJ.controller.expensemanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.paymentmanagement.PaymentManagementController;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.paymentmanagement.vo.PaymentRsVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.paymentmanagement.PaymentRSManagementService;
import com.JJ.validator.ExpenseFormValidator;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/expense")
public class ExpenseManagementController {
	private static final Logger logger = Logger.getLogger(ExpenseManagementController.class);
	
	private ExpenseManagementService expenseManagementService;
	private PaymentManagementService paymentManagementService;
	private PaymentRSManagementService paymentRSManagementService;
	private PaymentManagementController paymentManagementController;
	private ExpenseTypeLookup expenseTypeLookup;
	private ExpenseFormValidator expenseFormValidator;
	@Autowired
	public ExpenseManagementController(ExpenseManagementService expenseManagementService, 
			PaymentManagementService paymentManagementService,
			PaymentRSManagementService paymentRSManagementService,
			PaymentManagementController paymentManagementController,
			ExpenseTypeLookup expenseTypeLookup,
			ExpenseFormValidator expenseFormValidator) {
		this.expenseManagementService = expenseManagementService;
		this.paymentManagementService = paymentManagementService;
		this.paymentRSManagementService = paymentRSManagementService;
		this.expenseTypeLookup = expenseTypeLookup;
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
		List<ExpenseVO> expenseVoList = expenseManagementService.getAllExpense();
		return GeneralUtils.convertListToJSONString(expenseVoList);
	}
	
	@RequestMapping(value = "/getSupplierList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ExpenseVO> getSupplierList() {
		logger.debug("getting supplier list");
		List<String> supplierList = expenseManagementService.getAllSupplier();		
		List<ExpenseVO> expenseList = new ArrayList<ExpenseVO>();
		for(String s: supplierList) {
			ExpenseVO expense = new ExpenseVO();
			expense.setSupplier(s);
			expenseList.add(expense);
		}
		return expenseList;
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
    	ExpenseVO expenseVO = new ExpenseVO();
    	Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
    	model.addAttribute("expenseForm", expenseVO);
    	model.addAttribute("expenseTypeList", expenseTypeList);
        return "createExpense";  
    }  
	
	@InitBinder("expenseForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(expenseFormValidator);
	}
	
	@RequestMapping(value = "/createExpense", method = RequestMethod.POST)
    public String saveExpense(@ModelAttribute("expenseForm") @Validated ExpenseVO expenseVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("saveExpense() : " + expenseVO.toString());
		GeneralUtils.validate(expenseVO, "expenseForm" ,result);
		Date expenseDate = GeneralUtils.convertStringToDate(expenseVO.getExpensedateString(), "dd/MM/yyyy");
		if(expenseDate != null && expenseDate.after(new Date())) {
			result.rejectValue("expensedateString","error.expenseform.expensedate.cannot.after.sysdate");
		}
		if (!result.hasErrors()) {
			expenseVO.setExpenseDate(expenseDate);
			expenseManagementService.saveExpense(expenseVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Expense added successfully!");
			return "redirect:listExpense";  
		}
		Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
    	model.addAttribute("expenseTypeList", expenseTypeList);
		return "createExpense";
    }  
	
	@RequestMapping(value = "/createExpenseAndPay", method = RequestMethod.POST)
    public String saveExpenseAndPay(@ModelAttribute("expenseForm") @Validated ExpenseVO expenseVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		List<String> idList = new ArrayList<String>();
		logger.debug("saveExpenseAndPay() : " + expenseVO.toString());
		if (result.hasErrors()) {
			Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
	    	model.addAttribute("expenseTypeList", expenseTypeList);
			return "createExpense";
		} else {
			try{
				expenseVO.setExpenseDate(new SimpleDateFormat("dd/MM/yyyy").parse(expenseVO.getExpensedateString()));
			}catch(Exception e) {
				logger.info("Error parsing expense date string");
			}
			expenseManagementService.saveExpense(expenseVO);	
			if(expenseVO.getExpenseId() != null) {
				idList.add(expenseVO.getExpenseId().toString());
			}
		}
		return paymentManagementController.createPayExpense(idList, redirectAttributes, model);
    }  
	
	@RequestMapping(value = "/viewExpense", method = RequestMethod.POST)
	public String viewExpense(@RequestParam("viewBtn") String id, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("id = " + id);
		ExpenseVO expenseVO = expenseManagementService.findById(new Integer(id));
		if (expenseVO == null) {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Expense not found!");
			return "redirect:listInvoice";
		}
		model.addAttribute("expense", expenseVO);
		List<PaymentDetailVO> paymentList = paymentManagementService.getAllPaymentByRefTypeAndRefId("expense", expenseVO.getExpenseId());
		if(paymentList != null && !paymentList.isEmpty()){
			model.addAttribute("paymentList", paymentList);
			List<PaymentRsVO> rsList = paymentRSManagementService.getAllPaymentByPaymentDetailId(paymentList.get(0).getPaymentDetailId());
			List<ExpenseVO> otherList = new ArrayList<ExpenseVO>();
			List<Integer> idList = new ArrayList<Integer>();
			if(rsList != null && !rsList.isEmpty()) {
				for(PaymentRsVO vo : rsList) {
					if(vo.getReferenceId() != null && !id.equals(String.valueOf(vo.getReferenceId()))) {
						idList.add(vo.getReferenceId());
					}
				}
				otherList = expenseManagementService.getAllExpenseByIdList(idList);
			}
			model.addAttribute("otherList", otherList);
		}
		return "viewExpense";
	}
	
	@RequestMapping(value = "/updateExpense", method = RequestMethod.POST)
	public String getExpenseToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		ExpenseVO expenseVO = expenseManagementService.findById(new Integer(id));
		logger.debug("Loading update expense page for " + expenseVO.toString());
		
		Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
    	model.addAttribute("expenseTypeList", expenseTypeList);
		model.addAttribute("expenseForm", expenseVO);
		return "updateExpense";
	}
	
	@RequestMapping(value = "/updateExpenseToDb", method = RequestMethod.POST)
	public String updateExpense(@ModelAttribute("expenseForm") @Validated ExpenseVO expenseVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateExpense() : " + expenseVO.toString());
		GeneralUtils.validate(expenseVO, "expenseForm" ,result);
		if (result.hasErrors()) {
			Map<String,String> expenseTypeList = expenseTypeLookup.getExpenseTypeMap();
	    	model.addAttribute("expenseTypeList", expenseTypeList);
			return "updateExpense";
		} else {
			expenseVO.setExpenseDate(GeneralUtils.convertStringToDate(expenseVO.getExpensedateString(), "dd/MM/yyyy"));
			expenseManagementService.updateExpense(expenseVO);
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