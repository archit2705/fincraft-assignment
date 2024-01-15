package com.fincraft.assignment.validation;

import com.fincraft.assignment.dtos.ProductDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductDtoValidation implements ConstraintValidator<ValidProductDto, ProductDto> {

    @Override
    public void initialize(ValidProductDto constraint) {
    }

    @Override
    public boolean isValid(ProductDto productDto, ConstraintValidatorContext context) {
        boolean isValid = true;

        // Perform custom validation if needed
        // For example, you can check additional business logic here

        return isValid;
    }
}
