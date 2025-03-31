package com.example.demo.services.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;

@Constraint(validatedBy = RegisterValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegisterChecked {
    String message() default "User register validation failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
