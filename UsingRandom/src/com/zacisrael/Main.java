package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	    //Math.random() generates a pseudo - random number between 0 (inclusive) and 1 (exclusive)

        System.out.println(Math.random());

        // What are the possible values for x?
        // double 0.0 <= x < 30.0
        double x = Math.random() * 30;
        System.out.println(x);

        int y = (int)(Math.random() * 30); // will give a random integer between 0 (inclusive) and 30 (exclusive)
        System.out.println(y);

        int z = (int)(Math.random() * 30) -15; // will give a random integer between -15(inclusive) and 14 (exclusive)
        System.out.println(z);


    }
}
