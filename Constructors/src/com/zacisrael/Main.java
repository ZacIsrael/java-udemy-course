package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        // write your code here

//        BankAccount bobsBankAccount = new BankAccount();//"12345", 0.00, "Bob Brown",
//               // "bob.brown@gmail.com", "(007) 123-456");
//
//        System.out.println(bobsBankAccount.getNumber());
//        System.out.println(bobsBankAccount.getBalance());
//
//
//        bobsBankAccount.withdrawal(100.0);
//
//        bobsBankAccount.deposit(50.0);
//        bobsBankAccount.withdrawal(100.0);
//
//        bobsBankAccount.deposit(51.0);
//        bobsBankAccount.withdrawal(100.0);
//
        BankAccount zacAccount = new BankAccount("Zac", "zac390@gmail.com", "12345");
        System.out.println(zacAccount.getNumber() + " name " + zacAccount.getCustomerName());
        System.out.println("Current balance is " + zacAccount.getBalance());
        zacAccount.withdrawal(100.55);


//     com.zacisrael.VipCustomer person1 = new com.zacisrael.VipCustomer();
//        System.out.println(person1.getName());
//
//      com.zacisrael.VipCustomer person2 = new com.zacisrael.VipCustomer("Zac", 25000.00);
//        System.out.println(person2.getName());
//
//        com.zacisrael.VipCustomer person3 = new com.zacisrael.VipCustomer("London", 100.00, "london@gmail.com");
//        System.out.println(person3.getName());
//        System.out.println(person3.getEmailAddress());
    }


}
