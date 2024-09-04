package com.albinronnkvist.basics.oop.abstraction.interfacetype;

public class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks.");
    }

    // Optionally override default method sleep()
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}

