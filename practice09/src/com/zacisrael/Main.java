package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(logHistogram(8));
        System.out.println(logHistogram(7));
        System.out.println(logHistogram(16));


    }
    public static void matrixMod(int[][] x, int rows, int cols, int k) {
        if (rows == 0 || cols == 0) {
            return;
        } else if (x[rows - 1][cols -1] < k) {
            return;
        } else {
            x[rows - 1][cols - 1] %= k;
            matrixMod(x, rows, cols - 1, k);
            matrixMod(x, rows - 1, cols, k);
        }
    }
    public static String logHistogram(int n){
        if( n < 2){
            return "";
        }
        else{
            return "=" + logHistogram(n/2);
        }
    }

    public static void printArray(int[][] x) {
        for (int row = 0; row < x.length; row++) {
            for (int col = 0; col < x[row].length; col++) {
                System.out.print(x[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }




















    public static int f(String s, String w) {
        if (s.length() == w.length()) {
            System.out.println("stop " + s + " " + w);
            return 1;
        } else {
            System.out.println(s + " " + w);
            if (s.length() < w.length()) {
                System.out.println("woof");
                int a = 1 + f(s + w.charAt(0), w.substring(1));
                int b = 1 + f(w, s);
                System.out.println("quack");
                return a + b;
            } else {
                System.out.println("meow");
                int c = 1 + f(s.substring(0, s.length() / 2), w);
                int d = 1 + f(s.substring(s.length() / 2), w);
                return c + d;
            }
        }
    }

}
