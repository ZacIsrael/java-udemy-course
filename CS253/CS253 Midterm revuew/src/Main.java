import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here

        char[] test = new char[]{'a','b','c','s','j','a','b','b','s','e','q','a','a','b', 'a','b','b'};
        char[] pat = new char[]{'a','b','b'};
        System.out.println(findBrute(test,pat));
        char[] test2 = new char[]{'a','a','a','a','a','a','a','a','a','.','.','.','b','a','b','.','.','b','a','a',};
        char[] pat2 = new char[]{'.', '.','b'};
        char[] pat3 = new char[]{'a','a','.', '.'};
        System.out.println(findBrute(test2, pat2));
        System.out.println(findBrute(test2,pat3));

        System.out.println(findBoyerMoore(test, pat));
        System.out.println(findBoyerMoore(test2, pat2));
        System.out.println(findBoyerMoore(test2, pat3));




    }

    public static int findBrute(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        for (int i = 0; i <= n-m ; i++) {
            int k = 0;
            while (k < m && text[i+k] == pattern[k]){
                k++;
            }
            if(k == m){
                return i;
            }
        }
        return -1;
    }

//    public static int knuthMorrisPratt(char[] text, char[] pattern){
//        int n = text.length;
//        int m = pattern.length;
//        int j = 0;
//        int k = 0;
//        while (j<n){
//            if(text[j] == pattern[k]){
//                if(k==m-1){
//                    return j-m + 1;
//                }
//                j++;
//                k++;
//            } else if(k > 0){
//                k = fail[k-1];
//            } else{
//                j++;
//            }
//        }
//        return -1;
//    }

    public static int[][] matrixChain(int[] d){
        int n = d.length -1;
        int[][] N = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                int b = i +j;
                N[j][b] = Integer.MAX_VALUE;
                for (int k = j; k < b; k++) {
                    N[j][b] = Math.min(N[j][b], N[j][k] + N[k+1][b] + d[j] *d[k+1]*d[b+1]);
                }

            }
        }
        return N;
    }

    public static int findBoyerMoore(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        if(m == 0) return 0;
        Map<Character, Integer> last = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            last.put(text[i], -1); // set -1 as default for all text characaters
        }
        for (int k = 0; k < m; k++) { // rightmost occurrence in pattern is last
            last.put(pattern[k], k);
            // start with the end of the pattern aligned at index m-1 of the text
        }

        int i = m -1; // an index into the text
        int k = m-1; // an index into the pattern

        while (i < n){

            if(text[i] == pattern[k]){ // if the character at the current index match in both the pattern and the text,
                if(k == 0)return i;  // iterated through the pattern and there is a match, return the index i
                i--; // decrement to the previous character in the text
                k--; // decrement to the previous character in the pattern
            } else{
                i += m - Math.min(k, 1+last.get(text[i]));
                k = m-1; // restart at the end of the patter
            }
        }
        return -1; // return -1 if the pattern is not in the text
    }
}
