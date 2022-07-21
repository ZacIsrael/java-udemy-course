package com.zacisrael;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    // Fair locks guarantee first come first serve ordering for getting a lock
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Fair lock will allow threads to interleave much more than they when we were using an object

        // Live lock occurs when the threads are constantly active and waiting for other threads to complete their tasks and as a result,
        // none of the threads will actually progress


    }

    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        public void run(){
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try{
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // current thread's name: runCount = whatever the runCount is at the time
                } finally {
                    lock.unlock();
                    // no matter what happens , we want to unlock the lock
                }

            }
        }
    }
}
