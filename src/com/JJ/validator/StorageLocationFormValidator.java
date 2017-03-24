package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.batchintakemanagement.vo.StorageLocationVO;

@Component
public class StorageLocationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return StorageLocationVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		StorageLocationVO storageLocationVO = (StorageLocationVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationname", "error.notempty.storagelocationform.locationname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.notempty.storagelocationform.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalcode", "error.notempty.storagelocationform.postalcode");
		
	}
	
}