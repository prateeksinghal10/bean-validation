package com.test.beans;

import com.test.validation.Random;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Car {

    @Random(message = "manufacturer-HelloOne")
    //not null
    //regex
    private String manufacturer;

    @Random(message = "HelloOne")
    @Random(message = "helloTwo")

    private String licensePlate;

    private int seatCount;

    @Valid
    Engine engine;

    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;

        this.engine= new Engine(100,"DIESEL");
    }

}
