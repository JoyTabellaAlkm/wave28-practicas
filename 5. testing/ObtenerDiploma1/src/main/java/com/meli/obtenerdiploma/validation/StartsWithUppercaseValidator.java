package com.meli.obtenerdiploma.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartsWithUppercaseValidator implements ConstraintValidator<StartsWithUpperCase, String> {
    private String message;

    @Override
    public void initialize(StartsWithUpperCase constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.isBlank()) {
            return true;
        }
        char firstLetter = value.charAt(0);
        if(!Character.isUpperCase(firstLetter)) {
            context.disableDefaultConstraintViolation(); // personalizo el mensaje
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }
}
