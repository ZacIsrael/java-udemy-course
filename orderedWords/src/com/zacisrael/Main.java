package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(isOrdered("Hello"));
        System.out.println(isOrdered("effort"));
        System.out.println(isOrdered("Zacchaeus"));
        System.out.println(isOrdered("Aaaabbbyyy"));

        // Above are my test cases

    }
    public static boolean isOrdered(String x){

        boolean order = false;
        String x2 = x.toLowerCase();
//I converted the entire string to lowercase because Uppercase characters have a higher value than lowercase characters


        if (x2.charAt(0) <= x2.charAt(1)) {
            // If the first character is smaller than or equal to the second character, complete the following code
            for (int i = 1; i < x.length(); i++) {

                if (x2.charAt(i - 1) <= x2.charAt(i)) {
                    // If the previous character is smaller than the current character,
                    order = true; // return true.
                }

                else {
                    order = false; // Otherwise, return false;
                }
            }
        }
        return order; // return the boolean "order" after the loop has finished running

    }
}
