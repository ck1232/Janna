package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Productsubcategory;

@Component
public class ProductSubCategoryFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Productsubcategory.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Productsubcategory productsubcategory = (Productsubcategory) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.subcategoryform.name");

		
	}
	
}