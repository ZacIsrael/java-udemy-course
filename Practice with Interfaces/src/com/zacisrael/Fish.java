package com.zacisrael;



public class Fish implements Animal {

   private String name;
   private String type;
   private String color;
   private int gender;
   boolean isMale;

    public Fish(String name, String type, String color, int gender) {
        this.type = type;
        this.color = color;
        this.gender = gender;
        if(gender >= 1){
            isMale = true;
        } else {
            isMale = false;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public void travel() {
        System.out.println(getName() + " is swimming.");
    }

    @Override
    public void reproduce() {
        if(isMale){
            System.out.println(getName() + " will have sex with a female fish and she will lay eggs.");
        }
        System.out.println(getName() + " will have sex with a male fish and will lay her eggs in the future");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating algae");

    }

    @Override
    public void communicate() {
        System.out.println(getName() + " is croaking");
    }
}
