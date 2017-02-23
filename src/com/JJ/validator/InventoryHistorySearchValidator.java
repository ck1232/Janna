package com.JJ.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.JJ.controller.inventorymanagement.InventoryHistorySearchCriteria;

@Component
public class InventoryHistorySearchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return InventoryHistorySearchCriteria.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		InventoryHistorySearchCriteria searchCriteria = (InventoryHistorySearchCriteria) target;
		
		boolean validDate = true;
		Date datefrom = new Date(), dateto = new Date();
		
		if(!"".equals(searchCriteria.getCreateddatefrom())) {
			try{
				datefrom = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getCreateddatefrom());
			}catch(Exception e){
				errors.rejectValue("createddatefrom", "error.notvalid.inventoryhistoryform.createddatefrom");
				validDate = false;
			}
		}
		
		if(!"".equals(searchCriteria.getCreateddateto())) {
			try{
				dateto = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getCreateddateto());
			}catch(Exception e){
				errors.rejectValue("createddateto", "error.notvalid.inventoryhistoryform.createddateto");
				validDate = false;
			}
		}
		
		if(validDate && !"".equals(searchCriteria.getCreateddatefrom()) && !"".equals(searchCriteria.getCreateddateto())){
			if(datefrom.compareTo(dateto) > 0){
				errors.rejectValue("createddatefrom", "error.promotionform.createddatefrom.later.than.createddateto");
				errors.rejectValue("createddateto", "error.promotionform.createddateto.earlier.than.createddatefrom");
			}
		}

		
	}
	
}