package com.JJ.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
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
		
		if(expense.getExpensedateString() == null || expense.getExpensedateString().trim().isEmpty()){
			errors.rejectValue("expensedateString", "error.notempty.expenseform.expensedate");
		}else{
			try{
				new SimpleDateFormat("dd/MM/yyyy").parse(expense.getExpensedateString());
			}catch(Exception e) {
				errors.rejectValue("expensedateString", "error.notvalid.expenseform.expensedate");
			}
		}
		
		if(expense.getTotalamount()==null){
			errors.rejectValue("totalamount", "error.notempty.expenseform.totalamount");
		}else if(expense.getTotalamount().compareTo(BigDecimal.ZERO) <= 0){
			errors.rejectValue("totalamount", "error.notvalid.expenseform.totalamount");
		}		
	}
	
}