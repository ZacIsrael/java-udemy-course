package com.zacisrael;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deque<String> deque = new ArrayDeque<String>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.remove();
        deque.add("D");

        Iterator<String> ite = deque.descendingIterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
        System.out.println("\n");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(1);
        priorityQueue.add(10);
        System.out.println(priorityQueue.remove());
        priorityQueue.add(3);
        System.out.println(priorityQueue.peek());
        priorityQueue.add(20);
        priorityQueue.remove();
        System.out.println(priorityQueue.remove());

        

    }
}
