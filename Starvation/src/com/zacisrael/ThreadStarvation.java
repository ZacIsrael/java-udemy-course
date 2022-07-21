package com.zacisrael;

public class ThreadStarvation {
    // Starvation: a situation where a thread is unable to gain regular access to shared resources and is
    // unable to make progress. This happens when shared resources are made unavailable for long periods
    // by "greedy" threads.

//    private static Object lock = new Object();
//
//    public static void main(String[] args) {
//
//        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
//        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
//        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
//        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
//        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");
//
////        t1.setPriority(10);
////        t2.setPriority(8);
////        t3.setPriority(6);
////        t4.setPriority(4);
////        t5.setPriority(2);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//
//        // Thread with the highest priority will run and finish before the other threads have a chance to run
//        // no matter the order in which the thread's start methods are called.
//
//        // The threads with lower priorities are being starved of resources. Setting a priority to each thread
//        // increases the chances of starvation.
//
//        // If you do not set a priority to each thread, each thread will run simultaneously and in this case,
//        // each thread will print numbers 1-100 but they will overlap each other.
//
//
//    }
//
//    private static class Worker implements Runnable {
//        private int runCount = 1;
//        private String threadColor;
//
//        public Worker(String threadColor) {
//            this.threadColor = threadColor;
//        }
//
//        public void run(){
//            for (int i = 0; i < 100; i++) {
//                synchronized (lock){
//                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
//                    // current thread's name: runCount = whatever the runCount is at the time
//                }
//            }
//        }
//    }
//

}
