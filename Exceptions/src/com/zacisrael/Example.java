package com.zacisrael;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException  | NoSuchElementException e){
            // catches arithmetic exception or no such element exception
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    public static int divide(){
        int x, y;
    //    try{
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
//        } catch(NoSuchElementException e){
//           throw new ArithmeticException("no suitable input");
//           // this message will be displayed if the user types in anything
//            // other than an integer.
//        } catch (ArithmeticException e){
//            throw new ArithmeticException("attempt to divide by 0");
//            // this message will be displayed if the user sets y = 0
//        }
    }

    public static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while(true){
            try {
                return s.nextInt();
            } catch (InputMismatchException e){
                // In case of an error, we will go around again.
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }
}
