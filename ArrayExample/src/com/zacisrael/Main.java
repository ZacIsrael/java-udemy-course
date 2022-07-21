package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] a; // declare an array
        a = new int[4]; // create an array with 4 slots
        a[0] = 7; // assigning number 7 to the first element of the array "a"
        a[1] = 3;
        a[2] = 15;
        a[3] = 9;

        //System.out.println(a[2]);

        int [] b = new int[0]; // an array that is completely empty

       /* for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " "); // prints all of the numbers in the array on the same line
        }

        System.out.println(sumAll(a));
        System.out.println(sumAll(b));  */
        System.out.println(arrayToString(a));
        System.out.println(minValue(a));
        System.out.println(minIndex(a));

    }
    public static int sumAll(int[] x){
        int result = 0;

        for (int i = 0; i < x.length; i++){
            result += x[i]; // the result equals the current element of the array plus the previous elements of the array
        }

        return result;
    }
    public static String arrayToString(int[]x){
        String result = "["; // Opens the braces
        for (int i = 0; i < x.length - 1; i++){
            result += x[i] + ", ";
        }
        if ( x.length > 0) {
            result += x[x.length - 1];
        }
        result += "]"; // Closes the brace
        return result;
    }
    public static int minValue(int[] x){
        int min = x[0];

        for (int i = 1; i < x.length; i++){
          if( x[i] < min){
              min = x[i];
          }
        }
        return min;
    }
    public static int minIndex(int[] x){
        int result = 0;
        for (int i = 1; i < x.length; i++){
            if (x[i] < x[result]) {
                result = i;
            }
        }
        return result;
    }
}
