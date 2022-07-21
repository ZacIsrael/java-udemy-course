import java.io.File;
import java.util.Scanner;

public class Practiceeee12 {

    public static void main (String[] args) {
        Scanner scanner = null;
        int z = 0;
        try {
            scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()){
                try {
                    String w = scanner.next();
                    z += Integer.valueOf(w);
                    System.out.println(z);
                } catch(NumberFormatException e) {
                    System.out.println("x");
                    z -= z;
                }
            }
        } catch(Exception e) {
            System.out.println("e");
        }
        finally {
            System.out.println(z);
            scanner.close();
        }
    }

}
