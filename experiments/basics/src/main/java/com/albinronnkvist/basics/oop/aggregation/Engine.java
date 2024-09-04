package com.albinronnkvist.basics.oop.aggregation;

// Part of the "whole" that cannot exist independently
public class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
