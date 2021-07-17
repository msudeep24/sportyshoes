package com.sportyshoes.auth.validator;

import com.sportyshoes.auth.model.User;
import com.sportyshoes.auth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Username can't be empty");
        
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Username already taken");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password can't be empty");
        
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Password doesn't match");
        }
    }
}
