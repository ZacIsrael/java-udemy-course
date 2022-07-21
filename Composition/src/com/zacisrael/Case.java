package com.zacisrael;

public class Case {
    private String model;
    private String manufactuerer;
    private String powerSupply;
    private Dimensions dimensions;

    public Case(String model, String manufactuerer, String powerSupply, Dimensions dimensions) {
        this.model = model;
        this.manufactuerer = manufactuerer;
        this.powerSupply = powerSupply;
        this.dimensions = dimensions;
    }
    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }

    public String getModel() {
        return model;
    }

    public String getManufactuerer() {
        return manufactuerer;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
