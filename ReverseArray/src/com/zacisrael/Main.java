package com.zacisrael;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] money = new int[]{3,8,9,4,2,1};
        System.out.println(Arrays.toString(money));
       reverseArray(money);
        System.out.println(Arrays.toString(money));

    }
    public static void reverseArray(int[] array){
        int maxIndex = array.length-1;
        int halfLength = array.length/2;
        for (int i = 0; i < halfLength; i++) {

            int temp = array[i];
            array[i] = array[maxIndex -i];
            array[maxIndex-i] = temp;
        }


    }
}
