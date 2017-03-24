package com.JJ.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;

@Component
public class SalaryBonusFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SalaryBonusVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SalaryBonusVO salaryBonusVo = (SalaryBonusVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeid", "error.notempty.salarybonusform.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "error.notempty.salarybonusform.type");
		
		if(salaryBonusVo.getDateString() == null || salaryBonusVo.getDateString().trim().isEmpty()){
			errors.rejectValue("dateString", "error.notempty.salarybonusform.date");
		}else{
			try{
				new SimpleDateFormat("dd/MM/yyyy").parse(salaryBonusVo.getDateString());
			}catch(Exception e) {
				errors.rejectValue("dateString", "error.notvalid.salarybonusform.date");
			}
		}
		
		if(!salaryBonusVo.getType().isEmpty()) {
			if(salaryBonusVo.getType().toLowerCase().equals("salary")) {
				if(salaryBonusVo.getBasicSalaryAmt() == null) {
					errors.rejectValue("basicsalary", "error.notempty.salarybonusform.basicsalary");
				}else{
					if(salaryBonusVo.getBasicSalaryAmt().compareTo(BigDecimal.ZERO) < 0) {
						errors.rejectValue("basicsalary", "error.negative.salarybonusform.basicsalary");
					}
				}
				
			}else if(salaryBonusVo.getType().toLowerCase().equals("bonus")){
				if(salaryBonusVo.getBonusAmt() == null) {
					errors.rejectValue("bonusamount", "error.notempty.salarybonusform.bonusamount");
				}else{
					if(salaryBonusVo.getBonusAmt().compareTo(BigDecimal.ZERO) < 0) {
						errors.rejectValue("bonusamount", "error.negative.salarybonusform.bonusamount");
					}
				}
			}
		}
		
		
		
	}
	
}