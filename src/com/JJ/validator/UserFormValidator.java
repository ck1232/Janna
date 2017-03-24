package com.JJ.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.common.vo.UserVO;

@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO userVO = (UserVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.userform.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailaddress", "error.notempty.userform.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "error.notempty.userform.username");
		if(StringUtils.isNotEmpty(userVO.getEmailAddress())){
			if(!isValidEmailAddress(userVO.getEmailAddress()))
				errors.rejectValue("emailaddress", "error.notvalid.userform.email");
		}
		
	}
	
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
}