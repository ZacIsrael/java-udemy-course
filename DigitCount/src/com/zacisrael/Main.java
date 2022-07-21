package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(digitCount(9873839, 9));
        System.out.println(digitCount(65427489, 6));
        System.out.println(digitCount(4343434, 1));

        // Above are my test cases


    }
    public static int digitCount(int number, int digit){
        int count = 0; // initialize the integer count

        String numLength = String.valueOf(number); // Converting integer "number" into a string

        String dString = String.valueOf(digit); // Converting integer "digit" into a string

        for(int i = 0; i < numLength.length(); i++){
            // run this for loop for the number of characters in int "number" aka String numLength

            if(numLength.charAt(i) == dString.charAt(0)){
                // If character "i" in the String numLength is the dame as the first character in String dString,
                count++; // then add it to the count
            }
        }
        return count; // return the final count after the loop is done running
    }
}
