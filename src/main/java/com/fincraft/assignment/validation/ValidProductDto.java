package com.fincraft.assignment.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductDtoValidation.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductDto {
    String message() default "Invalid product DTO";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
