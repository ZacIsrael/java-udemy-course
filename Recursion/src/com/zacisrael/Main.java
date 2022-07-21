package com.zacisrael;

public class Main {

    public static void main(String[] args) {


       // System.out.println(power0fTwo(3));
        //System.out.println(power0fThirtyNine(39));
        //System.out.println(factorial(6));
        System.out.println(reverse("ABCDE"));

        /*System.out.println(palindrome("kayak"));
        System.out.println(palindrome("Zacchaeus"));
        System.out.println(palindrome("AA"));
        System.out.println(palindrome("A"));
        System.out.println(palindrome("kayyk")); */


    }
    public static int power0fTwo(int n){
        if(n == 0){ // base case
            return 1;
        } else{
            return 2 * power0fTwo(n-1);
        }
    }
    public static int power0fThirtyNine(int n){
        if(n == 0){
            return 1;
        }
        else{
            return 39 * power0fThirtyNine(n-1);
        }
    }
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }
    public static String myBackwardsString(String s){
        String result = "";

            for(int i= s.charAt(s.length()-1); i == 0;i++){
                result += s.charAt(i);
            }
            return result;

    }
    public static String reverse(String s){
        if(s.length() <= 1){
            return s;
        }
        else{
            return s.charAt(s.length()-1) + reverse(s.substring(0,s.length()-1));
        }
    }
    public static boolean palindrome(String s){
        if(s.length() <= 1){
            return true;
        }
        else{
            return (s.charAt(0) == s.charAt(s.length()-1)) &&
                    (palindrome(s.substring(1, s.length()-1)));
        }
    }
}
