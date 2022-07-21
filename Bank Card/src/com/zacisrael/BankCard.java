package com.zacisrael;

public class BankCard {

    private String color;
    private String type;
    private String number;
    private int cvv;

    public BankCard(String color, String type, String number, int cvv) {
        this.color = color;
        this.type = type;
        this.number = number;
        this.cvv = cvv;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public int getCvv() {
        return cvv;
    }

    public boolean validNumber(){
        if(number.length() == 16){
            return true;
        }

        return false;
    }

    public boolean validCvv(){
        if((cvv <= 999) && (cvv >= 100)){
            return true;
        }
        return false;
    }


}
