package com.zacisrael;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(isReverse("happy", "yppah"));
       // System.out.println(isReverse("cool", "loac"));

    }

    public static String isReverse(String s1, String s2) {
        boolean reverse = false;
        String s3 = s1;
        if (s3.length() <= 1) {
           return s3;
        } else {
            return s3.charAt(s3.length() - 1) + isReverse(s3.substring(0, s3.length() - 1), s2);
        }
    }


}
