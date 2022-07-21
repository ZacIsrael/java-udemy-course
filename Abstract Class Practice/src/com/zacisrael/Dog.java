package com.zacisrael;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    void eating() {
        System.out.println(getName() + " is eating");
    }

    @Override
    void communicate() {
        System.out.println(getName() + " is walking on four legs");
    }



}
