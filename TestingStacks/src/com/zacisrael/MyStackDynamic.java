package com.zacisrael;

public class MyStackDynamic implements MyStackDefinition {

    // data members:
    // (1) the array to store the stack items
    // (2) the number of items currently in the stack
    // (3) the initial capacity this stack can take (but can be changed later!!)
    private int capacity;
    private int N;
    private String[] a;

    // Create an empty stack with a given capacity
    public MyStackDynamic(int capacity) {
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

    public String top(){
        if( ! isEmpty() )
            return a[N-1];
        else
            return "";
    }

    public void push(String item){
        if( ! isFull() ) {
            a[N++] = item;
        }
        else{
            System.out.println("STACK IS FULL - DOUBLING SIZE!");
            resize( a.length*2 );
            a[N++] = item;
        }
    }

    public String pop(){
        if( ! isEmpty() ){
            String temp = a[--N];
            a[N] = null;
            // If the array is 1/2 full, halve the size
            if( N > 0 && N == a.length/2) resize( a.length/2 );
            return temp;
        }
        else {
            System.out.println("STACK IS EMPTY");
            return null;
        }
    }

    // Q: should this method be public?
    private void resize(int newCapacity){
        System.out.println("Resizing stack [newCapacity = " + newCapacity +"]");
        String[] tempArray = new String[newCapacity];

        // Copying elements from original array "a" to "tempArray"
        for (int i = 0; i < N; i++) {
            tempArray[i] = a[i];
        }

        a = tempArray;
        this.capacity = newCapacity;
    }

    public static void main(String[] args) {
        int cap = 4;
        MyStackDynamic ms = new MyStackDynamic(cap);
        ms.push("he");
        ms.push("has");
        ms.push("no");
        ms.push("more");
        //System.out.println( ms.pop() );
        ms.push("backbone"); // What happens here!!?!
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());


//        while( ! ms.isEmpty() ){
//            System.out.println( ms.pop() );
//        }
    }

}

