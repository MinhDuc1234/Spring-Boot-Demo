package com.example.demo.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IRequired.RequiredValidator.class)
public @interface IRequired {

    String message() default "You must input the data to this field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class RequiredValidator implements ConstraintValidator<IRequired, Object> {

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            if (value == null)
                return false;
            return true;
        }
        
    }

}
