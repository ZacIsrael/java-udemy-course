package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(letterCount("Love is in the air","b"));
        System.out.println(letterCount("Zac is a cool dude", "z"));
        System.out.println(letterCount(" ","q"));
        System.out.println(letterCount("Eat your food over there", "E"));
        // Above are my test cases

    }
    public static int letterCount(String s, String c){
        int count = 0; // initialize the integer count

        String c1 = (c.charAt(0) + "").toLowerCase(); // makes the 1 letter string c lower case
        String c2 = (c.charAt(0) + "").toUpperCase(); // makes the 1 letter string c uppercase
      for (int i = 0; i < s.length(); i++){ // run this for loop for the # of characters in String s

        if(s.charAt(i) == c.charAt(0) || s.charAt(i) == c2.charAt(0) || s.charAt(i) == c1.charAt(0)){
            // if the "i" character in string s is equal to the "0" character in String c (uppercase or lowercase),
                count++; // then add it to the count.
            } // Even though c is really a character, I defined it as a one letter string so I had to put c.charAt(0)
          //c.charAt(0) means the first letter in c because in java, we start counting from 0

        }
        return count; // return the count after the loops is done running

    }
}
