package com.albinronnkvist.basics.oop.polymorphism.vehicles;

import com.albinronnkvist.basics.oop.polymorphism.Vehicle;

public class Car extends Vehicle{
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }
}
