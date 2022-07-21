package com.zacisrael;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public int getAge(){
        return this.age;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAge(int age){
        if(age < 0 || age > 100){
            this.age = 0;
        }
        else{
            this.age = age;
        }
    }
    public boolean isTeen(){
        if(age > 12 && age < 20){
            return true;
        }
        else{
            return false;
        }
    }
    public String getFullName(){
        if(firstName.length() == 0 && lastName.length() == 0){
            return "";
        }
        else if (firstName.length() == 0 && lastName.length() > 0){
            return this.lastName;
        }
        else if(firstName.length() > 0 && lastName.length() == 0){
            return this.firstName;
        }
        else{
            return this.firstName + " " + this.lastName;
        }
    }

}
