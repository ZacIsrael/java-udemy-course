package com.zacisrael;

public class DeskPhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;

    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phone does not have a power button.");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + " on deskphone.");

    }

    @Override
    public void answer() {
        if(isRinging){
            // If the isRinging is true, print out the following message and set isRinging to false.
            System.out.println("Answering the desk phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber){
            isRinging = true;
            System.out.println("Ring ring");
        }else {
            return false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return false;
    }

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }
}
