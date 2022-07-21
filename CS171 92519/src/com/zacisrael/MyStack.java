package com.zacisrael;

public class MyStack {

    private String[] array;
    private int size = 0;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.array = new String[size];
        String a[] = new String[capacity];
    }

    public String[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull(){
        return array.length == capacity;
    }
    public boolean isEmpty(){
      return array.length == 0;
    }
    public void push(String item){
        array[size] = item;


    }
    public String pop(){
        array[size -1] = null;
        size--;
        return array[size-1];
    }
    public String peek(){
        return array[size-1];
    }
}
