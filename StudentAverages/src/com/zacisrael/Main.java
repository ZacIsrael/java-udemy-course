package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        // Test cases
        double[] x1 = studentAverages(new int[][]{{50,100,0},{100,100,80}});
        printArray(x1);
        double[] x2 = studentAverages(new int[][]{{95,10,51,72},{100,73,100,80}});
        printArray(x2);



    }
    public static double[] studentAverages(int[][] x){
        double row = 0; // counter to track the sum for all of the elements in the first row
        double row2 = 0; // counter to track the sum for all of the elements in the second row
        for (int col = 0; col < x[0].length; col++){ // run this loop the length of the first row
            row += x[0][col]; // add up all the values in this row to get the sum of this row
        }
        row = row/x[0].length; // divide this sum by the number of elements/ integers in this row to get the average

        for (int col = 0; col < x[1].length; col++){ // run this loop the length of the second row
            row2 += x[1][col]; // add up all the values in this row to get the sum of this row
        }
        row2 = row2/x[1].length; // divide this sum by the number of elements/ integers in this row to get the average

        double [] result = new double[]{row,row2};
        // the new array will consist of the average of row 1 and the average of row 2

        return result;
    }

    public static void printArray(double[] array) { // Method for printing the array
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
