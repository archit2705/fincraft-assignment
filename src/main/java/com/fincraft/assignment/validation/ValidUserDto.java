package com.fincraft.assignment.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserDtoValidation.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserDto {
    String message() default "Invalid user DTO";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
