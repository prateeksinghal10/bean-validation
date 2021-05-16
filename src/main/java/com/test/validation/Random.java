package com.test.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Random.List.class)
@Documented
@Constraint(
        validatedBy = {RandomValidator.class}
)
public @interface Random {
    String message() default "random validation default message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        Random[] value();
    }
}
