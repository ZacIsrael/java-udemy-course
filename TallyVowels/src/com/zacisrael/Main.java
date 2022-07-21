package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        // Test cases
        int[] x1 = tally("HEY! Apples and bananas"); // {5,2,0,0,0}
        printArray(x1);

        int[] x2 = tally("Zacchaeus is an awesome human being"); // {5,4,2,1,2}
        printArray(x2);

        int[] x3 = tally("Did you know that vowels are rare"); // {5,3,1,3,1}
        printArray(x3);


    }
    public static int[] tally(String array){
        int countA = 0; // counter for the vowel a
        int countE = 0; // counter for the vowel e
        int countI = 0; // counter for the vowel i
        int countO = 0; // counter for the vowel o
        int countU = 0; // counter for the vowel u



        for(int i= 0; i < array.length(); i++){
            if(array.charAt(i) == 'a' || array.charAt(i) == 'A' ){ // if the array at character i is 'a' or 'A',
                countA++; // add to the a count.
            }

            else if(array.charAt(i) == 'e' || array.charAt(i) == 'E' ){ // if the array at character i is 'e' or 'E',
                countE++; // add to the e count.
            }
            else if(array.charAt(i) == 'i' || array.charAt(i) == 'I' ){ // if the array at character i is 'i' or 'I',
                countI++; // add to the i count.
            }
            else if(array.charAt(i) == 'o' || array.charAt(i) == 'O' ){ // if the array at character i is 'o' or 'O',
                countO++; // add to the o count
            }
            else if(array.charAt(i) == 'u' || array.charAt(i) == 'U' ){ // if the array at character i is 'u' or 'U'
                countU++; // add to the u count
            }
        }

        int[] result = new int[]{countA, countE, countI, countO, countU};
        // the result will be an array with 5 integers, the first will be countA, the second will be countE and so on.
        return result; // return the result array
    }



    public static void printArray(int[] array) { // Method for printing the array
        System.out.print("{"); // Print the open bracket
        // Do "System.out.print" instead of "System.out.println" so the values do not go to a new line.
        for (int i = 0; i < array.length; i++) { // run this loop the number of times the length of the array
            System.out.print(array[i]);
            if (i < array.length - 1) { // This if statements adds a comma after every element except the last one
                System.out.print(", ");
            }
        }
        System.out.print("}"); // end the line with a closed bracket
        System.out.println("\t"); // moves to the next line
    }


}
