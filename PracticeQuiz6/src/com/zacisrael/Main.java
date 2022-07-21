package com.zacisrael;

public class Main {

    public static void main(String[] args) {

       /* System.out.println(middle("Reading"));
        System.out.println(middle("Awesome"));
        System.out.println(middle("lovely"));
        System.out.println(pickAndRepeat("cart", 0, 3, 2));
        System.out.println(pickAndRepeat("cart", 1, 2, 3));
        System.out.println(pickAndRepeat("cart", 1, 1, 1));
        System.out.println(pickAndRepeat("cart", 3, 2, 1));

          System.out.println(isRepeated('p', "apple"));

       String[] x1 = {"hello"} ;
        System.out.println(totalLength(x1)); */

        String[] x2 = {"list", "of", "words"};
        printArray(oddWords(x2));



    }
    // Write a method named middle(String s) that takes a string s that contains at
    //least one character (you may assume this). The method returns a string
    //containing the middle character prefaced by "just" if the string's length is
    //odd, and returns a string containing the middle two characters connected with an
    //"and" if the string's length is even.
    //
    //Examples:
    //middle("apple") returns "just p"
    //middle("orange") returns "a and n"
    public static String middle(String s){

        if (s.length() % 2 == 0){
            return s.charAt((s.length()/2)- 1) + " and " + s.charAt(s.length()/2);
        }
        else {
            return "just " + s.charAt((s.length() - 1)/2);
        }
    }
    // Write a method named pickAndRepeat(String s, int n, int r, int p) that takes a
    //string s and an integers n, r, and p.
    //(you may assume that both n and p are between 0 and s.length()-1). The method
    //returns the string s with its n-th character (counting from 0) inserted r times
    //starting at the p-th position (counting from 0).
    //
    //Examples:
    //pickAndRepeat("cart", 0, 3, 2) returns "cacccrt"
    //pickAndRepeat("cart", 1, 2, 3) returns "caraat"
    //pickAndRepeat("cart", 1, 1, 1) returns "caart"
    //pickAndRepeat("cart", 3, 2, 1) returns "cttart"

   public static String pickAndRepeat(String s, int n, int r, int p){
        String result = "";
        char c = s.charAt(n);
        for (int i = 0; i < s.length(); i++){
            if (i == p){
                for ( int j = 0; j < r; j++){
                    result += c;
                }
            }
            result += s.charAt(i);
        }
        return result;
   }
   //Write a method isRepeated(char c, String s) that takes a character c and a
    //string s. The method returns true if c is repeated at least twice inside s;
    //false otherwise.
    public static boolean isRepeated(char c, String s){
        int count = 0;
        for( int i = 0; i < s.length(); i++){
            if(c == s.charAt(i)){
                count++;
            }
        }
        if (count > 1){
            return true;
        }
        else{
            return false;
        }
    }
    // Write a method totalLength(String[] x) that takes an array of strings x and
    //returns the total number of characters in the list. You can assume all the
    //elements of the array contain a valid string.
    public static int totalLength(String[] x){
        int count = 0;
        for(int i = 0; i < x.length; i++){
           count += x[i].length();
        }
        return count;
    }
    // Write a method oddWords(String[] x) that takes an array of strings x and returns
    //a new array containing only the words from x that have an odd number of
    //characters. You can assume all the elements of x contain a valid string.
    public static String[] oddWords(String[] x){
        int count = 0;
        for(int i = 0; i < x.length; i++){
            if(x[i].length() % 2 == 1){
                count++;
            }
        }
        String[] result = new String[count];
        int z = 0;
        for(int j = 0; j < x.length; j++){
            if(x[j].length() % 2 == 1){
               result[z] = x[j];
               z++;
            }
        }
        return result;

    }
    public static void printArray(String[] x) {
        for (String s : x) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
