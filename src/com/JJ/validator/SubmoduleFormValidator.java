package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Submodule;

@Component
public class SubmoduleFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Submodule.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Submodule submodule = (Submodule) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.submoduleform.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "icon", "error.notempty.submoduleform.icon");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "icon", "error.notempty.submoduleform.url");

		
	}
	
}