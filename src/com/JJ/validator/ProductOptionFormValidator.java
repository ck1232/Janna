package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.productmanagement.vo.ProductOptionVO;

@Component
public class ProductOptionFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductOptionVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		ProductOptionVO productOptionVO = (ProductOptionVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.productoptionform.name");
	}
	
}