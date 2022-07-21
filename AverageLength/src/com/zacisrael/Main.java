package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        // write your code here


        System.out.println(avgLength(new String[]{"Hello", "Q"})); // Test cases
        System.out.println(avgLength(new String[]{"love", "Zacchaeus", "Haiti", "masculine"}));



    }
    public static double avgLength(String[] x){
        double result = 0;
        for ( int i = 0; i < x.length; i++){ // run this loop the length of the array
            result += x[i].length(); // add the length of each String in the Array to the count each time
        }
        result = result / x.length;
        // divide the result from the "for" loop by the length of the array in order to find the average length of all the Strings in the array

        return result; // return the final result
    }
}
