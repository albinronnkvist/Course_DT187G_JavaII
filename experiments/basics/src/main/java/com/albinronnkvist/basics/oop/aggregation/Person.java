package com.albinronnkvist.basics.oop.aggregation;

public class Person {
    private String name;
    private Address address; // Person "has-a" Address

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name + ", Address: " + address.getFullAddress());
    }
}