package com.project.sms.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class GenderValidator implements ConstraintValidator<ValidGender, String> {

    private final Set<String> allowed = Set.of("male", "female", "other");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && allowed.contains(value.toLowerCase());
    }
}
