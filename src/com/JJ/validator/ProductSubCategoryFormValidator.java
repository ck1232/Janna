package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;

@Component
public class ProductSubCategoryFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductSubCategoryVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		ProductSubCategoryVO productSubCategoryVO = (ProductSubCategoryVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.subcategoryform.name");

		
	}
	
}