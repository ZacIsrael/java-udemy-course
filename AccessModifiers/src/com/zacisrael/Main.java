package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        Account zacsAccount = new Account("Zac");

        zacsAccount.deposit(800);
        zacsAccount.withdraw(59);
        zacsAccount.deposit(72);
        zacsAccount.withdraw(300);
        zacsAccount.deposit(100000);
        zacsAccount.withdraw(25671);

        zacsAccount.calculateBalance();





    }
}
