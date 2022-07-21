package com.zacisrael;
/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel */
public class Rectangle {

    private double L; // length of rectangle
    private double H; // height of rectangle
    private double x; // x coordinate of bottom left corner of rectangle
    private double y; // y coordinate of bottom left corner of rectangle

    public Rectangle() {
        // If I do not initialize the height, the length, and the coordinates of the
        // rectangle, it will automatically be set to 1.0 as the height and the length
        // and the bottom left corner will be at point (0,0).
        L = 1.0;
        H = 1.0;
        x = 0.0;
        y = 0.0;
    }

    public Rectangle(double Ell, double Eich, double Ex, double Why) {
        // Constructor, initializing the length, the height, the x
        // coordinate , and the y coordinate of the rectangle
        L = Ell;
        H = Eich;
        x = Ex;
        y = Why;
    }

    public double getLength() {
        // gets the length of the rectangle
        return L;
    }

    public double getHeight() {
        // gets the height of the rectangle
        return H;
    }

    public void setLength(double Ell) {
        // updates the length, this method allows me to set the length to a different number
        //from what it was initialized as.
        L = Ell;
    }

    public void setHeight(double Eich) {
        // updates the height, this method allows me to set the height to a different number
        // from what it was initialized as.
        H = Eich;
    }

    public double perimeter(){
        // returns the perimeter of the rectangle, basic arithmetic
        // perimeter of a rectangle = 2 * the height plus 2 * the length
        return (H * 2) + (L * 2);
    }

    public double area(){
        // returns the area of the rectangle, basic arithmetic
        // area of a rectangle = base * heights, or in other words
        // length * height (L * H).
        return H * L;
    }

}
