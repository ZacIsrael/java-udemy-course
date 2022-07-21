package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] t = new int[10];
        t[0] = 5;
        t[1] = 3;
        t[2] = 7;
        t[3] = 9;
        //System.out.println(arrayToString(t, 4));

        insert(t, 4, 10, 2);
        System.out.println(arrayToString(t, 5));

        //int q = remove(t, 5, 1);
        //System.out.println("q : " + q + " a: " + arrayToString(t, 4));






    }
    public static void insert(int[] a, int n, int x, int pos){
        for (int i = n -1; i >= n; i--){
            a[i + 1] = a[i];
        }
        a[pos] = x;
    }
    public static int remove(int[] a, int n, int pos){
        int result = a[pos];
        for(int i = pos + 1; i < n; i++){
            a[i - 1] = a[i]; // all the elements will ahve been shifted back by 1 after this for look is done running

        }
        a[n-1] = 0;
        return result;
    }
    public static String arrayToString(int[]x, int pos){
        String result = "["; // Opens the braces
        for (int i = 0; i < pos - 1; i++){
            result += x[i] + ", ";
        }
        if ( x.length > 0) {
            result += x[x.length - 1];
        }
        result += "]"; // Closes the brace
        return result;
    }


}
