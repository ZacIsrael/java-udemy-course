package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println( makeComplement("ATTGC"));
    }


    public static String makeComplement(String dna) {
        String test = "";

        for(int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'A'){
                test += 'T';
            }
            if(dna.charAt(i)  == 'T'){
                test += 'A';
            }
            if(dna.charAt(i) == 'G'){
               test += 'C';
            }
            if(dna.charAt(i) == 'C'){
                test += 'G';
            }
        }

        return test;
    }
}
