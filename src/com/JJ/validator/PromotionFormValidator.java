package com.JJ.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.model.Promotion;

@Component
public class PromotionFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Promotion.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Promotion promotion = (Promotion) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "promotionname", "error.notempty.promotionform.promotionname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "promotionmessage", "error.notempty.promotionform.promotionmessage");

		boolean validDate = true;
		
		if(promotion.getPromotionstartdate()==null){
			errors.rejectValue("promotionstartdate", "error.notempty.promotionform.promotionstartdate");
			validDate = false;
		}
		
		if(promotion.getPromotionenddate()==null){
			errors.rejectValue("promotionenddate", "error.notempty.promotionform.promotionenddate");
			validDate = false;
		}
		
		
		if(!errors.hasErrors()){
			try{
				Assert.isInstanceOf(Date.class, promotion.getPromotionstartdate());
			}catch(Exception e){
				errors.rejectValue("promotionstartdate", "error.notvalid.promotionform.promotionstartdate");
				validDate = false;
			}
			
			try{
				Assert.isInstanceOf(Date.class, promotion.getPromotionenddate());
			}catch(Exception e){
				errors.rejectValue("promotionenddate", "error.notvalid.promotionform.promotionenddate");
				validDate = false;
			}
		}

		
		if(validDate){
			if(promotion.getPromotionstartdate().compareTo(promotion.getPromotionenddate()) > 0){
				errors.rejectValue("promotionstartdate", "error.promotionform.promotionstartdate.later.than.enddate");
				errors.rejectValue("promotionenddate", "error.promotionform.promotionenddate.earlier.than.startdate");
			}
		}
	}
	
}