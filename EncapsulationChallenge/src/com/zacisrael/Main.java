package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(75, false);
        System.out.println("Intial page count = " + printer.getNumberOfPagesPrinted());
        int pagesPrinted = printer.printPage(4);
        System.out.println("Pages printed was " + pagesPrinted + ". New total print count for printer = " + printer.getNumberOfPagesPrinted());

        pagesPrinted = printer.printPage(2);
        System.out.println("Pages printed was " + pagesPrinted + ". New total print count for printer = " + printer.getNumberOfPagesPrinted());




    }
}
