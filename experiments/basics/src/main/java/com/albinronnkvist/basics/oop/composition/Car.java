package com.albinronnkvist.basics.oop.composition;

public class Car {
    private Engine engine; // Car "has-a" Engine

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("Car with " + engine.getType() + " engine is starting.");
    }
}
