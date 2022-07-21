package com.zacisrael;



public class Main {

    public static void main(String[] args) {
	// write your code here

       StringUtilities utils = new StringUtilities();
       StringBuilder sb = new StringBuilder();
       while(sb.length() < 10){
           utils.addChar(sb, 'a');
       }
        System.out.println(sb);

       String str = "abcedfg";
       String result = utils.upperAndPrefix(str);

    }
}
