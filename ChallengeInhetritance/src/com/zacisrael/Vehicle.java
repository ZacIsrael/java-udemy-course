package com.zacisrael;

public class Vehicle {

    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction){
        this.currentDirection += direction; // allowing you to move relative to the current dircetion
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees");
    }
    public void move(int velocity, int direction){
        currentVelocity = velocity; // Setting velocity to a specific number
        currentDirection = direction; // Setting direction to a specific number
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection);

    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
    public void stop(){
        this.currentVelocity = 0;
    }
}
