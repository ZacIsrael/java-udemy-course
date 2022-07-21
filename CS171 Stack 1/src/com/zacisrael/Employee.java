package com.zacisrael;

public class Employee
{
    // Employee has one member variable: name
    private String name;

    // Employee constructors
    public Employee (String n) {
        System.out.println("Inside Employee(String n)");
        name = n;
    }
    public Employee () {
        System.out.println("Inside Employee()");
        name = "Unknown";
    }

    public String getName() { return name; }

    public void setName(String n) { name=n; }


    public double earnings () { return 0;}

    // Overriding toString() method which is
    // inherited from Object
    public String toString() { return name;}
}
