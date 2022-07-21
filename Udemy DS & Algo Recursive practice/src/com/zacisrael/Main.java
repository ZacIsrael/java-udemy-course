package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here

       int[] arr = {5,6,8,9,12,1,3,6};
        foo(3);
        System.out.println(factorial(5));

        System.out.println(fibonacci(6));

        System.out.println(  searchValue(arr, 12));

        System.out.println(deleteValue(arr, 0));

        int[][] array ={{10,3,4,5,6,7},{15,43,0,98,47,1}}; // a 2D array with 2 rows and 6 columns

    }

    public static void foo(int n){
        if(n<1){
            return;
        } else {
            foo(n-1);
            System.out.println("Hello World " + n);
        }
    }

    public static int factorial(int n){
        if(n < 1){
            return 1;
        } else{
            return n * factorial(n-1);
        }
    }

    public static int fibonacci(int n){
        if(n < 1){
            throw new RuntimeException("You cannot to the fibonacci series for negative numbers.");
        } else if(n == 1 || n == 2){
            return n-1;
        } else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public int findBiggest(int arr[]){
        int biggestNumber = arr[0];

        for(int i = 1; i < arr.length-1; i++){
            if(arr[i] > biggestNumber){
                biggestNumber = arr[i];
            }
        }
        return biggestNumber;
    }

    public static int searchValue(int[] array, int search){
        for(int i = 0; i < array.length; i++){
            if(array[i] == search){
                return array[i];
            }
        }
        return -1;
    }

    public static int deleteValue(int[] arr, int j) {
        if (j > arr.length) {
            throw new RuntimeException("The array is not that big.");
        }
        int deleted = arr[j];
        arr[j] = (int) Math.pow(-2, 31);
        return deleted;
    }

}
