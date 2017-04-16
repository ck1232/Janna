package com.JJ.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.invoicemanagement.vo.InvoiceVO;

@Component
public class GrantFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return InvoiceVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		InvoiceVO invoiceVO = (InvoiceVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messenger", "error.notempty.grantform.organisation");
		
		if(invoiceVO.getTotalAmt() == null) {
			errors.rejectValue("totalAmt", "error.notempty.grantform.totalamount");
		}else{
			BigDecimal value = invoiceVO.getTotalAmt();
			if(value.compareTo(BigDecimal.ZERO) < 0) {
				errors.rejectValue("totalAmt", "error.negative.grantform.totalamount");
			}
		}
		
		if(!invoiceVO.getInvoicedateString().isEmpty()) {
			try{
				new SimpleDateFormat("dd/MM/yyyy").parse(invoiceVO.getInvoicedateString());
			}catch(Exception e) {
				errors.rejectValue("invoicedateString", "error.notempty.grantform.date");
			}
		}
	}
	
}