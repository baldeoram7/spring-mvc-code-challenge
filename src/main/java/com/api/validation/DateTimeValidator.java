package com.api.validation;

import com.api.annotation.DateTimeNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class DateTimeValidator implements ConstraintValidator<DateTimeNotNull, LocalDateTime> {
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext cvc) {
        return localDateTime != null ? true : false;
    }
}
