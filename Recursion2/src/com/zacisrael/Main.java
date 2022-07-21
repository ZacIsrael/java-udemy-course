package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(addDigits(5));
        System.out.println(addDigits(37));
        System.out.println(addDigits(1325));

        int[] x1 = {};
        int[] x2 = {5};
        int[] x3 = {2,1,3};
        System.out.println(sum(x1,0));
        System.out.println(sum(x2,3));
        System.out.println(sum(x3, 2));



    }
    // sums all the digits of n (n>= 0)
    public static int addDigits(int n){
        if(n < 10){ // base case: one digit
            return n;
        } else{
            return (n % 10) + addDigits(n/10);
        }

    }
    // sums the first n elements of array x (0 <= n <= x.length)
    public static int sum(int[] x, int n){
        if( n == 0){
            return 0;
        }
        else{
            return x[n-1] + sum(x, n-1);
        }
    }
    // alternative version of sum method
    public static int sum2(int[] x, int n, int start){
        if(start >= n){
            return 0;
        }
        else{
            return x[start] + sum2(x, n, start + 1);
        }
    }

    // counts the number of odd elements in x
    public static int oddCount(int[] x, int n){
        if(n == 0){
            return 0;
        }
        else if (x[n-1] % 2 == 1){ // odd
            return 1 + oddCount(x, n-1);
        }
        else{ // even
            return oddCount(x, n - 1);
        }
    }

    // alternative version of "oddCount" method
    public static int oddCount2(int[] x, int n) {
        if (n == 0){
            return 0;
        }
        else{
            return x[n-1] % 2 + oddCount2(x, n-1);
        }
    }

    // returns the minimum element in x
    // assume that x is not empty
    public static int min(int[] x, int n){
        if(n == 1){
            return x[0];
        }
        else{
            int k = min(x, n-1); // This will recursively calculate the minimum of all the elements except for the last element & store it into k
            if(x[n-1] < k){
                return x[n-1];
            }
            else{
                return k;
            }
        }
    }




}
