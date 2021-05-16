package com.test.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RandomValidator implements ConstraintValidator<Random, String> {

    private String message;
    @Override
    public void initialize(Random constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        message=constraintAnnotation.message();
        System.out.println("init called "+message);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Valid Class "+message);
        return true;
    }
}
