package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(subtractProductAndSum(234));


    }

    public static int subtractProductAndSum(int n) {
        return product(n) - sum(n);
    }

    public static int sum(int n){
        String test = Integer.toString(n);
        int counter = 0;
        for(int i = 0; i < test.length(); i++){
            int add = Character.getNumericValue(test.charAt(i));
            counter+= add;
        }
        return counter;
    }
    public static int product(int n){
        String test = Integer.toString(n);
        int counter = 1;
        for(int i = 0; i < test.length(); i++){
            int mult = Character.getNumericValue(test.charAt(i));
            counter *= mult;
        }

        return counter;
    }

    public static int findNumbers(int[] nums) {
        int counter = 0;
        for(int i = 0; i < nums.length; i++){

            String shortNum = Integer.toString(nums[i]);
            if(shortNum.length() % 2 == 0){
                counter++;
            }
        }
        return counter;
    }

    public static int divide(int dividend, int divisor) {
        int counter = 0;
        int firstDividend = dividend;
        int firstDivisor = divisor;
        if(divisor == dividend){
            return 1;
        }
        if(divisor == -dividend || -divisor == dividend ){
            return -1;
        }

        if(divisor < 0){
            divisor = -divisor;
        }
        if(dividend < 0){
            dividend = -dividend;
        }

        
        for(int i = 0; i < dividend; i += divisor){
            if(i + divisor < dividend) {
                counter++;
            }
        }
        if((firstDivisor < 0 && firstDividend > 0) ||(firstDivisor > 0 && firstDividend < 0) ){
            return -counter;
        } else{
            return counter;
        }
    }

    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int answer = 0;
        for(int i = 0; i < haystack.length(); i++){
            if(i + needleLength > haystack.length()){
                return -1;
            }
            String needleSub = haystack.substring(i, i+needleLength);
            if(needleSub.equals(needle)){
                answer = i;
                break;
            } else{
                return -1;
            }
        }
        return answer;
    }

    public static int reverse(int x) {

        String s = Integer.toString(x);

        if (x < 0) {
            s = s.substring(1);
        }
        String answer = "";

        for (int i = s.length() - 1; i > -1 ; i--) {
            String testChar = s.charAt(i) + "";
            answer += testChar;
        }


        if(answer.length() >= 10){
            throw new NumberFormatException("The int is too big");
        }

        int lastAnswer = Integer.valueOf(answer);
        if(x < 0){
            lastAnswer = - lastAnswer;
        }
        return lastAnswer;
    }


}
