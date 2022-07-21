package com.zacisrael;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return "The engine is starting.";
    }

    public String accelerate() {
        return "The engine is accelerating";
    }

    public String brake() {
        return "The driver has hit the brake and the engine is stopping.";
    }
}

class Tesla extends Car {
    public Tesla(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "The tesla is starting";
    }

    @Override
    public String accelerate() {
        return "The tesla is accelerating";
    }

    @Override
    public String brake() {
        return "The tesla is stopping";
    }
}

class Mitsubishi extends  Car {

    public Mitsubishi(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "The Mitsubishi is starting";
    }

    @Override
    public String accelerate() {
        return "The Mitsubishi is accelerating";
    }

    @Override
    public String brake() {
        return "The Mitsubishi is stopping";
    }
}


class BMW extends Car{
    public BMW(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "The BMW is starting" ;
    }

    @Override
    public String accelerate() {
        return "The BMW is accelerating";
    }

    @Override
    public String brake() {
        return "The BMW is stopping";
    }
}


public class Main {

    public static void main(String[] args) {
        // write your code here
        Car car = new Car("Base Car", 8);
        System.out.println(car.startEngine());
        BMW model750 = new BMW("750", 8);
        System.out.println(model750.accelerate());
        Holden holden = new Holden("Commodre",8);
        System.out.println(holden.brake());


    }

    static class Holden extends Car {
        public Holden(String name, int cylinders) {
            super(name, cylinders);
        }

        @Override
        public String startEngine() {
            return "The Holden is starting";
        }

        @Override
        public String accelerate() {
            return "The Holden is accelerating";
        }

        @Override
        public String brake() {
            return "The Holden is stopping";
        }
    }
}
