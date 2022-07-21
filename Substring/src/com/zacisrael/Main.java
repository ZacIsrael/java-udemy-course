package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /* String x = "Zacchaeus";
        System.out.println(x.substring(1));
        System.out.println(x.substring(2));
        System.out.println(x.substring(3));
        System.out.println(x.substring(3,5));
        System.out.println(x.substring(0,7));

        for (int x = 2; x < 4; x++) {
            for (int y = x; y > 0; y--) {
                boolean a = (double)x / y > x / y;
                boolean b = x - y > 0;
                System.out.println(a + " " + b + " " + (a && b) + " " + (a || b));
            }
        }

        int a = 2;
        int b = 4;
        int i = a;
        while ( i < b ) {
            int c = i + 1;
            System.out.println("hey " + i);
            int j = c;
            while ( j > 0) {
                System.out.println("you " + j);
                j--;
            }
            i++;
        }

        System.out.println(extractVowels("Zacchaeus"));
        System.out.println(extractVowels("We are awesome"));
        System.out.println(extractVowels("Keith"));

        System.out.println(pickAndRepeat("Zacchaeus", 3));
        System.out.println(pickAndRepeat("cart", 2)); */
        System.out.println(extremes("Kenilworth"));


    }
    public static String extractVowels(String s){
        String result = "";

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'e' || c == 'a' || c == 'u'|| c == 'o'|| c == 'i'){
                result += c;
            }

        }
        return result;
    }
    public static String pickAndRepeat(String s, int n){
        String result = s.substring(0, n);

        for (int i = 0; i < n; i++){
            result += s.charAt(n);
        }
        result += s.substring(n + 1);
        return result;
    }
    public static String extremes(String s){

        return s.charAt(0) + "-" + s.charAt(s.length()-1);
    }

}
