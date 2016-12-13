package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Storagelocation;

@Component
public class StorageLocationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Storagelocation.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Storagelocation location = (Storagelocation) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationname", "error.notempty.storagelocationform.locationname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.notempty.storagelocationform.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalcode", "error.notempty.storagelocationform.postalcode");
		
	}
	
}