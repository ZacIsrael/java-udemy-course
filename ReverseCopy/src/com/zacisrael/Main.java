package com.zacisrael;



public class Main {

    public static void main(String[] args) {

        // Test cases
        int[] x1 = reverseCopy(new int[]{1, 2, 3});
        printArray(x1);
        System.out.println("\t"); // "\t" = tab, moves it to the next line
        int[] x2 = reverseCopy(new int[]{31, 45,11,32, 87});
        printArray(x2);
        System.out.println("\t");




    }

    public static int[] reverseCopy(int[] x) {
        int[] result = new int[x.length]; // set the result array to the same length as the result x
        int myIndex = 0; // starting integer myIndex from 0
        for (int i = x.length; i > 0; i--) { // add -- because we are going down by 1 each time instead of incrementing by 1
            // start this loop from the integer at x.length and end it when i = 0
            result[myIndex++] = x[i - 1]; // Increase the myIndex by 1 every time we go through the loop.
            //The value for this element will be 1 subtracted from the current value of i,
            // so the last element in the original array (which is really the second to last element since the count starts from 0)
            // will be in index 0.

        }

        return result; // return the array

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
    }

}




