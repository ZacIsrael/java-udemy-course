package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        CountDown countDown = new CountDown();
        //CountDown countDown2 = new CountDown();
        // no interference now

        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread 1");
        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
        // can't predict when each thread is run

        // When a method is synchronized, only one thread can execute that method at a time
        // Threads cannot interleave when running a synchronized method

    }

    // When a class or a method is thread safe, the developer has synchronized all the critical sections within the code
    // so that we don't have to worry about the thread interference\

    // None of the UI components are thread safe

    // interleaving is a way to run multiple programs in a single thread, or on a
    // single cpu core, thus the only way to do concurrency in single core systems.
    // By hand it means that you have to write programs that do cooperative
    // multitasking such that all parts of the program get a chance to execute, taking turns.
}

class CountDown {
    private int i;
    // threads interference, other thread will change the value of i, so neither of the threads will be able to countdown
    // from 10 to 1, one thread will get certain numbers and the other thread will get the rest
    public void doCountDown(){
        String color;

        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;

        }

        synchronized (this){
            for (i = 10; i > 0 ; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i= " + i);
                // a thread can between suspended between steps
            }
        }


    }
}

class CountDownThread extends Thread{
    private CountDown threadCountdown;
    public CountDownThread(CountDown countDown){
        threadCountdown = countDown;
    }

    public void run(){
        threadCountdown.doCountDown();
    }
}
