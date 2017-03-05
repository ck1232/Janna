package com.JJ.validator;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Expense;

@Component
public class ExpenseFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Expense.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Expense expense = (Expense) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expensetypeid", "error.notempty.expenseform.expensetype");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplier", "error.notempty.expenseform.supplier");
		
		if(expense.getExpensedate()==null){
			errors.rejectValue("expensedate", "error.notempty.expenseform.expensedate");
		}
		
		if(expense.getTotalamount()==null){
			errors.rejectValue("totalamount", "error.notempty.expenseform.totalamount");
		}else if(expense.getTotalamount().compareTo(BigDecimal.ZERO) <= 0){
			errors.rejectValue("totalamount", "error.notvalid.expenseform.totalamount");
		}
		
		
		if(!errors.hasErrors()){
			try{
				Assert.isInstanceOf(Date.class, expense.getExpensedate());
			}catch(Exception e){
				errors.rejectValue("expensedate", "error.notvalid.expenseform.expensedate");
			}
		}
		
	}
	
}