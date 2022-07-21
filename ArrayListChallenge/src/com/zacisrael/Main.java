package com.zacisrael;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("750 345 6289");

    public static void main(String[] args) {
        // write your code here
        boolean quit = false;
        startPhone();

        printInstructions();
        while(!quit) {
            System.out.println("Enter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addCon();
                    break;
                case 3:
                    updateCon();
                    break;
                case 4:
                    removeCon();
                    break;
                case 5:
                    queeryContact();
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }


    }
    private static void startPhone(){
        System.out.println("Starting phone....");
    }
    private static  void printContacts(){
       mobilePhone.printContact();
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice option");
        System.out.println("\t 1 - To print the list of mobilePhone.");
        System.out.println("\t 2 - To add a contact to the list of mobilePhone.");
        System.out.println("\t 3 - To modify a contact in the contact list.");
        System.out.println("\t 4 - To remove a contact from the contact list");
        System.out.println("\t 5 - To search for a contact in the contact list.");
        System.out.println("\t 6 - To quit the application");
    }

    public static void addCon() {
        System.out.print("Please enter the contact : ");
        String name = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added : name = " + name + ", phone number = " + phone);
        } else{
            System.out.println( "Cannot add, " + name + " already on file");
        }
    }

    public static void updateCon() {
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        scanner.nextLine();
       Contacts existingContactRecord = mobilePhone.queeryContact(contactName);
       if(existingContactRecord == null){
           System.out.println("Contact not found");
           return;
       }

        System.out.println("Enter new contact name: ");
       String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record ");
        } else{
            System.out.println("Error updating record.");
        }
    }

    public static void removeCon() {
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queeryContact(contactName);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

       if( mobilePhone.removeContact(existingContactRecord)){
           System.out.println("Successfully deleted");
       } else{
           System.out.println( "Error deleting contact");
       }
    }
    public static void queeryContact(){
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queeryContact(contactName);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());

        if( mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        } else{
            System.out.println( "Error deleting contact");
        }
    }
}
