package com.zacisrael;

public class SharedResource {

    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        // making this method synchronized because we don't want any thread interference when we are
        // setting which thread is currently using the resource.
        this.owner = owner;
    }
}
