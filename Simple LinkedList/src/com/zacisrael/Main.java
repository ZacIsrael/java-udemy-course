package com.zacisrael;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Life");
        linkedList.add("Joseph");
        linkedList.add("Zac");
        linkedList.add("Awesome");
        linkedList.add("chess");
        linkedList.add("mad");
        linkedList.add("name");
        linkedList.add("race");
        linkedList.add("height");
        linkedList.add("Awesome");
        linkedList.add("hour");
        linkedList.add("glass");
        linkedList.add("Awesome");
        linkedList.add("write");
        linkedList.add("love");

        System.out.println(linkedList);

        linkedList.remove(); // removes the first element of the LinkedList
        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
        System.out.println( linkedList.get(2));
        System.out.println(linkedList);
        linkedList.set(2, "Jackboy");
        System.out.println(linkedList);
        linkedList.pop();
        System.out.println(linkedList);
        linkedList.removeLastOccurrence("Awesome");
        System.out.println(linkedList);
        linkedList.removeLastOccurrence("Awesome");
        System.out.println(linkedList);
        linkedList.removeLastOccurrence("Awesome");
        System.out.println(linkedList);

    }

}
