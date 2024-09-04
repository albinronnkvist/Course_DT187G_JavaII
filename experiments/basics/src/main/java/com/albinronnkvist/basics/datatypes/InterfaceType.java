package com.albinronnkvist.basics.datatypes;

// An interface in Java is a reference type that defines a set of abstract methods (methods without implementation). 
// Classes that implement an interface must provide implementations for these methods.
public interface InterfaceType {
    void abstractMethod(); // Automatically public & abstract

    // Default method
    // Implementing classes can choose to override the default method, 
    // but they are not required to do so (kinda like virtual in C#).
    default void defaultMethod() { // Automatically public
        System.out.println("This is the default method implementation.");
    }

    // Static method 
    // A static method in an interface belongs to the interface itself, 
    // rather than to any instance of a class that implements the interface.
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }
}
