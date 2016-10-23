package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Submodulepermissiontype;

@Component
public class PermissionTypeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Submodulepermissiontype.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Submodulepermissiontype submodulepermissiontype = (Submodulepermissiontype) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "permissiontype", "error.notempty.permissiontypeform.permissiontype");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "error.notempty.permissiontypeform.url");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seqno", "error.notempty.permissiontypeform.seqno");

		
	}
	
}