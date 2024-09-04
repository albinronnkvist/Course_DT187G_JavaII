package com.albinronnkvist.basics.oop.composition;

// The "whole" that uses composition
// When the Car object is destroyed, the Engine is also destroyed because it cannot exist independently.
public class Car {
    private Engine engine; // Part of the "whole"

    public Car(String engineType) {
        // The contained object is created within the container, and the container manages its lifecycle.
        this.engine = new Engine(engineType);
    }

    public String getEngineType() {
        return engine.getType();
    }
    
    // Don't do this, just for testing
    public void setEngineType(String engineType) {
        engine.setType(engineType);
    }
}
