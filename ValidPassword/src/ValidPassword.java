
public class ValidPassword {

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidPassword("@sty_5hy"));
        System.out.println(isValidPassword("!ockerol"));
        System.out.println(isValidPassword("ZM34sO_"));
        System.out.println(isValidPassword("w 5672s"));
        System.out.println(isValidPassword("weArenot!"));
        System.out.println(isValidPassword("LifEg2!"));


    }
    public static boolean isValidPassword(String s){
       if (s.matches("^[A-Z!@#][\\w\\d]{5,7}$")){
           // If the string starts with any upper case letter, @, !, or # and is followed by 5 to 7 letters,
           // digits, or underscores and the string ends on a letter, number, or underscore, return true.
           return true;
       }
       else{
           //Otherwise, return false
           return false;
       }

    }
}
