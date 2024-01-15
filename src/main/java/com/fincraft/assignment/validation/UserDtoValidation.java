package com.fincraft.assignment.validation;

import com.fincraft.assignment.dtos.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserDtoValidation implements ConstraintValidator<ValidUserDto, UserDto> {

    @Override
    public void initialize(ValidUserDto constraint) {
    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        boolean isValid = true;

        // Perform custom validation if needed
        // For example, you can check additional business logic here

        return isValid;
    }
}
