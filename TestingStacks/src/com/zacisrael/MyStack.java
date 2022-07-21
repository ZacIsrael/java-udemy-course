package com.zacisrael;

public class MyStack implements MyStackDefinition {

    // data members:
    // (1) the array to store the stack items
    // (2) the number of items currently in the stack
    // (3) the maximum capacity this stack can take
    private int capacity;
    private int N;
    private String[] a;

    // Create an empty stack with a given capacity
    public MyStack(int capacity) {
        this.capacity = capacity;
        N = 0;
        a = new String[this.capacity];
    }
    public boolean isEmpty(){
        return (N == 0);
    }
    public boolean isFull(){
        return (N == this.capacity);
        //return (N == a.length);
    }
    public void push(String item){
        if( isFull() ){
            System.out.println("STACK IS FULL YOU IDIOT!!!!"); // (Sorry for my lack of good manners..)
        }else{
            a[N++] = item;
        }
    }
    public String pop(){
        String temp = "";
        if( !isEmpty() ){
            temp = a[--N];
            a[N] = null;
        }else{
            System.out.println("STACK IS EMPTY YOU IDIOT!!!!"); // (Sorry for my lack of good manners..)
        }
        return temp;
    }
    public String top(){
        return a[N-1];
    }

    public static void main(String[] args) {
        int cap = 4;
        MyStack ms = new MyStack(cap);
        ms.push("he");
        ms.push("has");
        ms.push("no");
        ms.push("more");
        //System.out.println( ms.pop() );
        ms.push("backbone"); // What happens here!!?!
    }

}
