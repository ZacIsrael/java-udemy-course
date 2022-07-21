package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
       /* int[] x1 = {2, 5, 3, 0, 15};
        printArray(onlyMultiples(x1, 5));
        //int[] x2 = {1, 2, 3};
        //printArray(onlyMultiples(x2, 5));
        printArray(beforeFirstNegative(new int[]{2, 0, 1, -3, 5, -2, 1}));
        printArray(split("banana", 3));
        printArray(split("hello", 3));  */

        int[][] x = {{1, 2, 3}, {4, 5, 6}};
        printArray(x);
        multiply(x, 2);
        printArray(x);

        printArray(filledMatrix(4, 3));
        printArray(pyramid("hello"));
        printArray(multTable(5));


    }


    public static int[] onlyMultiples(int[] array, int k){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % k == 0){
                count++; // counts how many elements are multiples of k
            }
        }
        int[] result = new int[count]; // makes the new array the length of the count
        int j = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] % k == 0){
            result[j] = array[i]; // the result at element j = the element in array i if it is a multiple of k
            j++; // increase j every time there is a multiple of k
        }
        }
        return result;

    }

    public static int[] beforeFirstNegative(int[] array){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                break; // if the i element in the array is negative, stop running the loop
            }
            count++; // add to the count every time the loop runs successfully
        }
        int[] result = new int[count]; // the array should be the length of the count
        int j = 0;
        for(int i = 0; i < count;i++){
            result[j] = array[i];
            // the j element in the result array should equal the i element in the original array until the result array
            // is the length of the count because the next element after will be negative
            j++; // increase j every time
        }
        return result;
    }


    public static String[] split(String s, int k){
        String[] result = new String[k];
       int start = 0;
       int end = 0;
       for(int i = 0; i < k; i++){
           end = start + s.length()/k;
           // the end of the substring is the start value + the length of each substring (s.length()/k)
           result[i] = s.substring(start,end);
           // the i value for the array is the substring from the current start to the current end
           start = end;
           // the start value = the current end value , so the end value will increase in the next iteration of the loop
       }
       if(start < s.length()){
           result[k-1] += s.substring(start);
      }
      return result;
    }

    public static void multiply(int[][] array, int k){

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] *= k;
            }
        }
    }

    public static int[][] filledMatrix(int rows, int cols){
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                result[i][j] = i + 1;
                // The value will be i + 1 for all of the columns in row i because i starts from 0
            }
        }
        return result;
    }

    public static char[][] pyramid (String s){
        char[][] result = new char[s.length()][s.length()];

        for(int row = 0; row < s.length(); row++){

            for(int col = 0; col < s.length(); col++){
                if(col <= row){
             // if the column number is less than the row number, the result at that element will equal s col th character
                   result[row][col] = s.charAt(col);
                }
                else{
                    result[row][col] = '*';
                    // otherwise return the star
                }
            }
        }
        return result;
    }
    // Write a method named multTable(int n) that takes an integer n and returns a 2D
    //array of integers representing an n * n multiplication table.

    public static int[][] multTable(int n){
        int[][] result = new int[n][n];

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                    result[row][col] = (col + 1) * (row + 1);
            }
        }
        return result;
    }



    public static void printArray(int[] x) {
        System.out.print("{");
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + ", ");
        }
        if (x.length > 0) {
            System.out.print(x[x.length - 1]);
        }
        System.out.println("}");
    }
    public static void printArray(String[] x) {
        System.out.print("{");
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + ", ");
        }
        if (x.length > 0) {
            System.out.print(x[x.length - 1]);
        }
        System.out.println("}");
    }
    public static void printArray(int[][] x) {
        for (int row = 0; row < x.length; row++) {
            for (int col = 0; col < x[row].length; col++) {
                System.out.print(x[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printArray(char[][] x) {
        for (int row = 0; row < x.length; row++) {
            for (int col = 0; col < x[row].length; col++) {
                System.out.print(x[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
