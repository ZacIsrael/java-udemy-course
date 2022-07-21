public class Practice12 {

    public static void main(String[] args) {
        int result = 0;
        try{
            result = calc("3 + 5");
            System.out.println(result + " ");
            result = calc(result + " - 3");
            System.out.println(result + " ");
            result = calc(result + " / 0");
            System.out.println(result + " ");
            result = calc(result + " * three");
            System.out.println(result + " ");
        } catch(NumberFormatException e) {
            System.out.println("N");
        } catch(Exception e) {
            System.out.println("E");
        } finally{
            System.out.println(result);
        }
        //System.out.println(f(f(0,2), f(2,3)));
//        try {
//            System.out.println(checkAge(22));
//            System.out.println(checkAge(17));
//            System.out.println(checkAge(17 + checkAge(18)));
//            System.out.println(checkAge(3));
//            System.out.println(checkAge(15));
//        } catch (Exception e) {
//            System.out.println("exception");
//            System.out.println(e.getMessage());
//        }
    }
    public static int calc(String expr) {
        String[] s = expr.split("\\s");
        System.out.println(s[0] + s[1] + s[2]);
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[2]);
        if(s[1].equals("+")) return (x + y);
        if(s[1].equals("-")) return (x - y);
        if(s[1].equals("*")) return (x * y);
        else return (x / y);
    }


    public static int f(int x, int y) {
        if (x >= y) {
            System.out.println(x + y);
            return x + y;
        } else {
            System.out.println(x + "," + y);
            int a = f(x + 1, y);
            int b = f(x, y - 1);
            return a + b;
        }
    }

    public static int checkAge(int age) throws Exception {
        try {
            if (age < 14) throw new Exception("-2");
            else if (age < 18) return 0;
            else return 1;
        } catch (NumberFormatException e) {
            System.out.println("error");
            return -1;
        }
    }
}

