package com.zacisrael;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
       int[] myArray = readIntegers(6);
        System.out.println( findMin(myArray));


    }
    public static int[] readIntegers(int count){
        int[] values = new int[count];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();

        }
        return values;

    }
    public static int findMin(int[] array){
        int result = 0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]){
                result = array[i+1];
            }
            if(array[0] < result){
                result = array[0];
            }
        }
        return result;
    }

}
