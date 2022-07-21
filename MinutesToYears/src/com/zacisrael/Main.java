package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printYearsAndDays(525600);

        printYearsAndDays(1051200);

        printYearsAndDays(561600);
        printYearsAndDays(-56776888);
        printYearsAndDays(1440);
        printYearsAndDays(1788890);
        printYearsAndDays(444879);
        printYearsAndDays(0);

    }
    public static void printYearsAndDays(long minutes){

        int days = (int) minutes / 1440;
        int years = (int) minutes / 525600;

        int ZZ = (int) minutes - 525600 ;

        int XX = ZZ/ 1440;

        int totalDays = (int) ((minutes - (525600 * years))/ 1440) ;



        if (minutes < 0){
            System.out.println("Invalid Value");
        } else if (minutes == 0){
            System.out.println(minutes + " min = " + 0 + " y and " + 0 + " d");
        }
        else if (ZZ % 525600 == 0){
            System.out.println(minutes + " min = " + years + " y and " + 0 + " d");
        } else if(years < 1){
            System.out.println(minutes + " min = " + 0 + " y and " + days + " d");
        }
        else if(years >= 1){
            System.out.println(minutes + " min = " + years + " y and " + totalDays + " d");
        }
        else {

            System.out.println(minutes + " min = " + years + " y and " + XX + " d");
        }

    }
}
