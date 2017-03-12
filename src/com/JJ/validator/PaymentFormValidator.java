package com.JJ.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.paymentmanagement.PaymentVo;

@Component
public class PaymentFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PaymentVo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PaymentVo paymentVo = (PaymentVo) target;
		
		if(paymentVo.getPaymentdateString() == null || paymentVo.getPaymentdateString().trim().isEmpty()){
			errors.rejectValue("paymentdateString", "error.notempty.paymentform.paymentdate");
		}else{
			try{
				new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getPaymentdateString());
			}catch(Exception e) {
				errors.rejectValue("paymentdateString", "error.notvalid.paymentform.paymentdate");
			}
		}
		
		if(!paymentVo.getPaymentmodecash() && !paymentVo.getPaymentmodecheque()) {
			errors.rejectValue("paymentmodecheque", "error.notempty.paymentform.paymentmode");
		}else{ 
			if(paymentVo.getPaymentmodecash()){
				if(paymentVo.getCashamount() == null){
					errors.rejectValue("cashamount", "error.notempty.paymentform.cashamount");
				}else if(paymentVo.getCashamount().compareTo(BigDecimal.ZERO) <= 0){
					errors.rejectValue("cashamount", "error.notvalid.paymentform.cashamount");
				}
			}
			
			if(paymentVo.getPaymentmodecheque()){
				if(paymentVo.getChequeamount() == null){
					errors.rejectValue("chequeamount", "error.notempty.paymentform.chequeamount");
				}else if(paymentVo.getChequeamount().compareTo(BigDecimal.ZERO) <= 0){
					errors.rejectValue("chequeamount", "error.notvalid.paymentform.chequeamount");
				}
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chequeno", "error.notempty.paymentform.chequeno");
				
				if(paymentVo.getChequedateString() == null || paymentVo.getChequedateString().trim().isEmpty()){
					errors.rejectValue("chequedateString", "error.notempty.paymentform.chequedate");
				}else{
					try{
						new SimpleDateFormat("dd/MM/yyyy").parse(paymentVo.getChequedateString());
					}catch(Exception e) {
						errors.rejectValue("chequedateString", "error.notvalid.paymentform.chequedate");
					}
				}
			}
		}	
	}
	
}