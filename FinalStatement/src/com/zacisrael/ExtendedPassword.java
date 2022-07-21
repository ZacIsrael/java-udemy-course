package com.zacisrael;

public class ExtendedPassword extends Password {

    private  int decreyptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decreyptedPassword = password;
    }

//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decreyptedPassword);
//    }
}
