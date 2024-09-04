package com.albinronnkvist.basics.oop.polymorphism.vehicles;

import com.albinronnkvist.basics.oop.polymorphism.Vehicle;

public class Boat extends Vehicle {
    @Override
    public void start() {
        System.out.println("Boat is starting.");
    }

    // Method overloading
    // Allows multiple methods in the same class to share the same name but differ in parameters (number, type, or order).
    public void start(String captain) {
        System.out.println(captain + " is starting the boat.");
    }
}
