package com.JJ.validator;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.batchintakemanagement.vo.ProductInventoryVO;

@Component
public class InventoryProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductInventoryVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductInventoryVO inventory = (ProductInventoryVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateString", "error.notempty.inventoryform.date");
		
		if(null != inventory.getDateString() && !inventory.getDateString().isEmpty()) {
			try{
				new SimpleDateFormat("MM/dd/yyyy").parse(inventory.getDateString());
			}catch(Exception e){
				errors.rejectValue("dateString", "error.notvalid.inventoryform.date");
			}
		}
	}
	
}