package com.zacisrael;

public class Password {

    private static final int key = 26538490;
    private final int encryptedPassword;

    public Password(int encryptedPassword) {
        this.encryptedPassword = encryptDecrypt(encryptedPassword);
    }

    private int encryptDecrypt(int password){
        return password ^ key;
    }

    public final void storePassword(){
        // You cannot override a final method
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password){
        if(encryptDecrypt(password) == this.encryptedPassword){
            System.out.println("Welcome in");
            return true;

        }
        else{
            System.out.println("The password you entered is incorrect");
            return false;
        }
    }
}
