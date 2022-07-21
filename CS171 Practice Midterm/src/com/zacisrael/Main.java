package com.zacisrael;

import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(1);
        pq.add(10);
        System.out.println(pq.poll());
        pq.add(3);
        System.out.println(pq.peek());
        pq.add(20);
        System.out.println(pq.poll());
        System.out.println("\n");
//
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(10);
//        stack.push(3);
//        stack.pop();
//        stack.push(7);
//        stack.pop();
//        stack.push(20);
//
//        while (!stack.empty()) {
//            System.out.println(stack.pop());
//        }
//        System.out.println("\n");

        int[] testCase1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(smallestN(testCase1, 2));
        System.out.println(smallestN(testCase1,3));
       // System.out.println(topN(testCase1,6));
//        int[] testCase2 = new int[]{0,3,1,4,-1};
//        System.out.println(topN(testCase2,2));
//        System.out.println(topN(testCase2,4));
    }

    public static int[] topN(int[] array, int biggest) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] newArray = new int[biggest];
        try {
            for (int i = 0; i < array.length; i++) {
                stack.add(array[i]);
            }
            for (int i = 0; i < biggest; i++) {
                newArray[i] = stack.pop();
             
            }
            return newArray;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return new int[0];
        }
    }
    public static int[] smallestN(int[] array, int smallestN){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] smallArray = new int[smallestN];
        for(int i = 0; i < array.length; i++){
            pq.add(array[i]);
        }
        for (int i = 0; i < smallestN; i++) {
            smallArray[i] = pq.poll();
           // pq.poll();
        }
        return smallArray;
    }
}
