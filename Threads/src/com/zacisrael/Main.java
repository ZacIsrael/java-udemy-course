package com.zacisrael;

import static com.zacisrael.ThreadColor.ANSI_PURPLE;
import static com.zacisrael.ThreadColor.ANSI_GREEN;
import static com.zacisrael.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");
        // This line will always be first but you cannot guarantee the order
        // of the print statements in the other threads

        Thread anotherThread = new AnotherThread();// create an instance of a thread
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();// start the other thread

        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from the anonymous thread. ");
            }
        }.start(); // this thread runs in the background


        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class' implementation of run");
                try{
                    anotherThread.join(); // joining this thread to another thread
                    System.out.println(ANSI_RED+"AnotherThread terminated, or timed out, so I'm running again.");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all, I was interrupted.  ");
                }
            }
        });

        myRunnableThread.start();
      //  anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");

        //anotherThread.start(); // will not work because you're not aloud to start the same instance of a thread more than once
    }
}
