package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Bank bank = new Bank("SunTrust");
        // Initializes a bank
        bank.addBranch("Washington D.C");
        // adds a branch of the bank
        bank.addCustomer("Washington D.C", "Zac", 50.05);
        // adds a customer to that specific branch and the customer's initial amount
        bank.addCustomer("Washington D.C", "Jasmine", 175.34);
        bank.addCustomer("Washington D.C", "Lailah", 220.12);

        bank.addBranch("Oakland");
        bank.addCustomer("Oakland", "Omar", 150.54);

        bank.addCustomerTransaction("Washington D.C", "Zac", 44.22);
        bank.addCustomerTransaction("Washington D.C", "Zac", 12.44);
        bank.addCustomerTransaction("Washington D.C", "Lailah", 1.65);

        bank.listCustomers("Washington D.C", true);
        bank.listCustomers("Oakland", true);

        bank.addBranch("Delaware");

        if(!bank.addCustomer("Delaware", "Brian", 5.53)){
            System.out.println("Error Delaware branch does not exist");
        }
        if(!bank.addBranch("Washington D.C")){
            System.out.println("Washington D.C branch already exists");
        }





    }


}
