package com.zacisrael;

public class SimpleLinkedListTester{

    public static void main(String[]args){
        SimpleLinkedList list = new SimpleLinkedList();

        // Testing: NoSuchElementException
        // System.out.println( list.getLast() );

        // Test your LL methods here ...

        list.addFirst("to");
        System.out.println(list);

        list.addFirst("be");
        System.out.println(list);

        list.addFirst("or");
        System.out.println(list);

        list.addLast("to");
        System.out.println(list);

        list.addLast("be");
        System.out.println(list);

        list.addLast("or");
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(4));

        list.remove("be");
        System.out.println(list);
        list.remove("be");
        System.out.println(list);
        //list.remove("be");
        list.remove("or");
        System.out.println(list);

//     System.out.println(list.get(23)); // What should this do?
    }
}

