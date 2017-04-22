package com.JJ.controller.chequemanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.JJ.controller.chequemanagement.vo.ChequeVO;
import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.controller.paymentmanagement.vo.PaymentRsVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.chequemanagement.ChequeManagementService;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.grantmanagement.GrantManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
import com.JJ.validator.ChequeFormValidator;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/cheque")
public class ChequeManagementController {
	private static final Logger logger = Logger.getLogger(ChequeManagementController.class);
	
	private ChequeManagementService chequeManagementService;
	private PaymentManagementService paymentManagementService;
	private ExpenseManagementService expenseManagementService;
	private GrantManagementService grantManagementService;
	private SalaryBonusManagementService salaryBonusManagementService;
	private InvoiceManagementService invoiceManagementService;
	private ChequeFormValidator chequeFormValidator;
	
	@Autowired
	public ChequeManagementController(ChequeManagementService chequeManagementService,
			PaymentManagementService paymentManagementService,
			ExpenseManagementService expenseManagementService,
			GrantManagementService grantManagementService,
			SalaryBonusManagementService salaryBonusManagementService,
			InvoiceManagementService invoiceManagementService,
			ChequeFormValidator chequeFormValidator) {
		this.chequeManagementService = chequeManagementService;
		this.paymentManagementService = paymentManagementService;
		this.expenseManagementService = expenseManagementService;
		this.grantManagementService = grantManagementService;
		this.salaryBonusManagementService = salaryBonusManagementService;
		this.invoiceManagementService = invoiceManagementService;
		this.chequeFormValidator = chequeFormValidator;
	}
	
	
	@RequestMapping(value = "/listCheque", method = RequestMethod.GET)  
    public String listCheque(Model model) {  
    	logger.debug("loading listCheque");
        return "listCheque";  
    }

	
	@RequestMapping(value = "/getChequeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getChequeList() {
		logger.debug("getting cheque list");
		List<ChequeVO> chequeList = chequeManagementService.getAllCheque();
		for(ChequeVO vo : chequeList) {
			if(null != vo.getChequeId()) {
				List<PaymentRsVO> paymentRsList = paymentManagementService.getPaymentReferenceTypeByChequeId(String.valueOf(vo.getChequeId()));
				vo.setPaidFor(paymentRsList.get(0).getReferenceType());
			}
		}
		return GeneralUtils.convertListToJSONString(chequeList);
	}
	
	
	@RequestMapping(value = "/deleteCheque", method = RequestMethod.POST)
	public String deleteCheque(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listCheque";
		}
		for (String id : ids) {
			chequeManagementService.deleteCheque(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Cheque(s) deleted successfully!");
		return "redirect:listCheque";
	}
	
	@RequestMapping(value = "/viewCheque", method = RequestMethod.POST)
	public String viewEmployee(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		ChequeVO chequeVo = chequeManagementService.findById(new Integer(id));
		if (chequeVo == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Cheque not found");
		}else{
			chequeVo.setChequeDateString(GeneralUtils.convertDateToString(chequeVo.getChequeDate(), "dd MMM yyyy"));
			model.addAttribute("cheque", chequeVo);
			List<PaymentRsVO> paymentRsVOList = paymentManagementService.getAllPaymentByChequeId(String.valueOf(id));
			if(!paymentRsVOList.isEmpty()){
				List<Integer> expenseIdList = new ArrayList<Integer>();
				List<Integer> salaryIdList = new ArrayList<Integer>();
				List<Integer> bonusIdList = new ArrayList<Integer>();
				List<Integer> invoiceIdList = new ArrayList<Integer>();
				for(PaymentRsVO vo : paymentRsVOList) {
					if(vo.getReferenceType().equals("expense"))
						expenseIdList.add(vo.getReferenceId());
					else if(vo.getReferenceType().equals("salary"))
						salaryIdList.add(vo.getReferenceId());
					else if(vo.getReferenceType().equals("bonus"))
						bonusIdList.add(vo.getReferenceId());
					else if(vo.getReferenceType().equals("invoice"))
						invoiceIdList.add(vo.getReferenceId());
				}
				if(!expenseIdList.isEmpty()) {
					List<ExpenseVO> expenseList = expenseManagementService.getAllExpenseByIdList(expenseIdList);
					model.addAttribute("expenseList", expenseList);
				}
				if(!salaryIdList.isEmpty()) {
					List<SalaryBonusVO> salaryList = salaryBonusManagementService.getAllSalaryByIdList(salaryIdList);
					model.addAttribute("salaryList", salaryList);
				}
				if(!bonusIdList.isEmpty()) {
					List<SalaryBonusVO> bonusList = salaryBonusManagementService.getAllBonusByIdList(bonusIdList);
					model.addAttribute("bonusList", bonusList);
				}
				if(!invoiceIdList.isEmpty()) {
					List<InvoiceVO> invoiceList = invoiceManagementService.getAllInvoiceByIdList(invoiceIdList);
					model.addAttribute("invoiceList", invoiceList);
				}
			}
		}
		return "viewCheque";

	}
	
	@RequestMapping(value = "/updateCheque", method = RequestMethod.POST)
	public String getCheqeToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		ChequeVO chequeVo = chequeManagementService.findById(new Integer(id));
		logger.debug("Loading update cheque page for " + chequeVo.toString());
		String firstDate = GeneralUtils.convertDateToString(getEarliestChequeDate(chequeVo), "dd/MM/yyyy");
		model.addAttribute("chequeForm", chequeVo);
		model.addAttribute("firstDate", firstDate);
		return "updateCheque";
	}
	
