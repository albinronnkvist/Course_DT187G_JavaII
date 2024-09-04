package com.albinronnkvist.basics.oop.aggregation;

// The "whole" that uses aggregation
// If a Car is destroyed, the Engine may still be used by other Car objects or exist on its own.
public class Car {
    private Engine engine;

    public Car(Engine engine) {
        // The contained object is passed to the container, and the container does not manage its creation or destruction.
        this.engine = engine;
    }

    public String getEngineType() {
        if(engine == null) {
            return null;
        }
        
        return engine.getType();
    }
}
