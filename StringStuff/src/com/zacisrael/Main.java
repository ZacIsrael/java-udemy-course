package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	    char c = 'A'; // one single character
        /* String s1 = "ABCD";
        String s2 = "A";
        String s3 = " ";

        System.out.println(c);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // A char is actually a number
        // See www.asciitable.com
        System.out.println('A' + 1); // char gets converted into an int
        char k = s1.charAt(2);
        System.out.println(k);

        int n = s1.length();
        System.out.println(n);

        String s4 = "Hello evreyone";
        System.out.println(s4.substring(3,8));
        System.out.println(s4.substring(8));
        System.out.println(s4.toUpperCase());

        String x = "hey";
        String y = "you";
        String z = "hey";

        System.out.println(x.equals(y)); // false
        System.out.println(x.equals(z));// true

        System.out.println(x.compareTo(y)); */

        System.out.println(mySubstring("Jason", 2, 4));
        System.out.println(mySubString("examination", 2, 6, 2));
        System.out.println(reverse("ABCDE"));
        System.out.println(mergeStrings("ABCD", "1234"));
        System.out.println(mergeStrings("AB", "1234"));
        System.out.println(mergeStrings("ABCD", "12"));


    }
    public static String mySubstring(String s, int start, int end){
        String result = " ";

        for ( int i = start; i < end; i++){
            result += s.charAt(i);

        }
        return result;

    }
    public static String mySubString(String s, int start, int end, int step){
        String result = " ";
        for(int i = start; i < end; i+= step){
            result += s.charAt(i);
        }
        return result;


    }
    public static String reverse(String s){
        String result = " ";
        for (int i = s.length()-1; i >= 0; i--){
            result += s.charAt(i);
        }
        return result;
    }
    public static String mergeStrings(String s1, String s2){
        String result = " ";
        if (s1.length() < s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                result += "" + s1.charAt(i) + s2.charAt(i);
            }
            for (int j = s1.length(); j < s2.length(); j++){
                result += s2.charAt(j);
            }
        }
        else{
            for (int m = 0; m < s2.length(); m++){
                result += ""
            }

        }
        return result;

    }

}
