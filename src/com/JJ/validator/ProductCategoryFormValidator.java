package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;

@Component
public class ProductCategoryFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductCategoryVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		ProductCategoryVO productCategoryVO = (ProductCategoryVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryName", "error.notempty.productcategoryform.name");
		
	}
	
}