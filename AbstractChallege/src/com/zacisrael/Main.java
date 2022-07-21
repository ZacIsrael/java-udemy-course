package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here

        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        String stringData = "2 34 71 93 47 82 0 54";

        String[] data = stringData.split(" ");
        // This will create an array that starts a new element every time there is a space before a character
        for (String s: data) {

            list.addItem(new Node(s)); // Adds the items to the list and puts them in alphabetical order
        }
        list.traverse(list.getRoot());
        list.removeItem(new Node("34"));
        list.traverse(list.getRoot());

//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("2"));
//        list.traverse(list.getRoot());
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("0"));
//        list.traverse(list.getRoot());
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("47"));
//        list.traverse(list.getRoot());
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("54"));
//        list.traverse(list.getRoot());
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("71"));
//        list.traverse(list.getRoot());
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("82"));
//        list.traverse(list.getRoot());
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("93"));
//        list.traverse(list.getRoot());
    }
}
