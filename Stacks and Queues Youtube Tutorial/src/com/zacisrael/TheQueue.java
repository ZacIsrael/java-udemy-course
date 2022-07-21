package com.zacisrael;

import java.util.Arrays;

public class TheQueue {

    private String[] queueArray;
    private  int queueSize;
    private int front, rear, numberOfItems = 0;

    TheQueue(int size){

        queueSize = size;

        queueArray = new String[size];
        Arrays.fill(queueArray, "-1");
    }

    public void insert(String input){
        if(numberOfItems + 1 <= queueSize){
            queueArray[rear] = input;
            rear++;
            numberOfItems++;

            System.out.println(input + "  was added to the queue");

        } else System.out.println("Soory but the queue is full");
    }

    public void remove(){
        if(numberOfItems > 0){

            System.out.println("Remove " + queueArray[front] + " was removed from the queue");
            queueArray[front] = "-1";
            front++;
            numberOfItems--;

        } else {
            System.out.println("Sorry but the queue is empty");
        }
    }

    public void peek(){

        System.out.println("The first element is " + queueArray[front]);
    }

//    public void priorityInsert(String input){
//        // a priority queue adds items in order from high to low as they are inputted
//        int i;
//        if(numberOfItems == 0){
//            insert(input);
//        } else{
//            for (int j = numberOfItems - 1; j >= 0; j--) {
//                if(Integer.parseInt(input) > Integer.parseInt(queueArray[j])){
//                    queueArray[j + 1] = queueArray[j];
//                } else break;
//            }
//            queueArray[i + 1] = input;
//            rear++;
//            numberOfItems++;
//        }
//    }


    public static void main(String[] args) {

        TheQueue theQueue = new TheQueue(10);
//        theQueue.priorityInsert("10");
//        theQueue.priorityInsert("7");
//        theQueue.priorityInsert("13");
//        theQueue.priorityInsert("9");
//        theQueue.priorityInsert("15");

        theQueue.insert("5");
        theQueue.insert("11");
        theQueue.insert("8");
        theQueue.insert("15");
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
    }
}
