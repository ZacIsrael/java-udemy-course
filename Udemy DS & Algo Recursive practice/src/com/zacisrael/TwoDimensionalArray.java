package com.zacisrael;

public class TwoDimensionalArray {

    int arr[][] = null;

    public TwoDimensionalArray(int numRows, int numCols) {
        this.arr = new int[numRows][numCols];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[numRows][numCols] = Integer.MIN_VALUE; // initializes empty array

            }
        }
    }


    public void traverseArray(){
        try{
            System.out.println("Printing the array now...");
            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[0].length; col++) {
                    System.out.println(arr[row][col] + "  ");
                }
                System.out.println(); // starts next column at a new line

            }
        } catch (Exception e){
            System.out.println("Array does not exist");
        }
    }


}
