package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.AppUser;

@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AppUser.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AppUser appUser = (AppUser) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty.userForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty.userForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
		
		
		
	}
	
}