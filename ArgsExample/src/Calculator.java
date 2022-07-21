public class Calculator {

    public static void main(String[] args) {

        if(args.length < 3){
            System.out.println("Usage: java Calculator <number> <operator> <number>");
            System.exit(0);
        }

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[2]);
        String op = args[1];

        if (op.equals("+")){
            System.out.println(x + y);
        } else if(op.equals("-")){
            System.out.println(x - y);
        } else if(op.equals("*")){
            System.out.println(x * y);
        } else if(op.equals("/")){
            System.out.println(x / y);
        } else {
            System.out.println("Operation not supported");
        }

    }
}
