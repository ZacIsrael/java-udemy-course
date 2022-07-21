package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2000)); */

        getDaysInMonth(1, 2020);
        getDaysInMonth(2,2020);
        getDaysInMonth(2,2018);
        getDaysInMonth(-1, 2020);
        getDaysInMonth(1, -2020);



    }
    public static boolean isLeapYear(int year){
        boolean leap = false;

        if (year < 1 || year > 9999){
            leap = false;
        }
        else if (year % 4 == 0 && year % 100 != 0 ){
            leap = true;

        }
        else if (year % 400 == 0){
            leap = true;
        }
        return leap;

    }
    public static int getDaysInMonth(int month, int year){
        int count = 0;

        if ((year < 1 || year > 9999) || (month < 1 || month > 12)){
           count = -1;
        }
        else if (month == 1){
            count = 31;
        } else if (month == 2 && year % 4 != 0){
            count =28;
        } else if (month == 3){
            count = 31;
        } else if (month == 4){
            count = 30;
        } else if (month == 5){
           count = 31;
        } else if (month == 6){
           count = 30;
        } else if (month == 7){
            count = 31;
        } else if (month == 8){
            count = 31;
        } else if (month == 9){
            count = 30;
        } else if (month == 10){
            count = 31;
        }  else if (month == 11){
            count = 30;
        }  else if (month == 12){
           count = 31;
        }

        if (year % 4 == 0 && year % 100 != 0){
            if (month == 2){
                count = 29;
            }
        }
        return count;
    }

}

   /* int switchValue = month ;
            switch (month){
                    case 1:
                    System.out.println(31);
                    break;
                    case 2:
                    System.out.println(28);
                    break;
                    case 3:
                    System.out.println(31);
                    break;
                    case 4:
                    System.out.println(30);
                    break;
                    case 5:
                    System.out.println(31);
                    break;
                    case 6:
                    System.out.println(30);
                    break;
                    case 7:
                    System.out.println(31);
                    case 8:
                    System.out.println(31);
                    case 9:
                    System.out.println(30);
                    break;
                    case 10:
                    System.out.println(31);
                    break;
                    case 11:
                    System.out.println(30);
                    break;
                    case 12:
                    System.out.println(31);
                    break;
                    }


                    return switchValue; */

