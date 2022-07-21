package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SalariedEmployee joe = new SalariedEmployee("Joe" , 2500);
        System.out.println(joe.getName());
        System.out.println(joe.earnings());
    }
}
