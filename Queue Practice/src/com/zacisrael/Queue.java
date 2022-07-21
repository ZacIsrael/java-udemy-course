package com.zacisrael;

public class Queue {

    int queue[] = new int[5];
    int size;
    int front;
    int rear;

    public void enQueue(int data){
        if(!isFull()) {
            queue[rear] = data;
            rear = (rear + 1) % 5;
            size++;
        } else System.out.println("Queue is full");

    }
    public int deQueue(){
        int data = queue[front];
        if(!isEmpty()){
            front = (front + 1) % 5;
            size = size -1;
            return data;

        } else System.out.println("Que is empty");
        return data;


    }
    public void show(){
        System.out.print("Elements : ");
        for (int n: queue) {
            System.out.print(n + " ");
        }
        System.out.println("\n");
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == 5;
    }
}
