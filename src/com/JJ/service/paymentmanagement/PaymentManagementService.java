package com.JJ.service.paymentmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.expensemanagement.ExpenseStatusEnum;
import com.JJ.controller.invoicemanagement.InvoiceStatusEnum;
import com.JJ.controller.paymentmanagement.vo.PaymentVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVo;
import com.JJ.dao.PaymentRsMapper;
import com.JJ.dao.PaymentdetailMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Expense;
import com.JJ.model.Invoice;
import com.JJ.model.PaymentRs;
import com.JJ.model.PaymentRsExample;
import com.JJ.model.Paymentdetail;
import com.JJ.model.PaymentdetailExample;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
import com.JJ.lookup.ExpenseTypeLookup;

@Service
@Transactional
public class PaymentManagementService {
	
	private PaymentRsMapper paymentRsMapper;
	private PaymentdetailMapper paymentDetailMapper;
	private ExpenseTypeLookup expenseTypeLookup;
	private ExpenseManagementService expenseManagementService;
	private InvoiceManagementService invoiceManagementService;
	private SalaryBonusManagementService salaryBonusManagementService;
	
	@Autowired
	public PaymentManagementService(PaymentRsMapper paymentRsMapper, PaymentdetailMapper paymentDetailMapper,
			ExpenseTypeLookup expenseTypeLookup,  
			ExpenseManagementService expenseManagementService, 
			InvoiceManagementService invoiceManagementService,
			SalaryBonusManagementService salaryBonusManagementService) {
		this.paymentRsMapper = paymentRsMapper;
		this.paymentDetailMapper = paymentDetailMapper;
		this.expenseTypeLookup = expenseTypeLookup;
		this.expenseManagementService = expenseManagementService;
		this.invoiceManagementService = invoiceManagementService;
		this.salaryBonusManagementService = salaryBonusManagementService;
	}
	public void saveExpensePayment(PaymentVO paymentVo, List<Integer> expenseidList) {
		List<Expense> expenseList = expenseManagementService.getAllExpenseByIdList(expenseidList);
		List<Paymentdetail> paymentDetailList = genPaymentDetail(paymentVo);
		
		for(Paymentdetail paymentdetail : paymentDetailList) {
			for(Expense expense : expenseList) {
				expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpensetypeid()));
				PaymentRs paymentrs = new PaymentRs();
				paymentrs.setReferencetype("expense");
				paymentrs.setReferenceid(expense.getExpenseid());
				paymentrs.setPaymentdetailid(paymentdetail.getPaymentdetailid());
				paymentRsMapper.insert(paymentrs);
				if(expense.getexpensetype().toLowerCase().contains("china"))
					expense.setStatus(ExpenseStatusEnum.UNPAID.toString());
				else
					expense.setStatus(ExpenseStatusEnum.PAID.toString());
				expenseManagementService.updateExpense(expense);
			}
		}
	}
	
	public void saveInvoicePayment(PaymentVO paymentVo, List<Integer> invoiceidList) {
		List<Invoice> invoiceList = invoiceManagementService.getAllInvoiceByIdList(invoiceidList);
		List<Paymentdetail> paymentDetailList = genPaymentDetail(paymentVo);
		
		for(Paymentdetail paymentdetail : paymentDetailList) {
			for(Invoice invoice : invoiceList) {
				PaymentRs paymentrs = new PaymentRs();
				paymentrs.setReferencetype("invoice");
				paymentrs.setReferenceid(invoice.getInvoiceid());
				paymentrs.setPaymentdetailid(paymentdetail.getPaymentdetailid());
				paymentRsMapper.insert(paymentrs);
				
				invoice.setStatus(InvoiceStatusEnum.PAID.toString());
				invoiceManagementService.updateInvoice(invoice);
			}
		}
	}
	
	public void saveSalaryPayment(PaymentVO paymentVo, List<Integer> salaryidList) {
		List<SalaryBonusVo> salaryBonusVoList = salaryBonusManagementService.getAllSalaryByIdList(salaryidList);
		List<Paymentdetail> paymentDetailList = genPaymentDetail(paymentVo);
		
		for(Paymentdetail paymentdetail : paymentDetailList) {
			for(SalaryBonusVo salary : salaryBonusVoList) {
				PaymentRs paymentrs = new PaymentRs();
				paymentrs.setReferencetype("salary");
				paymentrs.setReferenceid(salary.getId());
				paymentrs.setPaymentdetailid(paymentdetail.getPaymentdetailid());
				paymentRsMapper.insert(paymentrs);
				
				salary.setStatus(ExpenseStatusEnum.PAID.toString());
				salaryBonusManagementService.updateSalaryBonus(salary);
			}
		}
	}
	
	public void saveBonusPayment(PaymentVO paymentVo, List<Integer> bonusidList) {
		List<SalaryBonusVo> salaryBonusVoList = salaryBonusManagementService.getAllBonusByIdList(bonusidList);
		List<Paymentdetail> paymentDetailList = genPaymentDetail(paymentVo);
		
		for(Paymentdetail paymentdetail : paymentDetailList) {
			for(SalaryBonusVo bonus : salaryBonusVoList) {
				PaymentRs paymentrs = new PaymentRs();
				paymentrs.setReferencetype("bonus");
				paymentrs.setReferenceid(bonus.getId());
				paymentrs.setPaymentdetailid(paymentdetail.getPaymentdetailid());
				paymentRsMapper.insert(paymentrs);
				
				bonus.setStatus(ExpenseStatusEnum.PAID.toString());
				salaryBonusManagementService.updateSalaryBonus(bonus);
			}
		}
	}
	
	
	private List<Paymentdetail> genPaymentDetail(PaymentVO paymentVo) {
		List<Paymentdetail> paymentDetailList = new ArrayList<Paymentdetail>();
		if(paymentVo.getPaymentmodecash()){
			Paymentdetail paymentdetail = new Paymentdetail(
					paymentVo.getPaymentDate(), 1, paymentVo.getCashamount(), "", null);
			paymentDetailMapper.insert(paymentdetail);
			paymentDetailList.add(paymentdetail);
		}
		
		if(paymentVo.getPaymentmodecheque()){
			Paymentdetail paymentdetail = new Paymentdetail(
					paymentVo.getChequedate(), 2, paymentVo.getChequeamount(), paymentVo.getChequeno(), GeneralUtils.UNBOUNCED);
			paymentDetailMapper.insert(paymentdetail);
			paymentDetailList.add(paymentdetail);
		}
		return paymentDetailList;
	}
	
	public List<Paymentdetail> getAllPaymentByRefTypeAndRefId(String refType, Integer refId) {
		List<Paymentdetail> paymentdetailList = new ArrayList<Paymentdetail>();
		PaymentRsExample rsExample = new PaymentRsExample();
		rsExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED)
								.andReferencetypeEqualTo(refType)
								.andReferenceidEqualTo(refId);
		List<PaymentRs> paymentRsList = paymentRsMapper.selectByExample(rsExample);
		List<Integer> idList = new ArrayList<Integer>();
		if(paymentRsList != null && paymentRsList.size() > 0) {
			for(PaymentRs paymentRs : paymentRsList) {
				idList.add(paymentRs.getPaymentdetailid());
			}
			PaymentdetailExample example = new PaymentdetailExample();
			example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andPaymentdetailidIn(idList);
			example.setOrderByClause("paymentDate desc, paymentMode asc, chequeNum asc");				
			paymentdetailList = paymentDetailMapper.selectByExample(example);
		}
		return paymentdetailList;
	}
	
		
	/* Expense START */
	/*public List<Expense> getAllExpense() {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Expense> expenseList = expenseMapper.selectByExample(example);
		return expenseList;
	}
	
	public List<Expense> getAllExpenseByIdList(List<Integer> idList) {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andExpenseidIn(idList);
		List<Expense> expenseList = expenseMapper.selectByExample(example);
		return expenseList;
	}
	
	public Expense findById(Integer id) {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andExpenseidEqualTo(id);
		List<Expense> expenseList = expenseMapper.selectByExample(example);
		if(expenseList != null && expenseList.size() > 0) {
			return expenseList.get(0);
		}
		return null;
	}
	
	public void saveExpense(Expense expense) {
		expenseMapper.insert(expense);
	}
	
	public void saveExpenseList(List<Expense> expenseList) {
		for(Expense expense : expenseList)
			saveExpense(expense);
	}
	
	public void deleteExpense(Integer id) {
		expenseMapper.deleteByPrimaryKey(id);
	}
	
	public void deleteExpenseList(List<Integer> idList) {
		for(Integer id : idList)
			deleteExpense(id);
	}
	
	public void updateExpense(Expense expense) {
		if(expense.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			expenseMapper.updateByPrimaryKeySelective(expense);
	}*/
	/* Expense END */
	
	
}
