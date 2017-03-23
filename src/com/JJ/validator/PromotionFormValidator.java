package com.JJ.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.promotionmanagement.vo.PromotionVO;

@Component
public class PromotionFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PromotionVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PromotionVO promotion = (PromotionVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "promotionname", "error.notempty.promotionform.promotionname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "promotionmessage", "error.notempty.promotionform.promotionmessage");

		boolean validDate = true;
		
		if(promotion.getPromotionStartDate()==null){
			errors.rejectValue("promotionstartdate", "error.notempty.promotionform.promotionstartdate");
			validDate = false;
		}
		
		if(promotion.getPromotionEndDate()==null){
			errors.rejectValue("promotionenddate", "error.notempty.promotionform.promotionenddate");
			validDate = false;
		}
		
		
		if(!errors.hasErrors()){
			try{
				Assert.isInstanceOf(Date.class, promotion.getPromotionStartDate());
			}catch(Exception e){
				errors.rejectValue("promotionstartdate", "error.notvalid.promotionform.promotionstartdate");
				validDate = false;
			}
			
			try{
				Assert.isInstanceOf(Date.class, promotion.getPromotionEndDate());
			}catch(Exception e){
				errors.rejectValue("promotionenddate", "error.notvalid.promotionform.promotionenddate");
				validDate = false;
			}
		}

		
		if(validDate){
			if(promotion.getPromotionStartDate().compareTo(promotion.getPromotionEndDate()) > 0){
				errors.rejectValue("promotionstartdate", "error.promotionform.promotionstartdate.later.than.enddate");
				errors.rejectValue("promotionenddate", "error.promotionform.promotionenddate.earlier.than.startdate");
			}
		}
	}
	
}