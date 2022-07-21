package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        // Test cases below
        System.out.println(isReverse("happy", "yppah"));
        System.out.println(isReverse("coal","looc"));
        System.out.println(isReverse("",""));
        System.out.println(isReverse("a","a"));
        System.out.println(isReverse("love","avol"));


    }
    public static boolean isReverse(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) { // If both the strings are empty, return true
            return true;
        } else if (s1.length() == s2.length()) {
            // if both string are the same length, the code will do the following
            int textLength = s2.length(); // integer for the current length of s2

            char char1 = s1.charAt(0);
            // the first character in the current s1
            char char2 = s2.charAt(textLength - 1);
            // Subtract 1 from the current length of s2 because java starts counting from 0

            if (char1 == char2) {
                // If the first character in s1 is the same as the last character in s2,
                // then run the method again with the substring from character 1 of the
                // current value of s1 and the substring of s2 starting from the first character
                // and ending with second to last character from the last the current value of s2
                String nextChar1 = s1.substring(1);
                String nextChar2 = s2.substring(0, textLength - 1);

                return isReverse(nextChar1, nextChar2);
            } else {
                // If the first character for the current s1 does not match the last character
                // in the current s2, the code will return false
                return false;
            }
        }
        // If s1 and s2 are not equal lengths, the code will return false
        return false;
    }

}
