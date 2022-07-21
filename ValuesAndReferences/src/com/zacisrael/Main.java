package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
       /*  int a = 5;
        int b = 7;
        System.out.println("a: " + a + ", b: " + b); // 5, 7
        a = b;
        System.out.println("a: " + a + ", b: " + b); // a will change to b because b is larger
        b = 8;
        System.out.println("a: " + a + ", b: " + b); // a will stay at 7 because that is what it was most recently defined as
                                                    // b will be 8 because we defined it again
        System.out.println(a*b);
        int[] x = new int [3];
        int[] y = new int [3];
        x[0] = 5;
        y[0] = 7;
        System.out.println("x[0]: " + x[0] + " , y[0] : " + y[0]); // will print out 5 , 7
        x = y; // x will always equal y from now on until we code otherwise
        System.out.println("x[0]: " + x[0] + " , y[0] : " + y[0]); // will print out 7, 7
        y[0] = 8;
        System.out.println("x[0]: " + x[0] + " , y[0] : " + y[0]); // both will increase to 8 since this is an element
                                                                    // in an array and not a int or double

        System.out.println(y[0] * x[0]);

       int k = 10;
        System.out.println(k);

        f(k);
        System.out.println(k); // Will print out 10 because the value of k above is not the same as the k in f
                                // also, the method is void , k is also an int

        int[] h = new int[3];
        h[0] = 10;
        System.out.println(h[0]);
        g(h);
        System.out.println(h[0]); // will print out 11 because the element h[0] is replaced with the new value of h[0]
        */
       int[] t = new int[10];
       t[0] = 5;
       t[1] = 3;
       t[2] = 7;
       t[3] = 9;

        insert(t, 4, 10, 2);

    }
    public static void f(int k){
        k = k + 1;
    }

    public static void g(int[] h){
        h[0] = h[0] + 1;
    }
    public static void insert(int[] a, int n, int x, int pos){

        for (int i = n-1; i >= pos; i--){
            a[i + 1] = a[i];
        }
        a[pos] = x;
    }


}
