package com.JJ.service.expensemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.expensemanagement.ExpenseStatusEnum;
import com.JJ.dao.ExpenseMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Expense;
import com.JJ.model.ExpenseExample;

@Service
@Transactional
public class ExpenseManagementService {
	
	private ExpenseMapper expenseMapper;
	@Autowired
	public ExpenseManagementService(ExpenseMapper expenseMapper) {
		this.expenseMapper = expenseMapper;
	}
		
	/* Expense START */
	public List<Expense> getAllExpense() {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Expense> expenseList = expenseMapper.selectByExample(example);
		return expenseList;
	}
	
	public List<Expense> getAllExpenseByIdList(List<Integer> idList) {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andExpenseidIn(idList);
		example.setOrderByClause("expenseDate desc");
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
		expense.setStatus(ExpenseStatusEnum.UNPAID.toString());
		expense.setDeleteInd(GeneralUtils.NOT_DELETED);
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
		if(expense.getDeleteInd().equals(GeneralUtils.NOT_DELETED))
			expenseMapper.updateByPrimaryKeySelective(expense);
	}
	/* Expense END */
	
	
}
