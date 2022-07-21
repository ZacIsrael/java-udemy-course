package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	    // Test cases
        System.out.println(luhnChecksum(new int[]{4,5,6,3,9,2})); // 30
        System.out.println(luhnChecksum(new int[]{4,9,9,1,6,5,7})); // 40



    }
    public static int luhnChecksum(int[] array){

        for(int i = 0; i < array.length; i++){ // run this loop the length of the array
            // If i is an even number , multiply the integer in element i of the array by two
            if(i % 2 == 0){
                array[i] = array[i] * 2; // and store the new value in the array at that i element.
            }
            // if i is an odd number, do not do anything to that integer stored in the i element of the array.
            else {
               array[i] = array[i];
            }

        }
        int count = 0; // this is the variable that will count the checksum value
        for(int j = 0; j < array.length; j++){
            //If the integer in the array at element j is equal to or greater than 10, convert the integer into a String,
            //divide the string up into two characters, convert those characters back to integers, and then add those
            //integers to the totals count.
            if(array[j] >= 10 ){
               String s = Integer.toString(array[j]); // converting the integer to a string
               String first = Character.toString(s.charAt(0)); // Converting the first "character" into its own string
               String second = Character.toString(s.charAt(s.length()-1)); // Converting the second "character" into its own string
               int one = Integer.parseInt(first); // converting the first String back to an integer
               int two = Integer.parseInt(second);// converting the second String back to an integer
               count += one + two; // adding those integers to the count

            }
            else{
                // add any number less than 10 to the count.
                count += array[j];
            }
        }
        return count;


    }

}
