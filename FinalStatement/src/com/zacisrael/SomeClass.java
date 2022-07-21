package com.zacisrael;

public class SomeClass {

    public final int instanceNumber;
    // If the object has the keyword final, then the object's value cannot be changed
    // anywhere else in the class

    private static int classCounter = 0;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);

    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
