package com.albinronnkvist.basics.oop.polymorphism;

import com.albinronnkvist.basics.oop.polymorphism.vehicles.*;

public class Test {

    public static void StartVehicles() {
        var car = new Car();
        var boat = new Boat();
        var motorcycle = new Motorcycle();

        Vehicle[] vehicles = {car, boat, motorcycle};
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
        }
    }
}
