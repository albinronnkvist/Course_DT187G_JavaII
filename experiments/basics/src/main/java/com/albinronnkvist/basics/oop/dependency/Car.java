package com.albinronnkvist.basics.oop.dependency;

public class Car {
    private final Engine engine;

    // Engine dependency is injected through the constructor
    public Car(Engine engine) {
        if(engine == null) {
            throw new IllegalArgumentException("The car requires an engine to start.");
        }

        this.engine = engine;
    }

    public void startCar() {
        engine.start();
        System.out.println("Car is starting with a " + engine.getType() + " engine.");
    }
}
