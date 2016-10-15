package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Module;
import com.JJ.model.Role;

@Component
public class ModuleFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Module.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Module module = (Module) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.moduleform.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "icon", "error.notempty.moduleform.icon");

		
	}
	
}