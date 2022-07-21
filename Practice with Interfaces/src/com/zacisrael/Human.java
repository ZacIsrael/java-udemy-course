package com.zacisrael;

import java.awt.*;

public class Human implements Animal {

    private String name;
    private Color eyeColor;
    private String race;
    private boolean isMale;
    private int gender;

    public Human(String name, Color eyeColor, String race, int gender) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.race = race;
        if (gender >= 1) {
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
        System.out.println(getName() + " is walking.");
    }

    @Override
    public void reproduce() {
        if (isMale) {
            System.out.println(getName() + " will have sexual intercourse with a woman. She will become" +
                    " pregnant and have her and " + getName() + "'s baby after 9 months.");
        }
        System.out.println(getName() + " will have sexual intercourse with man. She will become pregnant " +
                "and have the man's baby after 9 months.");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating some fries and a cheeseburger");
    }

    @Override
    public void communicate() {
        System.out.println(getName() + " is talking.");
    }

    public void canReproduceWith(Human human) {
        if(Human.this == human){
            if(isMale){
                System.out.println(getName() + " cannot have sex with or reproduce by himself");
            } else {
                System.out.println(getName() + " cannot have sex with or reproduce herself");
            }
        } else {
            if (human.isMale() == isMale()) {
                System.out.println(getName() + " and " + human.getName() + " cannot reproduce with each other because they are the same gender");
            } else {
                System.out.println(getName() + " can reproduce with " + human.getName() + " because they are not the same gender");
            }
        }

    }
}
