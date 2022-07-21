package com.zacisrael;

public class Rectangle extends Shape{
    private String color;
    private int length, width;
    public Rectangle(String color, int length, int width){
        super();
        this.color = color;
        this.length = length;
        this.width = width;
    }

    @Override
    public String describeShape() {
        return "Rectangle color is " + super.color + ", its length" +
                " is " + length + ", and its width is " + width + ".";
    }

    public static void main(String[] args) {
        Rectangle foo = new Rectangle("Blue", 3, 2);
        System.out.println(foo.describeShape()); // Undetermined
    }
}