	@InitBinder("chequeForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(chequeFormValidator);
	}
	
	@RequestMapping(value = "/updateChequeToDb", method = RequestMethod.POST)
	public String updateCheque(@RequestParam("firstDate") String firstDate,
			@ModelAttribute("chequeForm") @Validated ChequeVO chequeVo,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
//		logger.debug("updateCheque() : " + chequeVo.toString());
		if(!chequeVo.getChequeDateString().isEmpty() && GeneralUtils.convertStringToDate(chequeVo.getChequeDateString(), "dd/MM/yyyy").before(GeneralUtils.convertStringToDate(firstDate, "dd/MM/yyyy"))) {
			result.rejectValue("chequeDateString", "error.notvalid.paymentform.chequedate");
		}
		if (!result.hasErrors()) {
			chequeManagementService.updateCheque(chequeVo);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Cheque updated successfully!");
			return "redirect:listCheque";
		}
		model.addAttribute("firstDate", firstDate);
		ChequeVO dbchequeVo = chequeManagementService.findById(new Integer(chequeVo.getChequeId()));
		chequeVo.setChequeAmt(dbchequeVo.getChequeAmt());
		chequeVo.setDebitDate(dbchequeVo.getDebitDate());
		chequeVo.setDebitDateString(GeneralUtils.convertDateToString(dbchequeVo.getDebitDate(), "dd/MM/yyyy"));
		chequeVo.setRemarks(dbchequeVo.getRemarks());
		return "updateCheque";
	}
	
	
	private Date getEarliestChequeDate(ChequeVO chequeVo) {
		Date firstdate = null;
		List<PaymentRsVO> paymentRsList = paymentManagementService.getPaymentReferenceTypeByChequeId(String.valueOf(chequeVo.getChequeId()));
		if(paymentRsList != null){
			for(PaymentRsVO vo : paymentRsList) {
				Date date = null;
				switch(vo.getReferenceType()) {
				case "expense":
					ExpenseVO expenseVo = expenseManagementService.findById(vo.getReferenceId());
					date = expenseVo.getExpenseDate();
					break;
				case "invoice":
					InvoiceVO invoiceVo = invoiceManagementService.getInvoiceById(vo.getReferenceId());
					date = invoiceVo.getInvoiceDate();
					break;
				case "grant":
					InvoiceVO grantVo = grantManagementService.getGrantById(vo.getReferenceId());
					date = grantVo.getInvoiceDate();
					break;
				case "salary":
					SalaryBonusVO salaryVo = salaryBonusManagementService.findSalaryById(vo.getReferenceId());
					date = salaryVo.getDate();
					break;
				case "bonus":
					SalaryBonusVO bonusVo = salaryBonusManagementService.findBonusById(vo.getReferenceId());
					date = bonusVo.getDate();
					break;
				}
				if(firstdate == null || date.before(firstdate)) {
					firstdate = date;
				}
			}
		}
		return firstdate;
	}

}