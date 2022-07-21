package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(decimalToBinary(23));
        System.out.println(decimalToBinary(10));
        System.out.println(decimalToBinary(7));
        System.out.println(decimalToBinary(4));

        // Above are my test cases


    }
    public static String decimalToBinary(int n){

        String x = ""; // Initialize String x

        for(int i = 1; i < 9; i++){ // Define i as 1 & Run the for loop 9 times because I want the string to contain 8 digits

         int h = 8 - i; //
         int grow = (int)Math.pow(2, h); // I am raising 2 to the "h" th power, because binary numbers have a base of 2
            x += n/grow; // increment by the n divided by 2 raised to the "h" th power every time,
            // for the smaller numbers there will be a lot of 0s at the beginning because int and grow are both integers
            // and if n is smaller than grow , java will round the number to 0
            n = n % grow; // n = the previous n + the remainder of n divided by 2 to the current "h" gth power

            // This code is saying to put a 1 at the "n/grow" th's place. For example, the integer of
            // 23 divided by 2 raised to the fourth power is 1, so we will put a 1 in the fourth place which is really
            // the 5th place because java starts counting from 0. 23 - 16 ( 2 to the fourth) = 7. The code will put a 0
            // for the 3rd place because 2 raised to the 3rd is 8 which is larger than the 7 that we have left over.
            //The code will then go to the next value of h which will 2. 7 divided by 2 squared equals 1 so a 1 will
            // go in the second place. 7 - 4 (2 squared ) = 3. The code will move to the next value of h which is 1
            // and do 3 divided by 2 raised to the first power which equals 1 in integer form.
            // 3 - 2 ( 2 raised to the first power ) equals 1. The code will move to the next value of h
            // which is 0 in this case and do 1 divided by 2 raised to the 0 power which equals 1 divided by 1
            // which is 1 so a 1 will go in the "0"th place which is really the first place because java starts
            // counting from 0

        }
        return x; // Return the string x after the for loop is done

    }
}
