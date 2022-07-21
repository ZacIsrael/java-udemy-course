package com.zacisrael;

public class StringUtilities {
    private StringBuilder sbBuilder = new StringBuilder();
    private int charsAdded = 0;


    public void addChar(StringBuilder sbBuilder, char c){
        sbBuilder.append(c);
        charsAdded++;
    }

    public String upperAndPrefix(String str){
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }

    public String addSuffix(String str){
        return str + "__Suffix";
    }
}
