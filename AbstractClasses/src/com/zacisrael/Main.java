package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        // The purpose of an abstract class is to provide a common definition of
        // a base class that multiple derived classes can share

        // All methods in interfaces are automatically public & abstract

        // You use an interface when you want to specify the behavior of a particular data type,
        // but you are not concerned about who implements its behavior.




        // Interfaces tell you what to do, classes tell you how to do it.
        // Difference between AbstractClasses and Interfaces:
        // The difference is methods of a Java interface are
        // implicitly abstract and cannot have implementations.
        // A Java abstract class can have instance methods that implements a default behavior.
        // Variables declared in a Java interface is by default final.
        // An abstract class may contain non-final variables.

        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot bird = new Parrot("Australian ringneck");
        bird.breathe();
        bird.eat();
        bird.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();



    }
}
