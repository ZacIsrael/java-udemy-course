package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	int myIntValue = 5 / 2; // If you divide an integer by a number and the answer is a decimal, it will only show th number before the decimal
    // int has a width of 32 ( 4 bytes )

	float myFloatValue = 5f / 3f;// f after the number means that it is a float value, float is a number with a decimal, will print out 7 decimal points
    // float has a width of 32 ( 4 bytes )

    double myDoubleValue = 5d / 3d; // double a number with a decimal, printout 16 decimal points
    // double has a width of 64 ( 8 bytes)


        System.out.println("myIntValue = " + myIntValue);
        System.out.println("MyFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);
 // Challenge : Convert a given number of pounds to kilograms
        // 1. Create a variable to store the number of pounds
        // 2. Calculate the number of kilograms for the number above and store in a variable
        // 3. Print out the result

        // 1 pound = .45359237

double numPounds = 165;
double poundsTokilos = numPounds * .45359237;

        System.out.println(poundsTokilos);
        // 74.8427 Kg

    }
}
