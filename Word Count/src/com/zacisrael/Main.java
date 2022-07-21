package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(wordCount(" "));
        System.out.println(wordCount("Life is great"));
        System.out.println(wordCount("Iamanathlete"));
        System.out.println(wordCount("I am thankful to be at Emory"));
        System.out.println(wordCount("Bereal withyourself man"));

        // above are my test cases

    }

    public static int wordCount(String x) {
        int count = 0; // initialize the integer count

        if(x.length() > 0){
            // Only complete the following code below if the length of string x is larger than 0 characters
            if(x.charAt(0) != ' '){
                count++;
            }

        for (int i = 1; i < x.length(); i++) {
         // I had to set i to 1 because if i = 0, the loop will stop running 1 character short of the length of strong x
         // run this loop the number times as there are characters in string x

            if (x.charAt(i) != ' ' && x.charAt(i - 1) == ' ') {
        // if character "i" in string x is not a space and the character before it is not a space, then
                count++; // add it to the count.
            }

        }
    }
        return count; // return the count after the loop is finished running
    }
}
