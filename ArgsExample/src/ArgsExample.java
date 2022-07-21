public class ArgsExample {

    public static void main(String[] args) {

        System.out.println("You typed " + args.length + " words");

        for (int i = 0; i < args.length; i++){
            System.out.println("Argument " + i + ": " + args[i]);
        }
    }
}
