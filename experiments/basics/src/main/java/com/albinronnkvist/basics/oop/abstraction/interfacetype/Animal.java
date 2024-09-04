package com.albinronnkvist.basics.oop.abstraction.interfacetype;

public interface Animal {
    void sound(); // Automatically public & abstract

    default void sleep() { // Automatically public
        System.out.println("Animal is sleeping.");
    }
}
