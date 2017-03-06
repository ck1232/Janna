package com.JJ.service.paymentmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.expensemanagement.ExpenseStatus;
import com.JJ.controller.paymentmanagement.PaymentVo;
import com.JJ.dao.ExpenseMapper;
import com.JJ.dao.PaymentRsMapper;
import com.JJ.dao.PaymentdetailMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Expense;
import com.JJ.model.ExpenseExample;
import com.JJ.model.PaymentRs;
import com.JJ.model.Paymentdetail;
import com.JJ.model.Promotion;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.lookup.PaymentModeLookup;

@Service
@Transactional
public class PaymentManagementService {
	
	private PaymentRsMapper paymentRsMapper;
	private PaymentdetailMapper paymentDetailMapper;
	private PaymentModeLookup paymentModeLookup;
	private ExpenseManagementService expenseManagementService;
	
	@Autowired
	public PaymentManagementService(PaymentRsMapper paymentRsMapper, PaymentdetailMapper paymentDetailMapper,
			PaymentModeLookup paymentModeLookup, ExpenseManagementService expenseManagementService) {
		this.paymentRsMapper = paymentRsMapper;
		this.paymentDetailMapper = paymentDetailMapper;
		this.paymentModeLookup = paymentModeLookup;
		this.expenseManagementService = expenseManagementService;
	}
	public void saveExpensePayment(PaymentVo paymentVo, List<Integer> expenseIdList) {
		List<Expense> expenseList = expenseManagementService.getAllExpenseByIdList(expenseIdList);
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
		
		for(Paymentdetail paymentdetail : paymentDetailList) {
			for(Expense expense : expenseList) {
				PaymentRs paymentrs = new PaymentRs();
				paymentrs.setReferencetype("expense");
				paymentrs.setReferenceid(expense.getExpenseid());
				paymentrs.setPaymentdetailid(paymentdetail.getPaymentdetailid());
				paymentRsMapper.insert(paymentrs);
				
				expense.setStatus(ExpenseStatus.PAID.toString());
				expenseManagementService.updateExpense(expense);
			}
		}
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
