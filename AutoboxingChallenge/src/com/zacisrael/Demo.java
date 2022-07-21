package com.zacisrael;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "DC");
        addInOrder(placesToVisit, "Haiti");
        addInOrder(placesToVisit, "Jamaica");
        addInOrder(placesToVisit, "Ireland");
        addInOrder(placesToVisit, "Russia");
        addInOrder(placesToVisit, "Ghana");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Senegal"); // Adds Senegal to the list and places it so it is in Alphabetical order
        printList(placesToVisit);

        visit(placesToVisit);

//        placesToVisit.add("Sydney");
//        placesToVisit.add("DC");
//        placesToVisit.add("Haiti");
//        placesToVisit.add("Jamaica");
//
//        printList(placesToVisit);


//        placesToVisit.add(1, "Colorado"); // Adds the new country at the index in the list
//        printList(placesToVisit);
//
//        placesToVisit.remove(4); // Removes whatever place is in that index
//        printList(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){
            System.out.println("Now visiting " + i.next());
            // i.next is the same as doing i++;
        }
        System.out.println("=================");

    }

    private static boolean addInOrder(LinkedList<String> linkedList,String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()){ // navigates through all the entries that are in this stringListeIterator
            int comparison = stringListIterator.next().compareTo(newCity);
                if(comparison == 0){
                    // equal, do not add
                    System.out.println(newCity + " is already included as a destination");
                    return false;
                } else if(comparison > 0){
                    // new City should appear before this one
                    //Sydney -> DC
                    stringListIterator.previous(); // we have to go back because has.next() was already executed
                    stringListIterator.add(newCity);
                    return true;

                } else if(comparison < 0){
                    // move on to the next city
                }

        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){ // checks to see if "cities" is an empty string

        } else{
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    } else{
                        System.out.println("Reached the end of the list");
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    } else{
                        System.out.println("We are at the start of the list ");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit");
        System.out.println("1 - go to next city");
        System.out.println("2 - go to previous city");
        System.out.println("3 - print menu options");
    }

}
