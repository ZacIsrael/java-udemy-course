
public class ValidEmailAddress {

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidEmail("zac390@gmail.com"));
        System.out.println(isValidEmail("a@d.c"));
        System.out.println(isValidEmail("luxurious1@samsung.org"));
        System.out.println(isValidEmail("3moneyman@yahoo.com"));
        System.out.println(isValidEmail("Letsgoreskins!@gmail.com"));


    }
    public static boolean isValidEmail(String s){

        if(s.matches("^[\\D][\\w\\d]{0,10}@[\\D][\\w\\d]{1,11}\\.[a-z]{1,3}")){
            // Return true if String s does not start on a digit has 1 to 10 letters, digits , or underscores followed
            // by the @ symbol followed by 1 to to 12 digits or letters (first of the 12 cannot be a digit) followed
            // by a period followed by 1 to 3 lowercase letters.
            return true;
        }
        else{
            // Otherwise, return false
            return false;
        }
    }
}
