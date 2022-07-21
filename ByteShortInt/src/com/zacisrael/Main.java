package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        //int has a width of 32
	    int myMinValue= -2_147_483_648;
        int myMaxValue= 2_147_483_647;
        int myTotalValue = (myMinValue/2);
        System.out.println("myTotal = " + myTotalValue);

        // byte has a width of 8
	    byte myByteValue = 10; // a byte can only store numbers from -128 to 127
        byte myNewByteValue = (byte) (myByteValue/2);
        System.out.println("myNewByteValue = " + myNewByteValue);


        // short has a width of 16
        short myShortValue = 30000;  // largest value can be 32768 and smallest value can be -32768
        short myNewShortValue = (short) (myShortValue/2);


        // long has a width of 64
        long myValue = 100L; // smallest number can be -9_223_372_036_854_775_808L, largest number can be 9_223_372_036_854_775_807L


      // Udemy Assignment
        byte mySecondByteValue = 84;

        short mySecondShortValue = 300;

        int myintValue = 603;

        long longTotal = 50000L + 10L * (mySecondByteValue + mySecondShortValue + myintValue);
        short shortTotal = (short) (8 + 7 * (mySecondByteValue + mySecondShortValue + myintValue));


        System.out.println(" longTotal = " + longTotal);
        System.out.println(" shortTotal = " + shortTotal);




    }
}
