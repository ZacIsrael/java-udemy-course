package com.zacisrael;

import java.io.BufferedWriter;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button buttonPrint = new Button("Print");
    public static void main(String[] args) {

//        class Clicklistener implements Button.OnClickListener {
//            public Clicklistener(){
//                System.out.printf("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//        buttonPrint.setOnClickListener(new Clicklistener());
        buttonPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }
        });
        listen();


    }
    private static void listen(){
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    buttonPrint.onClick();
            }
        }
    }
}
