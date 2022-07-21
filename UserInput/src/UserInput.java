import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        String name = "[N/A]";
        int age = 0;

        System.out.println("Welcome to the Georgia Driver License Application System. Please enter your info. ");
        System.out.println("Enter 'a' for age (must be 18+).\nEnter 'n' for name (must be within 10 letters)." +
                "\nEnter 'q' to quit.");
        input = in.next();


        while(! input.equals("q")){
            try {
                if (input.equals("a")) {
                    System.out.println("Enter age:");
                    age = in.nextInt();
                    checkAge(age);
                } else if (input.equals("n")) {
                    System.out.println("Enter name:");
                    name = in.next();
                    checkName(name);
                }
            } catch (InputMismatchException e){
                System.out.println("Input mismatch. Try again.");
            } catch (RuntimeException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            } finally{
                System.out.println("User info entered. Name: " + name + ". Age: " + age + ".");
                System.out.println("\nEnter 'a' for age (must be 18+). \nEnter 'n' for name (must be within 10 letters). \nEnter 'q' to quit");
                input = in.next();
            }
        }
    }
    public static void checkAge(int age){
        if(age < 18) throw new RuntimeException("Too young to drive!");
        else return;
    }
    public static void checkName(String name){
        if (name.length() > 10) throw new RuntimeException("Name is too long.");
        else return;
    }

}
