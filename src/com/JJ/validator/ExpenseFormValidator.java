package com.JJ.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.expensemanagement.VO.ExpenseVO;

@Component
public class ExpenseFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ExpenseVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ExpenseVO expense = (ExpenseVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expenseTypeId", "error.notempty.expenseform.expensetype");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplier", "error.notempty.expenseform.supplier");
		
		if(expense.getExpensedateString() == null || expense.getExpensedateString().trim().isEmpty()){
			errors.rejectValue("expensedateString", "error.notempty.expenseform.expensedate");
		}else{
			try{
				new SimpleDateFormat("dd/MM/yyyy").parse(expense.getExpensedateString());
			}catch(Exception e) {
				errors.rejectValue("expensedateString", "error.notvalid.expenseform.expensedate");
			}
		}
		
		if(expense.getTotalAmt()==null){
			errors.rejectValue("totalAmt", "error.notempty.expenseform.totalamount");
		}else if(expense.getTotalAmt().compareTo(BigDecimal.ZERO) <= 0){
			errors.rejectValue("totalAmt", "error.notvalid.expenseform.totalamount");
		}		
	}
	
}