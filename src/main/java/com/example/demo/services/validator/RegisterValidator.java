package com.example.demo.services.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.RegisterDTO;
import com.example.demo.services.UserService;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {
    private final UserService userService;

    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;
        // check if password fields match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password nhập lại không chính xác")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
            valid = false;
        }

        // checkEmail
        if (this.userService.checkEmailExist(user.getEmail())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Email đã tồn tại")
                    .addPropertyNode("email")
                    .addConstraintViolation();
            valid = false;
        }
        return valid;
    }

}
