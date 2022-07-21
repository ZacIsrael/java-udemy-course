package com.zacisrael;

public class Employee {

    private String name;

    public Employee(){
        name = "Unknown";
    }

    public Employee(String name) {
        this.name = name;
    }

    public double earnings(){
        return 0;
    }

    public String getName() {
        return name;
    }
}
