package com.JJ.validator.impl;

import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.JJ.validator.annotation.InDateRange;

public class InDateRangeValidator implements ConstraintValidator<InDateRange, String> {
	private String dateFormat = "";
	@Override
	public void initialize(InDateRange constraintAnnotation) {
		this.dateFormat = constraintAnnotation.dateFormat();
		
	}

	@Override
	public boolean isValid(String dateString, ConstraintValidatorContext context) {
		try{
			if(dateString.length() == dateFormat.length()) {
				new SimpleDateFormat(dateFormat).parse(dateString);
				return true;
			}
		}catch(Exception e) {
		}
		return false;
	}

}
