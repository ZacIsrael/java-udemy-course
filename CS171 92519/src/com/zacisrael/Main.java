package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyStack myStack = new MyStack(5);
        myStack.push("Hello");
        myStack.push("Bye");
        myStack.push("Good");
        myStack.push("What's up");
        myStack.push("How are you?");
       // myStack.getArray();
        myStack.getSize();
    }
}
