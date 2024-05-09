package com.qburry.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsTrueValidation implements ConstraintValidator<IsTrue, Boolean> {

    @Override
    public boolean isValid(final Boolean value, ConstraintValidatorContext context) {
        return value != null && value;
    }
}
