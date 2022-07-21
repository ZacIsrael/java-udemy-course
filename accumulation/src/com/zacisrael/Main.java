package com.zacisrael;

import jdk.internal.joptsimple.internal.Strings;

public class Main {

    public static void main(String[] args) {
	// write your code here

       /* System.out.println(sumN(15));
        System.out.println(sumN(9));
        System.out.println(sumN(5));
        System.out.println(sumN(7));
        System.out.println(sumN(39));
        System.out.println(sumN(1050));
        System.out.println(sumN(-5));

        System.out.println(multN(9));
        System.out.println(multN(8));
        System.out.println(multN(7));
        System.out.println(multN(6));
        System.out.println(multN(5));
        System.out.println(multN(4));
        System.out.println(multN(3));
        System.out.println(multN(2));
        System.out.println(multN(1));

        System.out.println(sumMult5(3));
        System.out.println(sumMult5(9));
        System.out.println(sumMult5(5));
        System.out.println(sumMult5(12));
        System.out.println(sumMult5(15));
        System.out.println(sumMult5(16));
        System.out.println(sumMult5(0)); */

        System.out.println(multiplyString("hey", 3));
        System.out.println(multiplyString("Zac", 6));

    }
    public static int sumN(int n){

        int result = 0;
        for (int i = 1; i <= n; i++){
            result = result + i;
        }
        return result;


    }
    public static int multN(int n){
        int result = 1;

        for(int i = 1; i <= n; i++) {
            result =  result * i;
        }
        return result;
    }
    public static int sumMult5(int n){
        int result = 0;
        for(int i = 5; i <= n; i+= 5){ // incrementing by 5 every time
            result += i; // Same as typing "result = result + i;"
        }
        return result;
    }
    public static int multiplyString(String s , int n){

        String result = "";

        for ( int i = 0; i < n; i++){
           result = result + s;
        }
        return result;

    }


}
