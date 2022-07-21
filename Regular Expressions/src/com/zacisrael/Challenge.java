package com.zacisrael;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Challenge {

    public static void main(String[] args) {

        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        System.out.println("\nChallenge 2");
        String challenge2 = "I want a ball";

        String challenge1And2RegExp = "I want a b.*";

        System.out.println(challenge1.matches(challenge1And2RegExp));
        System.out.println(challenge2.matches(challenge1And2RegExp));

        System.out.println("\nChallenge 3");
        String regExp3 = "I want a b.*";
        Pattern pattern = Pattern.compile(regExp3);
        Matcher challenge1Matcher = pattern.matcher(challenge1);
        Matcher challenge2Matcher = pattern.matcher(challenge2);
        System.out.println(challenge1Matcher.matches());
        System.out.println(challenge2Matcher.matches());

        System.out.println("\nChallenge 4");

        String c4 = "Replace all blanks with underscores";
        System.out.println(c4.replaceAll(" ", "_"));

        System.out.println("\nChallenge 5");
        String c5 = "aaabccccccccdddefffg";

        String c5Copy = c5;
        Pattern c5Pattern = Pattern.compile(c5Copy);
        Matcher c5Matcher = c5Pattern.matcher(c5);
        System.out.println(c5Matcher.matches());

        System.out.println("\nChallenge 7");
        String regEx7 = "^[A-Za-z]+\\.[0-9]+$";
        System.out.println("abcd.135".matches(regEx7));

        System.out.println("\nChallenge 8");
        String challenge8 = "abc.135Suvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while(matcher8.find()){
            System.out.println("Occurrences: " + matcher8.group(1));
            // will print the numbers after the "."
        }

        System.out.println("\nChallenge 9");
        String challenge9 = "abc.135\tSuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher9.find()){
            System.out.println("Occurrence: " + matcher9.group(1));
        }

        System.out.println("\nChallenge 10");
        String challenge10 = "abc.135\tSuvqz.7\ttzik.999\n";
        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher10 = pattern9.matcher(challenge9);
        while(matcher10.find()){
            System.out.println("Occurrence start = " + matcher10.start(1) + " end = " + (matcher10.end(1)-1));
        }

        System.out.println("\nChallenge 11");
        String challenge11 = "{0,2}, {0,5}, {1,3}, {2,4}, {x,y}, {6,34}, {11,12}";
        Pattern pattern11 = Pattern.compile("\\{(\\d+,\\d+)}"); // curly braces with numbers separated by a comma between them
        Matcher matcher11 = pattern11.matcher(challenge11);
        while(matcher11.find()){
            System.out.println("Occurrence: " + matcher11.group(1));
        }

        System.out.println("\nChallenge 12");
        String regEx12 = "^\\d{5}$";
        System.out.println("11111".matches(regEx12));
        System.out.println("20019".matches(regEx12));

        System.out.println("\nChallenge 13");
        String regEx13 = "^\\d{5}-\\d{4}$";
        System.out.println("11111-1111".matches(regEx13));

        System.out.println("\nChallenge 14");
        String regEx14 = "^\\d{5}(-\\d{4}$)?";
        System.out.println("11111-1111".matches(regEx14));
        System.out.println("11111".matches(regEx14));


    }
}
