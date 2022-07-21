package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        toMilesPerHour(1.5);
        toMilesPerHour(10.25);
        toMilesPerHour(-5.6);
        toMilesPerHour(25.42);
        toMilesPerHour(75.114);
    }
    public static void toMilesPerHour(double kilometersPerHour){


       double conversion = kilometersPerHour * .621371;



        if (kilometersPerHour < 0){
            System.out.println(-1);

        }
        else {
            System.out.println((int) conversion);
        }


    }
}
