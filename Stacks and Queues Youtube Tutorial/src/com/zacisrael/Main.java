package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        LastStack stack = new LastStack();
        stack.push(5);
        stack.push(15);
        stack.push(10);
        System.out.println(stack.peek());

        stack.show();

        stack.pop();
        stack.show();
    }
}
