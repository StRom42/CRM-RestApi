package com.crm.application.Utils.Validation.Login;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginValidator.class)
@Documented
public @interface ValidLogin {
    String message() default "Invalid login";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
