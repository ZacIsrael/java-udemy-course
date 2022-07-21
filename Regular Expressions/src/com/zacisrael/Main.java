package com.zacisrael;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // Regular expressions are ofetn used to validate user input

    public static void main(String[] args) {

        String string = "I am a string. Yes I am";
        System.out.println(string);
        String yourString = string.replaceAll("I am", "You are");
        System.out.println(yourString);

        String alphaNumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphaNumeric.replaceAll(".", "Y")); // "." = any character
        System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));
        // ^ start of the string, if the text behind the ^ is not at the beginning of the string,
        // nothing will happen to the string.

        String alphaNumeric2 = "abcDeeeF12GhhiiiijkabcDeeel99zabcDeee";
        System.out.println(alphaNumeric2.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphaNumeric.matches("^hello"));
        // returns false because the alphanumeric is not equal to "hello"

        System.out.println(alphaNumeric.matches("^abcDeee"));
        // returns false because "abcDeeeF12Ghhiiiijkl99z" != "abcDeee"

        System.out.println(alphaNumeric.matches("abcDeeeF12Ghhiiiijkl99z"));
        // returns true because "abcDeeeF12Ghhiiiijkl99z".equals("abcDeeeF12Ghhiiiijkl99z");

        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "THE END"));
        // if the alphanumeric string ENDS ($) with "ijkl99z", replace it with "THE END"

        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));
        // replaces ALL occurrences of 'a', 'e', & 'i' with "X"

        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));
        // replaces ALL occurrences of "aF", "aj", "eF", "ej", "iF", & "ij" with an "X"

        System.out.println("Harry".replaceAll("[Hh]arry", "Harry"));

        System.out.println(alphaNumeric.replaceAll("[^ej]", "X"));
        // replaces any character that's not 'e' or 'j' with an 'X'

        System.out.println(alphaNumeric.replaceAll("[abcdef345678]", "X"));
        // Replaces any of the characters in the bracket with a "X"

        System.out.println(alphaNumeric.replaceAll("[a-f3-8]", "X"));
        // same thing as the line above

        System.out.println(alphaNumeric.replaceAll("(?i)[a-f3-8]", "X"));
        // (?i) ignores case sensitivity

        System.out.println(alphaNumeric.replaceAll("[0-9]", "X"));
        // replaces any digit with a "X"

        System.out.println(alphaNumeric.replaceAll("\\d", "X"));
        // replaces any digit with a "X"

        System.out.println(alphaNumeric.replaceAll("\\D", "X"));
        // replaces ALL NON-digits with a "X"

        String hasWhiteSpace = "I have blanks and\ta tab, and also a new line\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        // removes all spaces in the string
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        // replaces all tabs with an X

        System.out.println(alphaNumeric.replaceAll("\\w", "X"));
        // replaces any non-white space character with an "X"

        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        // replaces any non-white space character with an "X"

        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));
        // Surrounds each word in the string with "X"


        String thirdAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        // if the string starts with "abcDeee" , replace the beginning with "YYY"

        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY"));
        // adding "+" at the end of a character means one or more of that character

        System.out.println(thirdAlphanumeric.replaceAll("^abcDe*", "YYY"));
        // adding "*" at the end of a character means 0, 1, or multiple of that character

        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        // adding {a,b} after a character means any number a through b of that character (inclusive)

        System.out.println(thirdAlphanumeric.replaceAll("h+i*j", "Y"));
        // 1 or more h's + 0 or more i's followed by one j

        System.out.println();
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }


        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();
        while(groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }


        System.out.println("=================");

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()){
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
            // prints the text between the h2 tags
            // group 1 would print "<h2>"
            // group 3 would print "</h2>
        }


        System.out.println("=================");
        System.out.println("harry".replaceAll("[H|h]arry","Larry"));
        // replaces "harry" or "Harry" with "Larry"


        System.out.println("=================");

        String tvTest = "tstvtkt";
      //  String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)"; // "t" that is NOT followed by a "v"
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int counter = 0;
        while(tNotVMatcher.find()){
            counter++;
            System.out.println("Occurrence " + counter + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }


        String validPhone = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$";
        String phone1 = "1234567890"; // no match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // no match
        String phone4 = "(123)456-7890"; // no match

        System.out.println("phone1 = " + phone1.matches( validPhone));
        System.out.println("phone2 = " + phone2.matches(validPhone));
        System.out.println("phone3 = " + phone3.matches(validPhone));
        System.out.println("phone4 = " + phone4.matches(validPhone));
    }
}
