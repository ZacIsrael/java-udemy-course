package com.zacisrael;

import java.awt.*;

public class Dog implements Animal{

    private String type;
    private Color color;
    private String name;
    private int gender;
    boolean isMale;

    public Dog(String name, Color color, String type, int gender) {
        this.type = type;
        this.color = color;
        this.name = name;
        if(gender >= 1){
            isMale = true;
        } else {
            isMale = false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    @Override
    public void travel() {
        System.out.println(getName() + " is walking on four legs");
    }

    @Override
    public void reproduce() {
        if(isMale) {
            System.out.println(getName() + " must have sex with a female dog in order to reproduce");
        }
        System.out.println(getName() + " must have sex with a male dog in order to get pregnant to reproduce");

    }

    @Override
    public void eat() {
        if(isMale) {
            System.out.println(getName() + " is chewing his dog food");
        }
        System.out.println(getName() + " is chewing her dog food");
    }

    @Override
    public void communicate() {
        System.out.println(getName() + " is barking");
    }


    public void canReproduceWith(Dog dog) {
        if (Dog.this == dog) {
            if(isMale) {
                System.out.println(getName() + " cannot have sex with himself.");
            } else{
                System.out.println(getName() + " cannot have sex with herself.");
            }
        } else {
            if ((dog.isMale() == isMale())) {
                System.out.println(getName() + " and  " + dog.getName() + " cannot reproduce with eachother because they are the same gender.");
            }
            System.out.println(getName() + " can reproduce with " + dog.getName() + " because they are not the same gender.");
        }
    }
}
