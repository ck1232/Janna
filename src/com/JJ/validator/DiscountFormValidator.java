package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Discount;

@Component
public class DiscountFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Discount.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Discount discount = (Discount) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discountname", "error.notempty.discountform.discountname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discountvalue", "error.notempty.discountform.discountvalue");
		
		if(!errors.hasErrors()) {
			Float value = discount.getDiscountvalue().floatValue();
			if("Percentage %".equals(discount.getDiscounttype())) {
				if(value < 0 || value > 100) {
					errors.rejectValue("discountvalue", "error.percent.discountform.discountvalue");
				}
			}else if("Value $".equals(discount.getDiscounttype())) {
				if(value < 0) {
					errors.rejectValue("discountvalue", "error.negative.discountform.discountvalue");
				}
			}
		}
	}
	
}