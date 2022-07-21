package com.zacisrael;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Exception: an event which occurs during the execution of a program that disrupts
    // the normal flow of the programs instructions

    public static void main(String[] args) {
	// write your code here
//        int x = 90;
//        int y =0;
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divideLBYL(x,y));
      //  System.out.println(divide(x,y));

        int x = getIntEAFP();
        System.out.println("x is " + x);
    }
    private static int divideLBYL(int x, int y){
        //look before you leap = LBYL, checks if something will work before it's tested
        if(y!=0){
            return x/y;
        } else{
            return 0;
        }
    }

    private static int divideEAFP(int x, int y){
        // easy to ask for forgiveness, then permission = EAFP
        // runs the test first and then will handle the exception if there is one

        try{
            return x/y;
        } catch (ArithmeticException e){
            return 0;
        }

    }

    private static int divide(int x, int y){
        return x/y;

    }

    private static int getInt(){
        // This method does not handle possible exceptions
       Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    private static int getIntEBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                // checks to see if each character in the string is not a number
                isValid = false;
                break; // break out of the loop
            }

        }
        if(isValid){
            return Integer.parseInt(input);
            // converts string to an integer
        }
        return 0;
        // return 0 if the string cannot be converted to an integer
    }
    private static int getIntEAFP(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try{
            return s.nextInt();
        } catch (InputMismatchException e){
            // catches the exception after it has been tested,
            // if we type in something than an integer, the program will return 0
            return 0;
        }
    }

}
