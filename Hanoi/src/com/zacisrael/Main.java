package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("----- Towers of Hanoi (version 1) -----");
        hanoi(1, "A", "B", "C");

        System.out.println("----- Towers of Hanoi (version 2) -----");
        hanoi(2, "A", "B", "C");

        System.out.println("----- Towers of Hanoi (version 3) -----");
        hanoi(3, "A", "B", "C");

        System.out.println("----- Towers of Hanoi (version 4) -----");
        hanoi(4, "A", "B", "C");

        System.out.println("----- Towers of Hanoi (version 5) -----");
        hanoi(5, "A", "B", "C");



        // Number of lines / moves = the previous number of moves * 2 + 1
        // e.g: 3 will print 7 lines because 2 printed 3 lines and 3 * 2 + 1 = 7


    }
    // Towers of Hanoi
    // Moves n disks from rod "source" to rod "target" using a temporary rod "temp"
    public static void hanoi(int n, String source, String target, String temp){
        if(n == 1){
            // base case: just move 1 disk from source to target
            System.out.println("Move from " + source + " to " + target);
        }
        else{
            // recursive case
            // 1. move n - 1 disks from source ro temporary
            hanoi(n-1, source, temp, target);
            // 2. move 1 disk from source to target
            hanoi(1, source, target, temp);
            // 3. move n-1 disks from temporary to target
            hanoi(n-1, temp, target, source);
        }
    }
}
