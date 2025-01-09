package com.meli.obtenerdiploma.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartsWithUppercaseValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)


public @interface StartsWithUpperCase {
    String message() default "La palabra debe comenzar con mayúscula";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}