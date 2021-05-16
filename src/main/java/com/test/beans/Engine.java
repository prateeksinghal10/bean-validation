package com.test.beans;

import com.test.validation.Random;

public class Engine {

    private int cc;
    @Random(message = "hello-FuelType-One")
    @Random(message = "hello-FuelType-Two")
    private String fuelType;

    public Engine(int cc, String fuelType) {
        this.cc = cc;
        this.fuelType = fuelType;
    }
}
