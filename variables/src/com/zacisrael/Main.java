package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        int x; // declare a variable x of type int
        x = 3; //assign value 3 to variable x
        System.out.println(x);
        System.out.println(x + 2);
        int y = 5; // declaration and assignment on same line
                  // they are still two distinct operations
       int z;
       z = x + y; // = means assignment, == is part of an equation
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        x = 30;
        y = 50;


        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        x = x + 1;
        System.out.println(x);

        x = (int) 5.2;

        System.out.println(x);

        // Once a variable is declared within a method, it stays that type within that method


    }
}
