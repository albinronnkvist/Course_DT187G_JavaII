package com.albinronnkvist.basics.oop.aggregation;

public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getFullAddress() {
        return street + ", " + city;
    }
}
