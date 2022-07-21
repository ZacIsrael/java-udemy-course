package com.zacisrael;
/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel */

public class Circle {

    protected double radius; // the radius of the circle
    protected double x; // the x coordinate of the circle's center
    protected double y; // the y coordinate fo the circle's center

    public Circle(){
        // Default constructor. If I do not initialize values for the radius or
        // the coordinates for the center of the circle, the radius will be set to 1.0
        // and the center of the circle will be at point (0,0).
        radius = 1.0;
        x = 0.0;
        y = 0.0;

    }
    public Circle(double r) {
        // If I just initialize the radius, the circle's  center point will be at
        // point (0,0).
        radius = r;
        x = 0.0;
        y = 0.0;
    }

    public Circle(double r, double ex, double why) {
        // With this constructor, I am able to initialize the radius, and the coordinates
        // of the point at the center of the circle.
        radius = r;
        x = ex;
        y = why;
    }

    public double getRadius() {
        // this method allows me to get the value of the radius
        return radius;
    }

    public double[] getCenter(){
        double[] c = {this.x,this.y};
        return c;
    }

    public double getArea(){
        // returns the area of the circle
        // area of a circle = the radius squared * PI
        return Math.pow(radius,2) * Math.PI;
    }

    public double getCircumference(){
        // returns the circumference of the circle
        // circumference of a circle = 2 * PI * the radius
        return 2 * Math.PI * radius;
    }

    public boolean isBiggerThan(Circle b){
        if(this.getArea() > b.getArea() ){
            // ex: circleA.isBiggerThan(circleb);
            // If the area of circleA is greater than circleb's area, this method will
            // return true.
            return true;
        }
        // Otherwise, it will return false.
        return false;
    }
    public boolean containsPoint(double ex, double why){
        if(Math.pow((ex - x), 2) + Math.pow((why - y),2) < Math.pow(radius, 2)){
            // the equation for finding out whether a point is in a circle is:,
            // (pointX - centerPointX)^2 + (pointY - centerPointY)^2 < radius ^ 2
            // If this is true, the method will return true.
            return true;
        }
        // Otherwise return false
        return false;

    }
    public void setRadius(double radius) {
        // this method allows me to update the value of the radius
        this.radius = radius;
    }

    public void setCenter(double ex, double why){
        // This method sets the x coordinate that was initialized to whatever x value that we
        // have in the parameter. Same for the Y coordinate.
        x = ex;
        y = why;
    }

    @Override
    public String toString() {
        //If we do "System.out.println(circleA);" The following message will be printed
        return "This circle is centered at point (" + x + ", " + y + ") with radius " + this.radius + ".";
    }
}
