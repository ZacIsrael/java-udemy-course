package com.zacisrael;
/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel */

public class ShapeTester {

    // No constructor is needed for this class, this class just contains methods that I will
    // use to test between the circle and the rectangle.

    // All of the parameters in the methods in this class contain Objects of type Circle
    // or type rectangle so those are the only type of Objects that will work in
    // the test cases. We will not be able to put any data type assigned variable as
    // parameters for any of these methods.

    public boolean isLarger(Circle circle, Rectangle rectangle){

        if(circle.getArea() >= rectangle.area()){
            // If the area of the circle is greater to or equal to the area of the rectangle,
            // this method will return true
            return true;
        }
        // Otherwise, it will return false.
        return false;
    }

    public double longerPerim(Circle circle, Rectangle rectangle){
        if(rectangle.perimeter() < circle.getCircumference()){
            // if the perimeter of the rectangle is smaller than the circumference of the
            // circle, this method will return the value of the circle's circumference.
            return circle.getCircumference();
        }  if(rectangle.perimeter() > circle.getCircumference()){
            // if the perimeter of the rectangle is larger than the circumference of
            // the circle, this method will return the value of the perimeter of the rectangle.
            return rectangle.perimeter();
        }
        // If the circle's circumference is the same value as the rectangle's perimeter,
        // this method will return 0.0.
        return 0.0;
    }
    public double longerPerim(Rectangle rectangle, Circle circle){
        // Same method as above, only difference is that the parameters are switched.
        if(rectangle.perimeter() < circle.getCircumference()){
            return circle.getCircumference();
        }  if(rectangle.perimeter() > circle.getCircumference()){
            return rectangle.perimeter();
        }
        return 0.0;
    }

    public double largerArea(Circle circle, Rectangle rectangle){
        if(circle.getArea() < rectangle.area()){
            // If the area of the circle is less than the rectangle's area,
            // this method will return the area of the rectangle
            return rectangle.area();
        }
        if(circle.getArea() > rectangle.area()){
            // If the area of the circle is greater than the rectangle's area,
            // this method will return the area of the circle
            return circle.getArea();
        }
        // If the circle's area is equal to the rectangle's area,
        // this method will return 0.0.
        return 0.0;
    }

    public double largerArea(Rectangle rectangle, Circle circle){
        // Same method as above, only difference is that the parameters are switched.
        if(circle.getArea() < rectangle.area()){
            return rectangle.area();
        }
        if(circle.getArea() > rectangle.area()){
            return circle.getArea();
        }
        return 0.0;
    }

    public boolean containsCenter(Circle circle, Circle circle2){
        if(circle.containsPoint(circle2.x,circle2.y)){
            // If the center coordinates of the circle 2 are in circle 1, this
            //  method will return true.
            return true;
        }
        // Otherwise, it will return false.
        return false;
    }


}
