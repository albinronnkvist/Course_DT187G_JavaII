package com.albinronnkvist.basics.oop.inheritance;

// Sub/child class
public class Employee extends Person {
    private String department;

    public Employee(String name, int age, String department) {
        super(name, age); // Calls the constructor of the parent class
        this.department = department;
    }

    public void displayEmployeeInfo() {
        super.displayInfo(); // Method from parent class
        System.out.println("Department: " + department);
    }
}
