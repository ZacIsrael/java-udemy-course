package com.zacisrael;

public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is a penguin so therefore, it cannot fly");
    }
}
