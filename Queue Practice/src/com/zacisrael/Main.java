package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue queue = new Queue();
        queue.enQueue(5);
        queue.enQueue(21);
        queue.enQueue(2);
        queue.enQueue(8);
        System.out.println(queue.getSize());
        queue.show();
        queue.deQueue();
        System.out.println(queue.getSize());
        queue.show();
        queue.deQueue();
        System.out.println(queue.getSize());
        queue.show();
        queue.deQueue();
        System.out.println(queue.getSize());
        queue.show();
//        System.out.println("\n");
//        System.out.println(queue.deQueue() + " was removed from the queue");
//        System.out.println(queue.deQueue() + " was removed from the queue");
//        System.out.println(queue.deQueue() + " was removed from the queue");
//        queue.show();

    }
}
