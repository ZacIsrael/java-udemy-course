package com.zacisrael;

public class Main {

    //Synchronized method is used to lock an object for any shared resource.
    // When a thread invokes a synchronized method, it automatically acquires
    // the lock for that object and releases it when the thread completes its task.

    // Starvation: a situation where a thread is unable to gain regular access to shared resources and is
    // unable to make progress. This happens when shared resources are made unavailable for long periods
    // by "greedy" threads.

    public static void main(String[] args) {

        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson john = new PolitePerson("John");

        // Insures that the lines of code in two separate threads

        new Thread((Runnable) ()-> {jane.sayHello(john);}).start();
        new Thread((Runnable) ()-> {john.sayHello(jane);}).start();


        /* Sequence of executions that lead to the deadlock:

        -Thread1 acquires the lock on the jane object and enters the sayHello() method. it prints to the console, then suspends
        -Thread2 acquires the lock on the john object and enters the sayHello() method. It prints to the console, then suspends
        -Thread1 runs again and wants to say hello back to the john object. It tries to call the sayHelloBack() method using
        the john object that was passed into the sayHello() method, but Thread2 is holding the john lock, so Thread1 suspends
        -Thread2 runs again and wants to say hello back to the jan object. It tries to call the sayHelloBack() method using
        the jane object that was passed into the sayHello() method, but Thread1 is holding the john lock, so Thread2 suspends.

         */



    }

    static class PolitePerson{
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public synchronized void sayHello(PolitePerson person){
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            // the first %s will print the this object's name and the second will print the
            // person's name
            // i.e: this.name: person.getName() has said hello to me!

            person.sayHelloBack(this);
            // this object says hello back to the person

        }
        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
