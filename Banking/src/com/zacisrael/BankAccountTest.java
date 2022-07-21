package com.zacisrael;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;
    @org.junit.BeforeClass // BeforeClass methods will run before all the other method's in the class
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }


    @org.junit.Before
    public void setup(){
        account = new BankAccount("Zac", "Israel", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.Test
    public void deposit() {
        double balance  = account.deposit(200, true);
        assertEquals(1200, balance, 0); // checks to see if the balance is equal to 1200
    }

    @org.junit.Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }



    @org.junit.Test(expected = IllegalArgumentException.class)
    // this method expects and IllegalArgumentException to be returned
    public void withdraw_notBranch() {
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException");
    }


    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true(){
        assertTrue(account.isChecking());
    }

    @org.junit.AfterClass // runs after all of the other method's in the class
    public static void afterClass(){
        System.out.println("This executes after any test cases because it is annotated with \"@org.junit.AfterClass\"" +
                ". Count = " + count++);
    }

    @org.junit.After // runs after each method in the class except for the method annotated with @org.junit.AfterClass
    public void tearDown(){
        System.out.println("I execute after every individual method except for the method annotated with \"@org.junit.AfterClass\"" +
                " Count = " + count++);
    }



}