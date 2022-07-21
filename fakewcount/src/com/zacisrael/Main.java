package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(wordCount("We are calm")); // 3
        System.out.println(wordCount("Leave    ")); // 1
        System.out.println(wordCount("I can not stand you")); // 5
        System.out.println(wordCount("Letsgohome9!")); // 1
        System.out.println(wordCount(" ")); // 0


    }
    public static int wordCount(String s){
        int count = 0;
        if (s.length()> 0){ // Only run this method if the sting lenth is greater than zero
            if (s.charAt(0) != ' '){
                count++;
            }

            for (int i = 1; i < s.length(); i++){ // The loop starts at 1
                if (s.charAt(i)!= ' ' && s.charAt(i-1)== ' '){
                    count++;
                }
            }
        }
        return count;


    }
}
