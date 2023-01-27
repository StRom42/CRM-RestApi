package com.crm.application.Utils.Validation.UserName;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameValidator.class)
@Documented
public @interface ValidUserName {
    String message() default "Invalid user name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
