package com.zacisrael;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortArray(myIntegers);
        printArray(sorted);


    }
    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values. \r");
        int[] values = new int[number];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();

        }
        return values;
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
    public static int[] sortArray(int[] array){
        int[] result = Arrays.copyOf(array,array.length); // creates copy of the array
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for (int i = 0; i < result.length-1; i++) {
                if(result[i] < result[i + 1]){
                    temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return result;
    }
}
