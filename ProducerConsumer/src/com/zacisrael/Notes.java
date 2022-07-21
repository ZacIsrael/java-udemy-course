package com.zacisrael;

public class Notes {

    /*


     // A lock is a tool for controlling access to a shared resource by multiple threads.
    // Commonly, a lock provides exclusive access to a shared resource: only one thread at a time can acquire
    // the lock and all access to the shared resource requires that the lock be acquired first.
    // However, some locks may allow concurrent access to a shared resource, such as the read lock of a ReadWriteLock.


    // A thread pool is a managed set of threads, reduces the overhead of thread creation,
    // may also limit the number of threads that are active running a block at one particular time
    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();
        // If the thread is already holding a ReentrantLock when it reaches the code that requires the same lock,
        // it can continue executing.
        // All the threads have to be competing for the same lock to prevent thread interference.

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

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


        try{
            System.out.println(future.get());
        } catch (ExecutionException e){
            System.out.println("Something went wrong.");
        } catch (InterruptedException e){
            System.out.println("Thread running the task was interrupted.");
        }
        executorService.shutdown();
        // when using executorService, we must shut down the code manually
    }
}

class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                // lock() & unlock() are similar to synchronized block, we're surrounding the code that
                // we ultimately want to be thread safe to avoid thread interference

                try {
                    buffer.add(num);
                    // adds the num string to the buffer
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
                // Thread falls asleep for 1 second
            } catch (InterruptedException e) {
                // Print this message if thread is interrupted
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println("Adding EOF and exiting...");

        bufferLock.lock();
        try {
            buffer.add("EOF");
            // add "EOF" to the buffer to signify that we are at the end of the buffer
        } finally {
            bufferLock.unlock();
        }

    }


}

class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {

        int counter = 0;

        while (true) {
            if(bufferLock.tryLock()) {
                // If a lock is available, execute the following code
                try {
                    if (buffer.isEmpty()) {
                        continue;
                        // if there's nothing to read, look back around and check again until the buffer is not empty
                    }
                    System.out.println(color + "The counter = " + counter);
                    if (buffer.get(0).equals("EOF")) { // end of file
                        System.out.println(color + "Exiting");
                        // If the first index in the buffer string is "EOF", that means that we have reached the
                        // end of the list so we will break out of the loop
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                        // removes the first string in the buffer List
                    }
                } finally {
                    // we will always execute the code in the finally block NO MATTER WHAT
                    bufferLock.unlock();
                }
            } else{
                counter++;
            }

        }

    }
}
     */
}
