package com.zacisrael;

//  import java.util.Arrays;
import java.util.Stack;

public class MyStack extends Stack {


    private int myArraySize;
    private int[] myArray = new int[myArraySize];
    private int topOfStack;

    public MyStack(int myArraySize) {
        this.myArraySize = myArraySize;

       // myArray = new int[myArraySize];
//        Arrays.fill(myArray,-1);
    }

    @Override
    public Object push(Object item) {
        System.out.println(item + " has been added to the stack.");
        return super.push(item);
    }

    @Override
    public synchronized Object pop() {
        if(!isEmpty()) {
            return super.pop();
        }
        return 0;
    }

    @Override
    public synchronized Object peek() {
        return super.peek();
    }

    @Override
    public boolean empty() {
        return super.empty();
    }


    @Override
    public synchronized Object lastElement() {
        if(!isEmpty()) {
            return super.lastElement();
        }
        System.out.println("The stack is empty, there is nothing to pop.");
        return 0;
    }

    public static void main(String[] args) {


        MyStack stack1 = new MyStack(6);
        stack1.push(10);
        stack1.push(7);
        stack1.push(11);
        stack1.push(56);
        stack1.push(97);
        stack1.push(38);
        stack1.push(378);
        stack1.push(77);
        stack1.push(898);
        stack1.push(23);
        stack1.push(99);
        stack1.push(43);
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());
        stack1.pop();
        System.out.println(stack1.lastElement());




       // stack1.pushMany("13 14 15 16 17 18");

    }

}
