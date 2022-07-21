package com.zacisrael;
/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel */

public class Cylinder extends Circle {

    private double z = 0;
    private double height; // How tall the cylinder is in the z direction

    public Cylinder(){
        z = 0.0;
        height = 1.0;
        radius = 1.0;
        y = 0.0;
        x = 0.0;
    }

    public Cylinder(double r, double ex, double why, double height) {
        super(r, ex, why); // these variable were extended from the Circle class
        this.height = height;
    }

    public double getHeight() {
        // This method will return the height of the cylinder
        return height;
    }

    public void setHeight(double height) {
        // this method allows me to set the height to a different number
        //from what it was initialized as.
        this.height = height;
    }

    @Override
    public double getArea() {
        return (super.getArea() * 2) + (2 * Math.PI * height * radius);
        // The area of a cylinder is 2 * PI * radius squared + 2 * PI * the height * the radius
        // In other words , 2 * the area of a circle + 2 * PI * the height * the radius,
        // that is why I multiplied super.getArea() by 2.
    }
    public double getVolume(){
        return Math.PI * Math.pow(radius,2) * height;
        // The volume of a cylinder is PI * the radius squared * the height of the cylinder
    }

    @Override
    public String toString() {
        return "This cylinder's base circle is centered at point (" + x + ", " + y + ") with radius " + this.radius + ".";
        // I overrode the toString() method because I needed to make some slight changes for the cylinder object
    }
}
