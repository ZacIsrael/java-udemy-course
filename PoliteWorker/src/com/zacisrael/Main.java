package com.zacisrael;

public class Main {

    // Live lock occurs when the threads are constantly active and waiting for other threads to complete their tasks and as a result,
    // none of the threads will actually progress
    public static void main(String[] args) {

        final Worker worker = new Worker("Worker", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker);

        new Thread(new Runnable(){
            public void run(){
                worker.work(sharedResource,worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource,worker);
            }
        }).start();

        // This application will not stop
    }
}
