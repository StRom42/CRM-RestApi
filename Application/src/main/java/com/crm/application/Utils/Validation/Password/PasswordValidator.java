package com.crm.application.Utils.Validation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private final Pattern passwordPattern = Pattern.compile("^[\\w_\\-@!#$%&?\\s]+$");
    private final int minLen = 8;
    private final int maxLen = 30;
    private final String minErrorMessage = String.format("Password must not be shorter than %d symbols", minLen);
    private final String maxErrorMessage = String.format("Password must not be longer than %d symbols", maxLen);
    private final String patternErrorMessage = "Password must contain only latin latters, digits, -@!#$%&? and spaces";

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
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
        if (!passwordPattern.matcher(value).matches()) {
            messages.add(patternErrorMessage);
        }

        if (messages.isEmpty()) return true;

        String template = String.join(". ", messages);
        context.buildConstraintViolationWithTemplate(template)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
