package com.JJ.controller.chequemanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/cheque")
public class ChequeManagementController {
	private static final Logger logger = Logger.getLogger(ChequeManagementController.class);
	
	private ChequeManagementService chequeManagementService;
	private PaymentManagementService paymentManagementService;
	private ExpenseManagementService expenseManagementService;
	private SalaryBonusManagementService salaryBonusManagementService;
	private InvoiceManagementService invoiceManagementService;
	
	@Autowired
	public ChequeManagementController(ChequeManagementService chequeManagementService,
			PaymentManagementService paymentManagementService,
			ExpenseManagementService expenseManagementService,
			SalaryBonusManagementService salaryBonusManagementService,
			InvoiceManagementService invoiceManagementService) {
		this.chequeManagementService = chequeManagementService;
		this.paymentManagementService = paymentManagementService;
		this.expenseManagementService = expenseManagementService;
		this.salaryBonusManagementService = salaryBonusManagementService;
		this.invoiceManagementService = invoiceManagementService;
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
				vo.setPaidFor(paymentManagementService.getPaymentReferenceTypeByChequeId(String.valueOf(vo.getChequeId())));
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

}