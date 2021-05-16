package com.test.beans;


import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.hibernate.validator.cfg.defs.NotNullDef;
import org.hibernate.validator.internal.engine.ValidatorImpl;

import javax.validation.*;
import javax.validation.metadata.BeanDescriptor;
import java.lang.annotation.ElementType;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //load property
        //parse
        //programatic validation defination
        HibernateValidatorConfiguration configure = Validation.byProvider(HibernateValidator.class).configure();
        ConstraintMapping constraintMapping = configure.createConstraintMapping();
        NotNullDef manufacturerNotNullConstraint = new NotNullDef();
        manufacturerNotNullConstraint.message("manufacturer cannot be null");
        constraintMapping.type(Car.class)
                .property("manufacturer", ElementType.FIELD)
                .constraint(manufacturerNotNullConstraint)
                .ignoreAnnotations(true);
        configure.addMapping(constraintMapping);
        ValidatorFactory factory = configure.buildValidatorFactory();
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Car h = new Car(null, "h", 5);
        BeanDescriptor constraintsForClass = validator.getConstraintsForClass(Car.class);
        System.out.println(constraintsForClass);

        Set<ConstraintViolation<Car>> validate = validator.validate(h);

        System.out.println(validate);
    }


}
