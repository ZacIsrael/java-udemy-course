package com.zacisrael;

public class Main {
    //

    public static void main(String[] args) {
	// write your code here
        String s = "apple";
        System.out.println(s.matches("apple")); // true
        System.out.println(s.matches("Apple")); // false
        System.out.println(s.matches("[aA]pple")); // true
        s = "Apple";
        System.out.println(s.matches("[aA]pple|[oO]range"));
        // return true if string s is either apple or orange, ignore case of a and o
        s = "orange";
        System.out.println(s.matches("[aA]pple|[oO]range"));

        s = "apple pie";
        System.out.println(s.matches("[aA]pple.*"));
        // return true if string s is appple followed by any character

        System.out.println(s.matches("[aA]pple\\s[p|P]ie"));
        // return true if apple if followed by a space and then pie


        // quantifiers:
        // + : 1 or more
        // * : 0 or more
        // ? : 0 or 1
        // {x} :
        // {X, Y} : any number between x and y (inclusive)

        s = "apple";
        System.out.println(s.matches("c*a+p+l.*"));
        // Will return true if string s has 0 or more "c" followed by one or more "a" followed by
        // one or more "p" followed by an "l" and any characters after that

        System.out.println(s.matches("c*a+p?l.*"));
        // Will return true if string s has 0 or more "c" followed by one or more "a" followed by 0 or 1 "p"
       // followed by an "l" followed by anything
        System.out.println(s.matches(".*apple.*"));

        s = "pie";
        System.out.println(s.matches("[a-zA-Z]{3}"));
        // Will return true if string s is 3 letters from the alphabet

        System.out.println(s.matches("\\w{3}")); // true, 3 word characters

        System.out.println(s.matches("\\w{5,9}"));
        // false, because string s is not between 5 & 9 word characters

        System.out.println(s.matches(".{5,9}"));
        // false, between 5 and 9 of any character

        System.out.println(s.matches("[^\\d].*"));
        // true, s does not start with a digit

        s = "10 apples";
        System.out.println(s.matches("[^\\d].*"));
        // false, because string s starts with a digit and the regular
        // expression says return true if string s does not start with a digit

        String phonePattern = "\\d{3}[-\\s]?\\d{4}";
        // any 3 digits plus 0 or 1 spaces or dash plus any 4 digits

        String phone1 = "9993434";
        String phone2 = "999-3434";
        String phone3 = "999 3434";
        String phone4 = "99993 3434";
        String phone5 = "999, 3434";

        System.out.println(phone1.matches(phonePattern));
        System.out.println(phone2.matches(phonePattern));
        System.out.println(phone3.matches(phonePattern));
        System.out.println(phone4.matches(phonePattern));
        System.out.println(phone5.matches(phonePattern));

        // replaceAll
        s = "To be , or not to be. That is the question  .";
        String pattern = "(\\w)(\\s+)([\\.,])";
        // a word character followed by 1 or more spaces followed by a dot or a comma
        System.out.println("Before -> " + s);
        s = s.replaceAll(pattern, "$1$3");
        // removes the spaces between the characters and puncuation marks
        System.out.println("After -> " + s);
        System.out.println(s.replaceAll("e[^\\w]","eee" ));
        //looks places where e is not followed by a word character and replaces them with "eee"

        System.out.println(s.replaceAll("(e)([^\\w])", "$1$1$1$2"));


        s = " To be, or not to be. My two cents.";
        System.out.println(s);
        System.out.println(s.replaceAll("[tT]w?o", "2"));
        // replace any "two", "Two", "to", or "To" with the 2

        System.out.println(s.replaceAll("[tT]w+o", "2"));
        // replace any word that starts with t followed by one or more
        // w's then followed by an o with a 2

        System.out.println(s.replaceAll("[tT]w*o", "2"));
        // replace 2 for any word that starts with t followed by a w repeated 0 or more times
        // followed by a o









    }


}
