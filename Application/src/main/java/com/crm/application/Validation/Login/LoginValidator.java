package com.crm.application.Validation.Login;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LoginValidator implements ConstraintValidator<ValidLogin, String> {
    private final Pattern loginPattern = Pattern.compile("^[\\w_\\-]+$");
    private final int minLen = 5;
    private final int maxLen = 20;
    private final String minErrorMessage = String.format("Login must not be shorter than %d symbols", minLen);
    private final String maxErrorMessage = String.format("Login must not be longer than %d symbols", maxLen);
    private final String patternErrorMessage = "Login can contain only latters, digits, symbols '-' and '_'";
    @Override
    public void initialize(ValidLogin constraintAnnotation) {
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
        if (!loginPattern.matcher(value).matches()) {
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
