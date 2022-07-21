package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int x;
        int y;
        x = 9;
        y = add0ne(x);
        System.out.println("x contains: " + x);
        System.out.println("y contains: " + y);


        System.out.println(sum(x,y));

    }
    public static int add0ne(int x){
        return x + 1;
    }
    public static int sum(int x, int y){
        int z = x + y;
        return z;
    }
}
