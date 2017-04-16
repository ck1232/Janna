package com.JJ.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.JJ.validator.impl.InDateRangeValidator;

@Documented
//Note: We use here already a validator which we will add in a sec too
@Constraint(validatedBy = InDateRangeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InDateRange{
	// used to get later in the resource bundle the i18n text
    String message() default "{typeMismatch}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String dateFormat();
	
}