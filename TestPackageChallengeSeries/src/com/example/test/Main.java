package com.example.test;

import com.zacisrael.mylibrary.Series;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for (int i = 0; i < 10; i++) {
            System.out.println("nSum at " + i + " = " +Series.nSum(i));
            System.out.println("factorial at " + i + " = " +Series.factorial(i));
            System.out.println("fibonacci at " + i + " = " +Series.fibonacci(i));

        }
    }
}
