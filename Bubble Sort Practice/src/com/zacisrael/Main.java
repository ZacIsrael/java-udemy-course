package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] test = new int[]{5,3,4,1,8,9,0,6,2,7};
        bubbleSort(test, test.length);




    }

    public static void bubbleSort(int array[], int n){
        int temp;
        boolean swapped;
        for (int i = 0; i < n-1; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;

                }
            }
            if(swapped == false){
                break;
            }
        }
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = 1;
            for (int j = i+1; j < N; j++) {


            }
        }
    }

}
