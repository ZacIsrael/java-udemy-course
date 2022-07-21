package com.zacisrael;
// public means other classes we have created can access this class
// classes allow us to create variables that can be used through out the class


public class Car {

    // These are fields
    // private: don't let a class outside of the class Car use these fields
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model){
        String validModel = model.toLowerCase();
        if(validModel.equals("carrera") || validModel.equals("commodore")){
            this.model = model;
        }
        else{
            this.model = "Unknown";
        }
        // If the model equals a porsche or a holden

        // "this" is saying update the variable above with the contents of the parameter model that was passed to us.
        // This is a way of updating a model using a method

    }
    public String getModel(){
        return this.model;
        // This method will return what the car model is.
    }


}
