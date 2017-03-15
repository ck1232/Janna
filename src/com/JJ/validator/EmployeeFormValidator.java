package com.JJ.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.employeemanagement.EmployeeVo;

@Component
public class EmployeeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EmployeeVo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeeVo employeeVo = (EmployeeVo) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.employeeform.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employmenttype", "error.notempty.employeeform.employmenttype");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "error.notempty.employeeform.nationality");
		
		if(employeeVo.getBasicsalary() == null) {
			errors.rejectValue("basicsalary", "error.notempty.employeeform.basicsalary");
		}else{
			BigDecimal value = employeeVo.getBasicsalary();
			if(value.compareTo(BigDecimal.ZERO) < 0) {
				errors.rejectValue("basicsalary", "error.negative.employeeform.basicsalary");
			}
		}
		
		if(employeeVo.getEmploystartdateString() != null && employeeVo.getEmployenddateString() != null) {
			try{
				Date startdate = new SimpleDateFormat("dd/MM/yyyy").parse(employeeVo.getEmploystartdateString());
				Date enddate = new SimpleDateFormat("dd/MM/yyyy").parse(employeeVo.getEmployenddateString());
				if(startdate.after(enddate)) {
					errors.rejectValue("employstartdateString", "error.employeeform.startdate.after.enddate");
					errors.rejectValue("employenddateString", "error.employeeform.enddate.before.startdate");
				}
			}catch(Exception e) {
				
			}
		}
	}
	
}