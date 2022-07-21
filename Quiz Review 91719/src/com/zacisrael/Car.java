package com.zacisrael;

import java.awt.*;

public class Car {

    private final int wheels = 4;
    private Color color;
    private String type;

    public Car(Color color, String type) {
        this.color = color;
        this.type = type;
    }

    public int getWheels() {
        return wheels;
    }

    public Color getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }
}
