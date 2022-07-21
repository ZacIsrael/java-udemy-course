package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /* manyHellos(10);
        manyHellos(3);
        manyHellos(5);
        manyHellos(0);
        System.out.println( sumN(3));
        System.out.println(sumN(5));
        System.out.println(sumN(7));
        System.out.println(sumN_v2(3));
        System.out.println(sumN_v2(5));
        System.out.println(sumN_v2(7)); */
        System.out.println(yearsToTarget(1000, .05, 2000));
        System.out.println(yearsToTarget(15, 0.30, 29));

        System.out.println(breakEvenQuantity(1, 0.5, 1000));
        System.out.println(breakEvenQuantity(1, 0.7, 1000));




    }
    public static void manyHellos(int n){
        int i = n; // initialization
        while (i > 0){ // while i is greater than 0
            System.out.println("Hello " + i); //print out 10 and the current # for i
            i--; // this means i = current i - 1
            // Keep going down until the # is zero & print out "Goodbye"
        }
        System.out.println("Goodbye"); // if i is equal to or less than 0, print out "Goodbye"
    }
    public static int sumN(int n){
        int result = 0; // initialize result
        int i = 1;
        while (i <= n){ // while i is equal to or less than n
            result = result + i; // the result will equal the previous result + the next value of i
            i++;
        }
        return result; // return result
    }
    public static int sumN_v2(int n){
        int result = 0; // initialize result
        int i = n; // set i equal to n because
        while (i >= 0){ // while i is equal to or greater than 0
            result = result + i; // the result will equal the previous result + the next value of i
            i--;
        }
        return result; // return result
    }
    public static int yearsToTarget(double initMoney, double interestRate, double targetMoney){
        // Find how many years it will take for the initial money to reach the final amount of money , given the interest rate


        int year = 0;
        double money = initMoney;

        System.out.println("Year\tMoney");
        System.out.println(year + "\t" + (int)(money*100)/100.0); // Prints initial year data

        while (money < targetMoney) {
            year ++;
            money *= 1 + interestRate; // equal to money = money * (1 + interestRate)
            System.out.println(year + "\t" + (int)(money * 100)/100.0); // Prints data up to the year tested
        }
        return year;

    }
    public static int breakEvenQuantity(double p, double c, double k){
        // If you buy the candy, it will cost p money per unit of product. If you make it, the candy costs c per candy plus
        // a fixed initial amount k to purchase and set up a machine that makes candy. Find the break even point , the minimum
        // quantity for which making the product is the same or cheaper than buying it

        int quantity = 0; // initialize boolean
        double costBuy = 0;
        double costMake = k;

        while(costBuy < costMake){
            quantity++;
            costBuy += p;
            costMake += c;
        }
        return quantity;

    }



}
