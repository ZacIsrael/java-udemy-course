package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(countVowels("Abraham Lincoln"));
        System.out.println(countVowels("love"));
        System.out.println(countVowels("Emory is awesome"));
        // Above are my test cases


    }
    public static int countVowels(String s){
        int count = 0; // initialize the integer count at zero
        for (int i = 0; i < s.length(); i++){ // run this for loop for the number of characters in string s
            if (s.charAt(i)== 'a'|| s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'
                    // if any of the letters are found in the string s, then add it to the count
                    ||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'
                    ||s.charAt(i)=='O'||s.charAt(i)=='U'){
                count++; // add to the count every time there is a vowel
            }
        }
        return count; // return the final count of vowels in the String s

    }
}
