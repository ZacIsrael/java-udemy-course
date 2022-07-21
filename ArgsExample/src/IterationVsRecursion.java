public class IterationVsRecursion {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorialWhile(5));
        System.out.println(factorialRec(5));
        System.out.println(reverseFor("happy"));
        System.out.println(reverseWhile("happy"));
        System.out.println(reverseRec("happy"));


    }

    public static int factorial(int n){
        int result = 1;
        for ( int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static int factorialWhile(int n){
        int result = 1;
        int i = 1;
        while(i <= n){
            result *= i;
            i++;
        }
        return result;
    }
    public static int factorialRec(int n){
        if(n <= 0){
            return 1;
        }
        else{
            return n * factorialRec(n-1);
        }
    }

    public static String reverseFor(String s){
        String result = "";

        for(int i = s.length()-1; i >= 0; i--){
            result += s.charAt(i);
        }
        return result;

    }
    public static String reverseWhile(String s){
        String result = "";
         int i = s.length()-1;
         while(i >= 0){
             result+= s.charAt(i);
             i--;
         }
         return result;
    }
    public static String reverseRec(String s){
        if(s.length() == 0){
            return "";
        }
        else{
            return s.charAt(s.length()-1) + reverseRec(s.substring(0,s.length()-1));
        }
    }

}
