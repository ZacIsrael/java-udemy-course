package com.zacisrael;

import java.util.ArrayList;

public class Bank {
    private String name; // Bank name;
    private ArrayList<Branch> branches; // The multiple branches in a bank

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            // if the branchName does not exist (equals null), that means that it has not been
            // used before which means that we can add it.
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null){ // We will only be able to add a customer if the branchName exists
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){ // If the branch name exists,
            // then we can add the transaction
            return branch.addCustomerTransaction(customerName,amount);

        }
        return  false;

    }
    private Branch findBranch(String branchName){
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Customers for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            // The list of customers in the branch

            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if(showTransactions){ // if the parameter showTransactions is true..
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    // create a list of the transactions the customer has made at this branch
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                        // Print out all of the transactions that the customer has made at this brnach

                    }
                }


            }
            return true;
        } else{
            return false;
        }


    }
}
