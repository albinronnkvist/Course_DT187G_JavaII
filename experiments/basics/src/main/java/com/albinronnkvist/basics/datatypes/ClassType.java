package com.albinronnkvist.basics.datatypes;

// A class is a blueprint for creating objects (instances), which encapsulates data (fields) and behavior (methods).
public class ClassType {
    // ####################
    // Instance variables (fields)
    // The scope of an instance variable is the entire class. 
    // Any method within the class can access an instance variable, and it holds its value as long as the object exists.
    public String name;
    public int age;
    public NestedClassType address;


    // ####################
    // Static variables
    // A static variable is a variable that belongs to the class itself, rather than to any instance of a class.
    // If one instance modifies the static variable, the change is reflected across all instances.
    public static String staticName = "John";

    // A constant value that can't be modified
    public static final int staticAge = 30;



    // ####################
    // Constructors:
    // A constructor is a special method that is called when an object is instantiated. It initializes the object's attributes.
    // - If you don't create a constructor in a class, a parameter less constructor will be created by the compiler by default.
    // - If you have explicitly created one or more constructors, the compiler will not create a parameter less constructor by default, so you will have to do it yourself if you want one.

    // Parameter less  constructor (default)
    // The instance variables will get initialized to their default values.
    public ClassType() {
    }

    // Parameterized constructor
    public ClassType(String name, int age, String street, int zipCode) {
        // The this keyword is used to refer to the current instance of the class. 
        // It is particularly useful in situations where there is a name conflict between an instance variable and a parameter or local variable.
        this.name = name;
        this.age = age;
        this.address = new NestedClassType(street, zipCode);
    }
    


    // ####################
    // Methods: returnType methodName(parameters) { // method body }

    // Instance methods
    // Instance methods belong to an instance of a class and can access instance variables and other instance methods of the same object.
    public void methodDisplayNameAndAge() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void methodDisplayAddress() {
        System.out.println("Address: " + address.street + ", " + address.zipCode);
    }

    // Static methods
    // Static methods belong to the class itself rather than any specific instance of the class. 
    public static String staticMethodGetName () {
        return staticName;
    }



    // ####################
    // Nested class
    // If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together.
    public class NestedClassType {
        public String street;
        public int zipCode;

        public NestedClassType(String street, int zipCode) {
            this.street = street;
            this.zipCode = zipCode;
        }
    }
}
