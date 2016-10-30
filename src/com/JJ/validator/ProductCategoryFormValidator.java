package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Productcategory;

@Component
public class ProductCategoryFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Productcategory.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Productcategory productcategory = (Productcategory) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.productcategoryform.name");
		
	}
	
}