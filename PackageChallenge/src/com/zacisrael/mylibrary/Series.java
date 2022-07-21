package com.zacisrael.mylibrary;

public class Series {


    public static long nSum(int n){
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += n;
        }
        return result;
    }

    public static long factorial(int n){
        if(n == 0){
            return 1;
        } else{
            return n * factorial(n -1);
        }
    }
    public static long fibonacci(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }
        long nMinus1 = 1;
        long nMinus2 = 0;
        long fib = 0;
        for (int i = 1; i <n ; i++) {
            fib = (nMinus2 + nMinus1);
            nMinus2 = nMinus1;
            nMinus1 = fib;
        }
        return fib;
    }
}
