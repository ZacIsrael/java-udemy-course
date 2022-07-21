package com.zacisrael;

/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel */


public class Main {

    public static void main(String[] args) {
        // Below are my test case

        Circle circle = new Circle(17);
        circle.setCenter(3, 0);
        System.out.println(circle.containsPoint(3, 16));
        circle.getCenter();

        System.out.println(circle);

        Circle circle2 = new Circle();
        System.out.println(circle2.containsPoint(0.9, 0.4));
        System.out.println(circle2);
        System.out.println(circle.isBiggerThan(circle2));

        Circle circle3 = new Circle(10, 2, 2);
        System.out.println(circle3.containsPoint(11, 6));
        System.out.println(circle3);

        Rectangle rectangle = new Rectangle(9, 12, 0, 0);
        System.out.println(rectangle.area());
        System.out.println(rectangle.perimeter());

        Rectangle rectangle2 = new Rectangle();
        System.out.println(rectangle2.area());
        System.out.println(rectangle2.perimeter());

        ShapeTester shapeTester = new ShapeTester();

        System.out.println(shapeTester.containsCenter(circle, circle2));
        System.out.println(shapeTester.largerArea(circle,rectangle));
        System.out.println(shapeTester.isLarger(circle, rectangle));
        System.out.println(shapeTester.isLarger(circle2, rectangle));
        System.out.println(shapeTester.longerPerim(circle3,rectangle));

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder.getHeight());
        System.out.println(cylinder.getVolume());
        System.out.println(cylinder.getArea());
        cylinder.setHeight(15);
        System.out.println(cylinder.getHeight());
        System.out.println(cylinder.getVolume());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getCircumference());



        Cylinder cylinder2 = new Cylinder(3.0,5.0,0.0,6.0);
        System.out.println(cylinder2.getHeight());
        System.out.println(cylinder2.getVolume());
        System.out.println(cylinder2.getArea());
        System.out.println(cylinder2.containsPoint(7,2));
        System.out.println( cylinder2.containsPoint(7.9, 0));
        System.out.println(cylinder2.containsPoint(2, 1));

        System.out.println(cylinder);
        System.out.println(cylinder2);


    }

}
