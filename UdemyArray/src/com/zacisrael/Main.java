package com.zacisrael;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        int[] myIntegers = getIntegers(5);
        for(int i = 0; i < myIntegers.length; i++){
            System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
        }
        System.out.println("The avaerage is " + getAverage(myIntegers));

    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }
    public static double getAverage(int[] array){
        int result = 0;
        for(int i = 0; i < array.length; i++){
            result += array[i];
        }
        return (double) result / (double)array.length;
    }
}
