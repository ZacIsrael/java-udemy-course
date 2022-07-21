package com.zacisrael;

import com.zacisrael.Car;

public class Honda extends Car {

    private int roadServiceMonths;

    public Honda(int roadServiceMonths) {
        super("com.zacisrael.Honda", "4WD", 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate(int rate){

        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity == 0){
            stop();
            changeGear(1);
        } else if(newVelocity> 0 && newVelocity <= 10){
            changeGear(1);
        } else if(newVelocity > 0 && newVelocity <= 20){
            changeGear(2);
        } else if(newVelocity > 0 && newVelocity <= 30 ){
            changeGear(3);
        } else{
            changeGear(4);
        }

        if(newVelocity > 0){
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
