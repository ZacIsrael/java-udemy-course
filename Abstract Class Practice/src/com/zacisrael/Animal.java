package com.zacisrael;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void eating(){};
    void communicate(){};

}
