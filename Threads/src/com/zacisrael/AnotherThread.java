package com.zacisrael;

import static com.zacisrael.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());
        // getName() method returns name of current thread being executed
        try{
            Thread.sleep(3000); // tells thread to sleep for 3 seconds = 3000 milliseconds
        } catch (InterruptedException e){
            // This statement will print if the thread is interrupted for whatever reason
            System.out.println(ANSI_BLUE + "Another thread woke me up.");
            return; // terminates the instance
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I am awake.");
        // this message will print after the three seconds have passed
    }
}
