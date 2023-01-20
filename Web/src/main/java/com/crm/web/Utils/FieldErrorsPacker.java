package com.crm.web.Utils;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FieldErrorsPacker {
    public static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                FieldError::getField,
                DefaultMessageSourceResolvable::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }
}
