package com.JJ.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.batchintakemanagement.vo.BatchStockIntakeVO;

@Component
public class BatchIntakeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BatchStockIntakeVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BatchStockIntakeVO batchIntakeVO = (BatchStockIntakeVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remarks", "error.notempty.batchintakeform.remarks");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storageLocation", "error.notempty.batchintakeform.storagelocation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalCost", "error.notempty.batchintakeform.totalcost");
		
		if(batchIntakeVO.getTotalCost() != null){
			Float value = batchIntakeVO.getTotalCost().floatValue();
			if(value < 0) {
				errors.rejectValue("totalCost", "error.negative.batchintakeform.totalcost");
			}
		}
	}
	
}