package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(sumOfDiffs(new int[]{3,4,5})); // Test cases
        System.out.println(sumOfDiffs(new int[]{4,1,19,6}));
        System.out.println(sumOfDiffs(new int[]{}));
        System.out.println(sumOfDiffs(new int[]{30, 23, 16, 9}));


    }
    public static int sumOfDiffs(int[] x){
        int result = 0; // set the result to zero because this is an addition problem

        for(int i = 0; i < x.length -1; i++){
            // run this loop 1 less than the length because there is nothing to subtract from the last element in the array
           result += x[i] - x[i + 1]; // subtract the next element from the current element
           // The result equals the previous result plus the next element subtracted from the current element
        }

        return result; // return the result
    }
}
