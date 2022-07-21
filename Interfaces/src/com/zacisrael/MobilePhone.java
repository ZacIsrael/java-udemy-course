package com.zacisrael;

public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile phone powered up");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn) {
            System.out.println("Now ringing " + phoneNumber + " on mobile phone.");
        } else{
            System.out.println("Phone is switched off");
        }

    }

    @Override
    public void answer() {
        if(isRinging){
            // If the isRinging is true, print out the following message and set isRinging to false.
            System.out.println("Answering the mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber && isOn){
            isRinging = true;
            System.out.println("Ring ring");
        }else {
            isRinging = false;
            System.out.println("Mobile phone not on or number is different");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return false;
    }

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }
}
