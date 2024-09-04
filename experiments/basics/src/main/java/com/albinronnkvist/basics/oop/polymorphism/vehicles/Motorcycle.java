package com.albinronnkvist.basics.oop.polymorphism.vehicles;

import com.albinronnkvist.basics.oop.polymorphism.Vehicle;

public class Motorcycle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle is starting.");
    }
}
