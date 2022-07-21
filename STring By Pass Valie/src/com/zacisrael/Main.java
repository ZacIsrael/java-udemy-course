package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        String z = "ab";
//        System.out.println(change(z));


//        for (int i = 100; i % 2 == 0  ; i /= 5) {
//            System.out.println(i);
//        }

        int sum = 1;
        for (int i = 0; i <= 4  ;sum = sum + i++) {
            System.out.println(sum);
        }
//        Point j = new Point();
//        System.out.println(j.point);
//
//        j.point = 3;
//        System.out.println(j.point);
//        changePoint(j);
//        System.out.println(j.point);
//        Point myPoint = new Point(5);
//        System.out.println(myPoint.getPoint());
    }

    public static String  change(String x){
        x = "cd";
        return x;
    }

    public static  void changePoint(Point p){
        p.point = 30;
    }
}
