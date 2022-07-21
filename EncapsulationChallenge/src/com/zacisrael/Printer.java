package com.zacisrael;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if(tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else{
            this.tonerLevel = -1;
        }
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int fillToner(int fill){
        if(fill > 0 &&  fill <= 100) {
           if (this.tonerLevel + fill > 100){
               return -1;
           }
               this.tonerLevel += fill;
               return this.tonerLevel;

        }
        else {
            return -1;
        }

    }
    public int printPage(int pages){
       int pagesToPrint = pages;
       if(this.duplex){
           pagesToPrint = (pages/2) + (pages % 2);
           System.out.println("Printing in duplex mode");
       }
       this.pagesPrinted += pagesToPrint;
       return pagesToPrint;
    }

    public int getNumberOfPagesPrinted() {
        return pagesPrinted;
    }
}
