package com.crm.application.Utils.Validation.UserName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserNameValidator implements ConstraintValidator<ValidUserName, String> {
    private final int minLen = 2;
    private final int maxLen = 35;
    private final String minErrorMessage = String.format("User name must not be shorter than %d symbols", minLen);
    private final String maxErrorMessage = String.format("User name must not be longer than %d symbols", maxLen);

    @Override
    public void initialize(ValidUserName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> messages = new ArrayList<>();

        if (value.length() < minLen) {
            messages.add(minErrorMessage);
        }
        if (value.length() > maxLen) {
            messages.add(maxErrorMessage);
        }

        if (messages.isEmpty()) return true;

        String template = String.join(". ", messages);
        context.buildConstraintViolationWithTemplate(template)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
