package com.zacisrael;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// test cases
        int[] x1 = withoutDuplicates(new int[]{1,2,1,1,3,2,3});
        printArray(x1);
        int[] x2 = withoutDuplicates(new int[]{1,9,2,8,0,1,5,1,9,0,3,2,5,3,8});
        printArray(x2);
        int[] x3 = withoutDuplicates(new int[]{50, 7, 65, 79, 7, 65, 50, 50, 50, 7, 79, 65, 50, 79});
        printArray(x3);

    }
    public static int[] withoutDuplicates(int[]x){

        int maxIntValue = 999999999; // This is the largest number an integer in the array can be

        boolean[] valueExistsTracker = new boolean[maxIntValue + 1]; // add "+ 1" since we start counting from 0 in java
        // valueExistsTracker array keeps track of every value that exists in he array by setting the specified index to true.

        int valuesCount = 0; // valuesCount keeps tracks of each value in the array that corresponds with an index in the array

        for(int i = 0; i < x.length; i++){ // run this loop for the length of the array
            int currentValue = x[i]; // set the integer currentValue to the "i" index of array x

            if(!valueExistsTracker[currentValue]){
                //if the "i" element of the x variable is not already set to true in the valueExistsTracker variable,
                valueExistsTracker[currentValue] = true; // set it to true
                valuesCount++; // & increment the valuesCount or otherwise, go to the next iteration of the loop.
            }
        }

        int result[] = new int[valuesCount];
        // The result will be an array the length of the valuesCount number because the valuesCount counts
        // how many times the if statement finds a new integer, which means there will be no duplicates
        int index = 0;

        for(int i = 0; i < valueExistsTracker.length; i++){
            if(valueExistsTracker[i]){ // if the boolean array valuesExitsTracker at index i is true then,
                result[index++] = i; // store it at the the current index. Move to the next index afterwards
            }
        }
        return result;




    }

    public static void printArray(int[] array) { // Method for printing the array
        System.out.print("{"); // Print the open bracket
        // Do "System.out.print" instead of "System.out.println" so the values do not go to a new line.
        for (int i = 0; i < array.length; i++) { // run this loop the number of times the length of the array
            System.out.print(array[i]);
            if (i < array.length - 1) { // This if statements adds a comma after every element except the last one
                System.out.print(", ");
            }
        }
        System.out.print("}"); // end the line with a closed bracket
        System.out.println("\t"); // moves to the next line
    }


}
