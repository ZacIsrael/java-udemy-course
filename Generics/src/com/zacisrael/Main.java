package com.zacisrael;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);

        printDoubledArrayList(items);

    }

    private static void printDoubledArrayList(ArrayList<Integer> n) {
        for (int i : n) {
            System.out.println( i * 2);
            // Convert whatever data type i is to an integer and multiply it by 2
        }
    }


}
