package com.zacisrael;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        LinkedList<String> linkedList = new LinkedList<String>();
//        linkedList.add("Life");
//        linkedList.add("Joseph");
//        linkedList.add("Zac");
//        linkedList.add("Awesome");
//        linkedList.add("chess");
//        linkedList.add("mad");
//        linkedList.add("name");
//        linkedList.add("race");
//        linkedList.add("height");
//        linkedList.add("Awesome");
//        linkedList.add("hour");
//        linkedList.add("glass");
//        linkedList.add("Awesome");
//        linkedList.add("write");
//        linkedList.add("love");
//
//        System.out.println(linkedList);
//
//        linkedList.remove(); // removes the first element of the LinkedList
//        System.out.println(linkedList);
//        linkedList.remove(1);
//        System.out.println(linkedList);
//        System.out.println( linkedList.get(2));
//        System.out.println(linkedList);
//        linkedList.set(2, "Jackboy");
//        System.out.println(linkedList);
//        linkedList.pop();
//        System.out.println(linkedList);
//        linkedList.removeLastOccurrence("Awesome");
//        System.out.println(linkedList);
//        linkedList.removeLastOccurrence("Awesome");
//        System.out.println(linkedList);
//        linkedList.removeLastOccurrence("Awesome");
//        System.out.println(linkedList);
//        linkedList.removeFirst();


        SimpleLinkedList list = new SimpleLinkedList();
        try{
            list.getFirst();
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        list.addFirst("lies");
        list.addFirst("be");
        list.addFirst("or");
        list.addLast("safe");
        list.addLast("truth");
        list.addFirst("life");
        list.addLast("Zac");
        System.out.println(list);

        list.removeFirst();

        System.out.println("\n");
        System.out.println(list.get(0));
        System.out.println(list.get(4));
        System.out.println(list.get(1));

        System.out.println("\n");
        list.remove("be");
        System.out.println(list);
       // System.out.println(list.get(23));



        Iterator<String> ite = list.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }
}
