package com.zacisrael;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] test = new int[]{2,2,1,1,1,2,2};
        System.out.println( majorityElement(test));

    }

    public static int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;

    }

    public String defangIPaddr(String address) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < address.length(); i++){
            if(address.charAt(i) == '.'){
                output.append("[.]");
            }
        }
        return output.toString();
    }
}
