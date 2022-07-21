package com.zacisrael;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
	// write your code here

        final BankAccount account = new BankAccount("12345-678", 1000.00);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                account.deposit(300);
                account.withdraw(50);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
            }
        });

//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                account.deposit(300);
//                account.withdraw(50);
//            }
//        };
//
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                account.deposit(203.75);
//                account.withdraw(100);
//            }
//        };

        thread.start();
        thread2.start();
    }
}
