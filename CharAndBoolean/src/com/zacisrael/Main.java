package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        char myChar = 'Z'; // Char can store ONE character or number
        // width of a char is 16 (2 bytes)
        // unicode-table.com

        char crazyChar = '\u00A9'; // symbol from the unicode website

        System.out.println(crazyChar);



        boolean myBoolean = false; // Boolean can only be true or false
        boolean isMale = true;

        // Challenge :
        // 1. Find the code for the registered symbol on the same line as the copyright symbol
        // 2. Create a variable of type char and assign it the unicode value for that symbol
        // 3. Display in on screen

        char rSymbol = '\u00AE';

        System.out.println(rSymbol);

    }
}
