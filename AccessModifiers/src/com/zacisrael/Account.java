package com.zacisrael;

import java.util.ArrayList;

public class Account {

    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        if(amount > 0){
            transactions.add(amount);
            this.balance += amount;
            System.out.println("Balance is now " + this.balance);

        } else{
            System.out.println("Cannot deposit negative values");
        }

    }
    public void withdraw(int amount){
        if(amount > 0){
            transactions.add(-amount);
            this.balance -= amount;
            System.out.println("Balance is now " + this.balance);
        } else{
            System.out.println("You cannot withdraw a negative amount. Just make a deposit.");
        }
    }

    public void calculateBalance(){
        this.balance = 0;
        for (int i: this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
}
