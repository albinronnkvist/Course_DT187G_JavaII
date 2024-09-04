package com.albinronnkvist.basics.oop.abstraction.abstractclass;

public abstract class Animal {
    // An abstract class can declare both abstract and concrete methods
    // Abstract method (no implementation)
    public abstract void sound();

    // Concrete method (with implementation)
    public void sleep() {
        System.out.println("Animal is sleeping.");
    }
}
