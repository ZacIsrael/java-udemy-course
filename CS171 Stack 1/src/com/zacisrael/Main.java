package com.zacisrael;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a = {0,11,22,32,44,75,86,94,98,99,100};
        System.out.println( indexOf(a, 44));

//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(1000);
//        numbers.add(1400);
//        numbers.add(393);
//        numbers.add(23);
//        numbers.add(903);
//        numbers.add(3,2);
//        System.out.println(numbers);
//        System.out.println(numbers.size());
//        System.out.println(numbers.remove(3) + " was removed from the arraylist");
//        System.out.println(numbers);
//        System.out.println(numbers.size());
//
//        Iterator<Integer> numItr = numbers.iterator();
//        while(numItr.hasNext()){ // as long as there is another number in the numbers arraylist,
//            System.out.print(numItr.next() + " "); // print the following message
//
//        }
//        System.out.println("\n");
//        for (int item: numbers) {
//            System.out.println("Item: " + item );
//        }




    }
    public static int indexOf(int[] a, int key){
        int low = 0;
        int high = a.length -1;
        while(low <= high){
           int mid = low + (high-low)/2;
           if(key < a[mid]) {
               high = mid - 1;
           }
           else if(key > a[mid]) {
               low = mid + 1;
           }
           else {
               return mid;
           }
        }

        return -1;
    }
}
