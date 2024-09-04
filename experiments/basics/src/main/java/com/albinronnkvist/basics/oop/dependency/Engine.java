package com.albinronnkvist.basics.oop.dependency;

public class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void start() {
        System.out.println(type + " engine is starting...");
    }
}
