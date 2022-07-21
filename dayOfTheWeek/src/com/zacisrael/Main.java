package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printDayOfTheWeek(0);
        printDayOfTheWeek(3);
        printDayOfTheWeek(50);


    }

    public static void printDayOfTheWeek(int day){



        switch(day){
            case 0:
                System.out.println("Today is Sunday");
                break;
            case 1:
                System.out.println("Today is Monday");
                break;
            case 2:
                System.out.println("Today is Tuesday");
                break;
            case 3:
                System.out.println("Today is Wednesday");
                break;
            case 4:
                System.out.println("Today is Thursday");
                break;
            case 5:
                System.out.println("Today is Friday");
            case 6:
                System.out.println("Today is Saturday");
                break;
            default:
                System.out.println("Invalid day");
                break;

        }
    }
}
