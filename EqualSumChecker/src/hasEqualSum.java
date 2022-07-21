public class hasEqualSum {

    public static void main(String[] args) {
        hasEqualSum(1, 1, 1);
        hasEqualSum(1,1, 2);
        hasEqualSum(1, -1, 0);

    }

    public static boolean hasEqualSum(int a, int b, int c){

        boolean sum = false;

        if (a + b == c){
            sum = true;
            System.out.println("The sum of " + a + " and " + b + " = " + c + ". True or False? " + sum);
        } else {
            sum = false;
            System.out.println("The sum of " + a + " and " + b + " = " + c + ". True or False? " + sum);

        }
        return sum;


    }
}
