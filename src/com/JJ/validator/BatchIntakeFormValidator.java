package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Batchstockintake;

@Component
public class BatchIntakeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Batchstockintake.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Batchstockintake batchIntake = (Batchstockintake) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remarks", "error.notempty.batchintakeform.remarks");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storagelocation", "error.notempty.batchintakeform.storagelocation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalcost", "error.notempty.batchintakeform.totalcost");
		
		if(batchIntake.getTotalcost() != null){
			Float value = batchIntake.getTotalcost().floatValue();
			if(value < 0) {
				errors.rejectValue("totalcost", "error.negative.batchintakeform.totalcost");
			}
		}
	}
	
}