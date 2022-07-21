public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println(intToRoman(45));
//        System.out.println(intToRoman(1009));
//        System.out.println(intToRoman(459));
//        System.out.println(intToRoman(900));
//        System.out.println(intToRoman(99));

        char test[] = "ABAAABCD".toCharArray();
        char pattern[] = "ABC".toCharArray();
        System.out.println(findBrute(test,pattern));

        System.out.println(fib(+ 5));
        System.out.println(fastFib(5));

        System.out.println(changeCount(99));


    }

    public static String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] test = new int[]{2,1};


        String ans = "";
        int last_pos = 0;

        while(num>0){
            for(int i=last_pos;i<values.length;i++){
                if(num>=values[i]){
                    num -= values[i];
                    ans += strs[i];
                    i--;
                    last_pos = i;
                }
            }
        }
        return ans;
    }

    public static int findBrute(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        for (int i = 0; i < n-m ; i++) {
            int k = 0;
            while(k < m && text[i+k] == pattern[k]){
                k++;
            }
            if(k == i){
                return i;
            }
        }
        return -1;
    }

    public static int knuthMorrisPratt(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        int j = 0;
        int k = 0;
        while(j < n){
            if(text[j] == pattern[k]){
                if(k== m-1) return j-m+1;
                j++;
                k++;
            } else if(k > 0){
               // k = fail[k-1];
            } else{
                j++;
            }
        }
        return -1;
    }

    public static int boyerMoore(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        int i = m-1;
        int k = m-1;
        while(i < n){
            if(text[i] == pattern[k]){
                if(k == 0) return i;
                i--;
                k--;
            } else{
               // i += m - Math.min(k, 1 + last.get(text[i]));
                k = m-1;
            }
        }
        return -1;
    }

    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        } else{
            return fib(n-1) + fib(n-2);
        }
    }

    // Dynamic Programming
    public static int fastFib(int n){
        if(n==1|| n ==2){
            return 1;
        }
        int[] fibs = new int[n];
        fibs[1] = 1;
        fibs[2] = 2;
        for (int i = 3; i < n; i++) {
            fibs[i] = fibs[i-1] + fibs[i -2];
        }
        return fibs[n-1] + fibs[n-2];
    }

    public static int[] coins = {1,5,10,25};
    public static int changeCount(int n){
        int[] count = new int[n+1];
        count[0] = 0;
        for (int i = 1; i <= n ; i++) {
            int bestMin = 10000000;
            for (int c: coins) {
                if(i - c >= 0){
                    bestMin = Math.min(bestMin, i + count[i-c]);
                }
            }
            count[i] = bestMin;
        }
        return count[n];
    }

}
