package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.User;

@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailaddress", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "username.required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailaddress", "NotEmpty.userForm.emailaddress");
		
//		if(user.getId() <=0){
//			errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
//		}
		
	}
	
}