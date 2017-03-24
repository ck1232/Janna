package com.JJ.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.JJ.controller.employeemanagement.vo.EmployeeVO;

@Component
public class EmployeeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EmployeeVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeeVO employeeVo = (EmployeeVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.notempty.employeeform.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employmenttype", "error.notempty.employeeform.employmenttype");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "error.notempty.employeeform.nationality");
		
		if(employeeVo.getBasicSalary() == null) {
			errors.rejectValue("basicsalary", "error.notempty.employeeform.basicsalary");
		}else{
			BigDecimal value = employeeVo.getBasicSalary();
			if(value.compareTo(BigDecimal.ZERO) < 0) {
				errors.rejectValue("basicsalary", "error.negative.employeeform.basicsalary");
			}
		}
		
		if(employeeVo.getEmploymentStartDateString() != null && employeeVo.getEmploymentEndDateString() != null) {
			try{
				Date startdate = new SimpleDateFormat("dd/MM/yyyy").parse(employeeVo.getEmploymentStartDateString());
				Date enddate = new SimpleDateFormat("dd/MM/yyyy").parse(employeeVo.getEmploymentEndDateString());
				if(startdate.after(enddate)) {
					errors.rejectValue("employstartdateString", "error.employeeform.startdate.after.enddate");
					errors.rejectValue("employenddateString", "error.employeeform.enddate.before.startdate");
				}
			}catch(Exception e) {
				
			}
		}
	}
	
}