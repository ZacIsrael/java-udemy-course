package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /* System.out.println(true);

        System.out.println(5 < 2);

        boolean x = true;
        boolean y = 5 < 2;



       boolean operator precedence
         1. !
         2. &&
         3. ||

        smallestNumber(5,2);
        smallestNumber(2,5);
        smallestNumber(5,5);

        longestString("bye", "hello");
        longestString("Zacchaeus", "love");

        System.out.println(state0fWater(59));
        System.out.println(state0fWater(105));
        System.out.println(state0fWater(-31)); */

        System.out.println(letterGrade(87));
        System.out.println(letterGrade(61));
        System.out.println(letterGrade(53));
        System.out.println(letterGrade(92));
        System.out.println(letterGrade(72));

    }

    public static double smallestNumber(double x, double y) {


        if (x < y) {
            System.out.println(x);
            return x;
        } else {
            System.out.println(y);
            return y;
        }
    }

    public static String longestString(String s1, String s2) {


        if (s1.length() > s2.length()) {
            System.out.println(s1);
            return s1;

        } else {
            System.out.println(s2);
            return s2;
        }

    }

    public static String state0fWater(double temp) {
        String state;

        if (temp <= 0) {
            state = "solid";
        } else if (0 < temp && temp <= 100) {
            state = "liquid";

        } else {
            state = "gas";
        }
        return state;
    }

    public static String letterGrade(int points) {

        String grade;

        if (points >= 90 && points <= 100) {
            grade = "A";
        } else if (points >= 80 && points <= 89) {
            grade = "B";
        } else if (points >= 70 && points <= 79) {

            grade = "C";
        } else if (points >= 60 && points <= 69) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;

    }
}
