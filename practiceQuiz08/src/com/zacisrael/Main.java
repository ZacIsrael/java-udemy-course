package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(divi(3, 5));
        System.out.println(div(5, 3));
        System.out.println(div(5, 2));
        System.out.println(divi(6,3));
       // System.out.println(mirrorString("hey"));
        /*
        String x = "just";
        System.out.println(x.substring(1));

        System.out.println(isPower(27, 3));
        System.out.println(isPower(64, 16));
        System.out.println(isPower(3,3));
        System.out.println(isPower(12, 2));
        System.out.println(isPower(54, 9));
        System.out.println(tripleChar("hello", 'e'));
        String[] s1 = {"hi", "hello", "hey"};
        System.out.println(catAll(s1, 3)); */
         //g("phone", "car");
       // System.out.println(f("abc"));
        //System.out.println(f("hey#"));




    }
    public static int divi(int n, int d){
        int count = 0;
        for(int i = n; i >= 0; i--){

            if(i >= d && d > 0){
                count++;
            }
           // i = (i - d) + 1;
        }
        return count;
    }
    public static int div(int n, int d){
        if(n < d){
            return 0;
        }
        else{
            return 1 + div(n-d, d);
        }
    }
    // Write a recursive function mirrorStr(String s) that takes a string s and return
    //the string concatenated with its mirror image.
    public static String mirrorString(String s) {
        if (s.equals("")) {
            return "";
        } else {
        return s.charAt(0) + mirrorString(s.substring(1)) + s.charAt(0);
    }
    }
    public static String mirroredString(String s){
        String result = "";
       int n = (int) s.charAt(s.length()-1);

        for(int i = 2; i >= 0; i--){
            result += s.charAt(i);
        }
        return s + result ;
    }

    public static boolean isPower(int n, int m){
        if(n == 1){
            return true;
        }
        else{
            return (n % m == 0) && isPower(n/m, m);
        }
    }
    public static String tripleChar(String s, char c){
        if(s.equals("") ){
            return "";
        }
        else if(s.charAt(0) == c){
            return "" + c + c + c + tripleChar(s.substring(1), c);
            // if c is the first character in s, return c 3 times followed by the substring of s from index 1

        }
        else {
            return s.charAt(0) + tripleChar(s.substring(1), c);
            // otherwise return the first character in s followed by thw substring of s from index 1
        }
    }
    public static String catAll(String[] s, int n) {
        if (n == 0) {
            return "";
        } else {
            return catAll(s, n - 1) + s[n -1];
        }

    }
    public static String f (String s) {
        if (s.length() == 1) {
            System.out.println("base " + s);
            return s;
        } else {
            String a = s.substring(0, 1).toUpperCase();
            String b = f(s.substring(1));
            System.out.println("rec " + b + a);
            return b + a;
        }
    }


}
