package com.albinronnkvist.basics.oop.abstraction.abstractclass;

public class Dog extends Animal {
    // A subclass derived from an abstract class must either implement all the base class’s abstract methods or be abstract itself
    public void sound() {
        System.out.println("Dog barks.");
    }
}
