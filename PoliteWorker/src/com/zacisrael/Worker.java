package com.zacisrael;

public class Worker {
    private String name;
     private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker){

        while (active){

            if(sharedResource.getOwner() != this){
                // If the worker does not own the sharedResource
                try{
                    // wait for 10 milliseconds
                    wait(10);
                } catch (InterruptedException e){

                }
                // look pack and try again
                continue;
            }

            // The worker own the sharedResource
            if(otherWorker.isActive()){
                // if the other thread is active, worker will give the sharedResource to the other thread.
                System.out.println(getName() + ": give the resource to the worker " + otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue; // return back to beginning of the loop
            }

            // otherThread is not active
            System.out.println(getName() + ": working on the common resource.");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
        // Only time this thread will complete a loop iteration is when it owns the sharedResource and the other thread
        // is not active.
    }
}
