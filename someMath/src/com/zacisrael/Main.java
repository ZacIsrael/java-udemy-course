package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(sumOfSquares(4));
        System.out.println(product(3, 10));
        System.out.println(compoundInterest(1000,0.05,3));
        System.out.println(polySpiral(8, 5,3));
    }

    public static int sumOfSquares(int n) {

        int sumSquares = 0; // has to be set to 0
        for (int i = 1; i <= n; i++) { // run this for loop n times
            sumSquares += Math.pow(i, 2); // raises the number i to the second power
                                          // "+=" adds the current value of i squared to the previous values of i squared
        }
        return sumSquares; // return the value of sumSquares after the for loop has run "n" times
    }

    public static int product(int x, int y){

        int product = 0; // has to be set to 0
        for(int i = 0; i < y; i++){ // run this loop y times so x is added to itself y times
            product += x; // Add x to the previous x
        }
        return product; // return the value of product after the loop has run "y" times
    }
    public static double compoundInterest(double money, double interestRate, int years){

        for (int i = 1; i < years + 1; i++){ // I started the loop at 1 so I have to run the loop "years" times + 1
            money = money + (money * interestRate); // money equal the previous value of money + interestRate % of the current value of money
        }
        return money; // return the value of money after the loop has run "years" times

    }
    public static double polySpiral(int n, double base, int rounds){
        double sum = 0; // has to be set to 0

        for (int i = 0; i < rounds * n; i++){ // run this loop rounds * n times, just like in previous method with turtle
            sum = sum + (base * i) ; // "base * (i + 1)" is how far I moved the turtle forward in polyspiral assignment
                                     // base * i is just "base * (i + 1)" simplified when i is set at 0 in the for loop
                                           // sum = previous value of sum + how far the turtle moved in the polyspiral assignment
        }
        return sum; // return the value of sum after the loop has run "rounds * n" times

    }

}
