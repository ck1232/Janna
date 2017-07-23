package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.discountmanagement.vo.DiscountVO;

@Component
public class DiscountFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DiscountVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DiscountVO discount = (DiscountVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discountName", "error.notempty.discountform.discountname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discountValue", "error.notempty.discountform.discountvalue");
		
		if(!errors.hasErrors()) {
			Float value = discount.getDiscountValue().floatValue();
			if("Percentage %".equals(discount.getDiscountType())) {
				if(value < 0 || value > 100) {
					errors.rejectValue("discountValue", "error.percent.discountform.discountvalue");
				}
			}else if("Value $".equals(discount.getDiscountType())) {
				if(value < 0) {
					errors.rejectValue("discountValue", "error.negative.discountform.discountvalue");
				}
			}
		}
	}
	
}