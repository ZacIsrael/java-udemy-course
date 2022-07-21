package com.zacisrael;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;

    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Zac", "Israel", 1000, BankAccount.CHECKING);
        System.out.println("Running test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        // Test parameters that will be used
        return Arrays.asList(new Object[][]{
                {100, true, 1100},
                {200, true, 1200},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000, true, 2000}
        });
    }

    @org.junit.Test
    public void deposit() {
        // uses all the test cases from the testConditions method 
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
