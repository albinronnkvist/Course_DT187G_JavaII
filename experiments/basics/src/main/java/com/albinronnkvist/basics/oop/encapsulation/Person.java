package com.albinronnkvist.basics.oop.encapsulation;

public class Person {
    // Private variables
    // Only methods within this class have access
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public getter and setter methods,
    // to access and update the values of private variables.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
