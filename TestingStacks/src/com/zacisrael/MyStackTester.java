package com.zacisrael;

import java.util.Stack;
import java.util.Scanner;

// Test MyStackImplementation's functionalities here
public class MyStackTester {

    public static void main(String[] args){
        // Driver code here that instantiates objects of class MyStackImplementation
        int cap = 4;
        MyStack ms = new MyStack(cap);

        // Testing:
        // System.out.println(ms.isEmpty());
        // System.out.println(ms.isFull());

        ms.push("to");
        ms.push("be");
        ms.push("lala");
        ms.push("la");
        ms.push("ta");
        ms.push("nlej");
        //System.out.println(ms.pop()); //expected?
        //System.out.println(ms.pop()); //expected?
        //System.out.println(ms.pop()); //expected?

        // TODO: Test MyStackDynamic here as well....

    }

}
