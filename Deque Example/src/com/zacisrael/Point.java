package com.zacisrael;

public class Point {
    public int x = 0;

    public static void  modifyMember(Point p){
        p.x = 5;
        return;
    }

    public static void main(String[] args) {
        Point myPoint = new Point();
        System.out.println(myPoint.x);
        modifyMember(myPoint);
        System.out.println(myPoint.x);
    }
}
