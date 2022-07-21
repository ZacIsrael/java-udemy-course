package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        //Values
        //Every value has a type

        // int
        System.out.println(90);


        // double
        System.out.println(9.5);
        System.out.println(Math.PI);



        // String
        System.out.println("This is a string");
        System.out.println("hello \"stranger\" "); // slash allows you to put quotes inside of a string

        //Operators
        //Arithmetic operators: + - * / %

        //Addition
        System.out.println(1 + 2);
        System.out.println(1.2 + 2.3);
        System.out.println(1 + 2.3); // returns a double, if you sum up an int & a double

        //Subtraction
        System.out.println(1 -2);
        System.out.println(2.5 -1);

        // Multiplication
        System.out.println(2 * 3);
        System.out.println(2 * 3.5);

        // Division
        System.out.println(3 / 2); // returns 1, because int divided by an int will return an int
        System.out.println(3.0 / 2.0); // returns 1.5, double divided by a double will return a double
        System.out.println(5.0/ 2); // will return double
        System.out.println(5 / 2.0);

        //Modulus
        System.out.println(5 % 3); // will return 2 because 5 divided by 3 has a remainder of 2
        System.out.println(5 % 1);
        System.out.println(0 % 5);
        System.out.println(6 % 2); // Will always return 0 if there is no remainder

        // String concatenation
        System.out.println("Hello " + "everyone"); // adds the two strings together
        System.out.println("I am 18 years old");
        System.out.println(1 +"2" + 3);// will print out 123


        //Length of a String (method)
        System.out.println("hello".length());// will print out 5 because there are 5 letters in "hello"

        //Type conversions
        //int -> double
        System.out.println(1.0 * 5); // will return the double value of 5, will print out 5.0
        System.out.println(0.0 + 5); // will return the double value of 5, will print out 5.0
        System.out.println((double)5); // will return the double value of 5, will print out 5.0

        // double -> int
        System.out.println((int) 5.0); // will print out 5
        System.out.println((int) 5.7); // will print out 5
        System.out.println((int) Math.PI); // will print out 3


        // int or double -> String
        System.out.println(" " + 5); // will print 5 as a string
        System.out.println(" " + Math.PI);

        // String to int
        System.out.println(Integer.parseInt("5") + 2); // will print 7
        System.out.println(Integer.parseInt("5" + 2)); // will print 52 because the 2 is inside of the same parenthesis as "5"

        // String to double
        System.out.println(Double.parseDouble("5.7"));// will print 5.7
        System.out.println(Double.parseDouble("5")); // will print 5.0


        System.out.println(1 + (2 + "3")); // will print out "123"
    }
}
