package com.zacisrael;

import java.util.Arrays;

public class TheStack {

    private String[] stackArray;

    private int stacksSize;

    private int topOfStack = -1;

    TheStack(int size){
        stacksSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String input){ // adds an item to the stack, pushes the info onto array
        if(topOfStack + 1 < stacksSize){
            // checks if there is room in the array to add an item to the stack
            topOfStack++;
            stackArray[topOfStack] = input;


        } else System.out.println("Sorry but the Stack is full");

        System.out.println("PUSH " + input + " Was Added to the stack");

    }

    public String pop(){ // gets information off of a stack and removes it from array

        if(topOfStack >= 0){
            System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];

        } else{
            System.out.println("Sorry but the stack is empty");
            return "-1";
        }

    }

    public String peek(){ // to see what is at the top of the stack, but will not remove it
        System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack" +"\n");
        return stackArray[topOfStack];
    }

    public void pushMany(String multipleValues){
        String[] tempString = multipleValues.split(" ");
        for (int i = 0; i < tempString.length ; i++) {
            push(tempString[i]);

        }
    }

    public void popAll(){
        for (int i = topOfStack; i >= 0 ; i--) {
            // starts from the top & decrements to element 0
            pop();
        }
    }


    public static void main(String[] args) {

        TheStack theStack = new TheStack(10); // gives us 10 spaces for us to put info into

        theStack.push("10");
        theStack.push("15");
        theStack.pushMany("1 7 99 86 41 8 12 14");
        theStack.popAll();

//        theStack.peek();
//        theStack.pop();

    }
}
