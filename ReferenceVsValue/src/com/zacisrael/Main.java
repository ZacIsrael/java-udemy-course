package com.zacisrael;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue" + anotherIntValue);

        anotherIntValue++;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue" + anotherIntValue);

        int[] myIntArray = new int[5];
        int[] money = myIntArray;

        System.out.println("myIntArray = "+Arrays.toString(myIntArray));
        System.out.println("money array = "+Arrays.toString(money));

        money[0] = 1;


        System.out.println("After change myIntArray = "+Arrays.toString(myIntArray));
        System.out.println("After change money array = "+Arrays.toString(money));

        money = new int[]{4,5,6,7,8};
        modifyArray(myIntArray);


        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(money));


    }
    private static void modifyArray(int[] array){
        array[0] =2;
        array = new int[]{1,2,3,4,5};
    }
}
