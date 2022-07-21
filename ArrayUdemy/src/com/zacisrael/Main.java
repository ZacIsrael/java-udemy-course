package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myIntArray = {1,2,3,4,5,6,7,8,9,10}; // assigns elements and says how many elemements there are in the array
        int[] mySecondIntArray = new int[15];
       /* myIntArray[0] = 45;
        myIntArray[1] =476;
        myIntArray[5] = 50; */


        double[] myDoubleArray = new double[10];
        //System.out.println(mySecondIntArray[5]);
        //System.out.println(mySecondIntArray[6]);

        for(int i = 0; i < mySecondIntArray.length; i++){ // this for loop assigns a value for all of the elements
            mySecondIntArray[i]= i * 3;
        }
        printArray(mySecondIntArray);

    }
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }
}
