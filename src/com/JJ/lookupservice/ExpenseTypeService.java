package com.JJ.lookupservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ExpenseTypeMapper;
import com.JJ.model.ExpenseType;
import com.JJ.model.ExpenseTypeExample;

@Service
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ExpenseTypeService {
	private ExpenseTypeMapper expenseTypeMapper;
	
	@Autowired
	public ExpenseTypeService(ExpenseTypeMapper expenseTypeMapper) {
		super();
		this.expenseTypeMapper = expenseTypeMapper;
	}
	public List<ExpenseType> getExpenseType(){
		ExpenseTypeExample example = new ExpenseTypeExample();
		return expenseTypeMapper.selectByExample(example);
	}

	
}
