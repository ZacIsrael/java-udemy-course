package com.zacisrael;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    // A lock is a tool for controlling access to a shared resource by multiple threads.
    // Commonly, a lock provides exclusive access to a shared resource: only one thread at a time can acquire
    // the lock and all access to the shared resource requires that the lock be acquired first.
    // However, some locks may allow concurrent access to a shared resource, such as the read lock of a ReadWriteLock.


    // A thread pool is a managed set of threads, reduces the overhead of thread creation,
    // may also limit the number of threads that are active running a block at one particular time
    public static final String EOF = "EOF";

    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6); // stores 6 elements
        // ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array.
        // That it is bounded means that it cannot store unlimited amounts of elements.
        // There is an upper bound on the number of elements it can store at the same time

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the Callable class.");
                return "This is the callable result.";
            }
        });


        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong.");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted.");
        }
        executorService.shutdown();
        // when using executorService, we must shut down the code manually
    }
}

class MyProducer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;


    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;

    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
                // Thread falls asleep for 1 second
            } catch (InterruptedException e) {
                // Print this message if thread is interrupted
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println("Adding EOF and exiting...");


        try {
            buffer.put("EOF");
            // add "EOF" to the buffer to signify that we are at the end of the buffer
        } catch (InterruptedException e) {

        }

    }


}

class MyConsumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;


    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {


        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                        // if there's nothing to read, look back around and check again until the buffer is not empty
                    }

                    if (buffer.peek().equals("EOF")) { // end of file
                        System.out.println(color + "Exiting");
                        // If the first index in the buffer ArrayBlockingQueue is "EOF", that means that we have reached the
                        // end of the ArrayBlockingQueue so we will break out of the loop
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                        // removes the first string in theArrayBlockingQueue
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
