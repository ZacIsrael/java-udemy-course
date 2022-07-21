package com.zacisrael;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//        pq.add(1);
//        pq.add(10);
//        System.out.println(pq.poll());
//        pq.add(3);
//        System.out.println(pq.peek());
//        pq.add(20);
//        System.out.println(pq.poll());

        Deque<Integer> deque = new ArrayDeque<Integer>();

        deque.addFirst(99);
        deque.offerLast(39);
        deque.push(4);
        deque.add(5);
        deque.add(7);
        deque.addLast(105);
        deque.add(1);
        deque.add(3);
        deque.offer(19);
        deque.offerFirst(29);
        //29,4,99,39,5,7,105,1,3,19

        Iterator<Integer> itr = deque.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + ", ");
            // 29,4,99,39,5,7,105,1,3,19
        }
        System.out.println("\n");
        deque.remove();
        deque.remove();
        Iterator<Integer> numitr = deque.iterator();
        while(numitr.hasNext()){
            System.out.print(numitr.next() + ", ");
            // 99,39,5,7,105,1,3,19
        }
        System.out.println("\n");
        deque.pop();
        Iterator<Integer> numitr2 = deque.iterator();
        while(numitr2.hasNext()){
            System.out.print(numitr2.next() + ", ");
            // ,39,5,7,105,1,3,19
        }
        System.out.println("\n");
        deque.removeLast();
        Iterator<Integer> numitr3 = deque.iterator();
        while(numitr3.hasNext()){
            System.out.print(numitr3.next() + ", ");
            // 39,5,7,105,1,3,
        }
        System.out.println("\n");
        deque.removeFirst();
        Iterator<Integer> numitr4 = deque.iterator();
        while(numitr4.hasNext()){
            System.out.print(numitr4.next() + ", ");
            // 5,7,105,1,3,
        }
//        int a = 10;
//        int b = 20;
//        System.out.println(a);
//        System.out.println(b);
//
//        swapIntVal(a, b);
//        String s = "ab";
//        System.out.println("String s before change() method " + s);
   //     change(s);

//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(1000);
//        numbers.add(2);
//        numbers.add(11);
//        numbers.add(5);
//        numbers.add(39);
//        int a = 52;
//        numbers.add(a);
//        Iterator<Integer> firstItr = numbers.iterator();
//        while(firstItr.hasNext()){
//            System.out.println(firstItr.next());
//        }
//        System.out.println("The size of the numbers arrayList is " + numbers.size());
//        numbers.remove(2);
//        numbers.remove(1);
//        numbers.remove(0);
//        System.out.println("The size of the numbers arrayList is " + numbers.size());
//        Iterator<Integer> itr = numbers.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }



    }
    public static void swapIntVal(int var1, int var2){
        int temp = var1;
        var1 = var2;
        var2 = temp;

        System.out.println("a: " + var1 + " b: " + var2);
    }
    public static void change(String string){
        string = "cd";
        System.out.println("String s after change() method " + string);
    }


}
