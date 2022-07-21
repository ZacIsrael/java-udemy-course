package com.zacisrael;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//
//        System.out.println("Optimal Solution");
//        System.out.println("When n = 9, the answer is "+arrangeCoins(9)); // 3
//        System.out.println("When n = 10, the answer is "+arrangeCoins(10)); // 4
//        System.out.println("When n = 11, the answer is "+arrangeCoins(11)); // 4
//        System.out.println("When n = 12, the answer is "+arrangeCoins(12)); // 4
//        System.out.println("When n = 13, the answer is "+arrangeCoins(13)); // 4
//        System.out.println("When n = 14, the answer is "+arrangeCoins(14)); // 4
//        System.out.println("When n = 15, the answer is "+arrangeCoins(15)); // 5
//        System.out.println("When n = 51, the answer is "+arrangeCoins(51)); //
//        System.out.println("When n = 92, the answer is "+arrangeCoins(92)); //
//        System.out.println("When n = 77, the answer is "+arrangeCoins(77)); //
//        System.out.println("When n = 1000, the answer is "+arrangeCoins(1000));
//        System.out.println("When n = 10,000 , the answer is "+arrangeCoins(10000));

//
//
//        System.out.println("\nMy solution");
//        System.out.println("When n = 9, the answer is "+ arrangeCoins2(9)); // 3
//        System.out.println("When n = 10, the answer is "+arrangeCoins2(10)); // 4
//        System.out.println("When n = 11, the answer is "+arrangeCoins2(11)); // 4
//        System.out.println("When n = 12, the answer is "+arrangeCoins2(12)); // 4
//        System.out.println("When n = 13, the answer is "+arrangeCoins2(13)); // 4
//        System.out.println("When n = 14, the answer is "+arrangeCoins2(14)); // 4
//        System.out.println("When n = 15, the answer is "+arrangeCoins2(15)); // 5
//        System.out.println("When n = 51, the answer is "+arrangeCoins2(51)); //
//        System.out.println("When n = 92, the answer is "+arrangeCoins2(92)); //
//        System.out.println("When n = 77, the answer is "+arrangeCoins2(77)); //
//        System.out.println("When n = 1000, the answer is "+arrangeCoins2(1000));
//        System.out.println("When n = 10,000 , the answer is "+arrangeCoins(10000));
//        System.out.println(nthUglyNumber(10)); // 12
//        System.out.println(nthUglyNumber(11)); // 15
//        System.out.println(nthUglyNumber(12)); // 16
//        System.out.println(nthUglyNumber(13)); // 18
//        System.out.println(nthUglyNumber(14)); // 20
//        System.out.println(nthUglyNumber(15)); // 24
//        System.out.println(nthUglyNumber(25)); // 54

        // System.out.println(hammingDistance(1,4));
//        printArr(plusOne(new int[]{1,2,3}));
//        printArr(plusOne(new int[]{4,3,2,1}));
//        printArr(plusOne(new int[]{1,0,0,1}));
//        printArr(plusOne(new int[]{5,0,7}));
//        printArr(plusOne(new int[]{9}));
//        printArr(plusOne(new int[]{5,0,7}));
//        printArr(plusOne(new int[]{9,9,9,9,9,9}));
//        printArr(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
//        printArr(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}));
//        printArr(plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
//        printArr(plusOne(new int[]{5, 6, 2, 0, 0, 4, 6, 2, 4, 9}));
//        printArr(plusOne(new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3}));
//        printArr(plusOne(new int[]{5,2,2,6,5,7,1,9,0,3,8,6,8,6,5,2,1,8,7,9,8,3,8,4,7,2,5,8,9}));
//        printArr(plusOne(new int[]{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
//                9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9
//                ,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}));


        // System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

//        System.out.println(subsets(new int[]{1, 2, 3}));
////        System.out.println(subsets(new int[]{0, 5, 7}));
////        System.out.println(subsets(new int[]{1, 2, 3, 4}));

        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer n:nums) {
            if(!hashMap.containsKey(n)){
                hashMap.put(n, 0);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], +1);
            }
        }

        int[] finalAnswer = new int[k];
        Arrays.fill(finalAnswer, -1);

        for (int i = 0; i < hashMap.size(); i++) {
           answer.add(hashMap.get(i));
        }
        Collections.sort(answer);
        for (int i = answer.size()-1; i >= 0; i--) {
            finalAnswer[i] = answer.get(i);
            if(finalAnswer[k-1] != -1){
                break;
            }
        }


        return finalAnswer;
    }

    public static double myPow(double x, int n) {
        if(x == -1 && (n % 2 == 0 && n != 0)){
            return 1;
        }
        if(x == -1 && (n % 2 == 1)){
            return -1;
        }
        if (x == 1) {
            return 1;
        }
        if (n == Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        double answer = 1;
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                answer /= x;
            }
            return answer;
        }
        for (int i = 0; i < n; i++) {
            answer *= x;
        }
        return answer;
    }


    public static int reverseBits(int n) {

        String nString = Integer.toString(n);
        String answer = "";

        for (int i = nString.length() - 1; i >= 0; i--) {
            answer += nString.charAt(i);
        }


        return Integer.parseInt(answer);
    }

    public static List<List<Integer>> subsets(int[] nums) {

        int size = nums.length;
        ArrayList<Integer> numsToList = new ArrayList<>();
        for (int num : nums) {
            numsToList.add(num);
        }
        int sizeOfPowerSet = (int) Math.pow(2, size);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < sizeOfPowerSet; i++) {
            String bin = getPaddedBinString(i, size);  // Get binary representation of this index
            List<Integer> list = getList(bin, numsToList); // gets subList
            answer.add(list); // adds this list to the list of answers
        }
        return answer;
    }

    private static List<Integer> getList(String bin, List<Integer> origValues) {
        List<Integer> answer = new ArrayList<>();
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                int val = origValues.get(i);
                answer.add(val);
            }
        }
        return answer;
    }

    private static String getPaddedBinString(int i, int size) {
        String bin = Integer.toBinaryString(i);
        bin = String.format("%0" + size + "d", Integer.parseInt(bin));
        return bin;
    }

//        ArrayList<Integer> emptySet = new ArrayList<>();
//        List<List<Integer>> answer = new ArrayList<>();
//        answer.add(emptySet); // The empty set is always included in the power set
//
//        ArrayList<Integer> numsToArrayList = new ArrayList<>();
//
//        for (Integer curr : nums) {
//            numsToArrayList.add(curr); // adds the set containing all of the integer in the nums array
//
//            // All sets containing only one of the elements in it is a part of the power set.
//            ArrayList<Integer> currNum = new ArrayList<>();
//            currNum.add(curr);
//            answer.add(currNum);
//        }
//
//        answer.add(numsToArrayList);
//        for (Integer num : nums) {
//
//            for (int i = 0; i < nums.length; i++) {
//                if (num == nums[i]) {
//                    continue;
//                }
//                ArrayList<Integer> curr = new ArrayList<>();
//                curr.add(num);
//                curr.add(nums[i]);
//                answer.add(curr);
//            }
//        }
//        return removeDuplicates(answer);
    // }


//    public static List<List<Integer>> removeDuplicates(List<List<Integer>> arr) {
//
//        arr.forEach(curr -> Collections.sort(curr));
//        List<List<Integer>> answer = new ArrayList<>();
//
//        for (int i = 0; i < arr.size(); i++) {
//            if(!answer.contains(arr.get(i))){
//                answer.add(arr.get(i));
//            }
//        }
//
//
//        return answer;
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> zeroAnswers = new ArrayList<>();

        for (int num : nums) {

            for (int current : nums) {
                ArrayList<Integer> curr = new ArrayList<>();
                for (int third : nums) {
                    if (current == third && third == num && num == current) {
                        continue;
                    }
                    if (curr.size() == 3) {
                        break;
                    }
                    if (current + num + third == 0) {
                        curr.add(num);
                        curr.add(current);
                        curr.add(third);
                        zeroAnswers.add(curr);
                        break;
                    }
                }
                if (curr.size() == 3) {
                    break;
                }
            }
        }


        return zeroAnswers;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        int track = 0;
        List<List<Integer>> zeroAnswers = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> currList = new ArrayList<Integer>();
            int tracker = nums[i];
            currList.add(tracker);
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                tracker += nums[j];
                currList.add(nums[j]);
                if (currList.size() == 3) {
                    break;
                }
            }
            if (tracker == 0) {
                zeroAnswers.add(currList);
            }
        }

        return zeroAnswers;

    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            digits[len - 1] = digits[len - 1] + 1;
            return digits;
        } else {
            if (len <= 9) {
                String answer = "";
                for (int i = 0; i < digits.length; i++) {
                    answer += digits[i];
                }
                int num = Integer.parseInt(answer);
                num += 1;
                String added1 = String.valueOf(num);
                int[] answerArray = new int[added1.length()];
                for (int i = 0; i < added1.length(); i++) {
                    answerArray[i] = Integer.parseInt(added1.charAt(i) + "");
                }
                return answerArray;
            } else if (len >= 10 && len <= 16) {
                return plusOneGreaterThan9(digits);
            } else {
                return plusOneGreaterThan16(digits);
            }
        }
    }

    public static int[] plusOneGreaterThan16(int[] digits) {

        boolean newWholeNumber = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    newWholeNumber = true;
                    break;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if (newWholeNumber) {
            int[] answer = new int[digits.length + 1];
            for (int i = 0; i < answer.length; i++) {
                if (i == 0) {
                    answer[i] = 1;
                } else {
                    answer[i] = 0;
                }
            }
            digits = answer;
        }
        return digits;
    }

    public static int[] plusOneGreaterThan9(int[] digits) {
        String answer = "";
        for (int i = 0; i < digits.length; i++) {
            if (i == 1) {
                answer += "." + digits[i];
            } else {
                answer += digits[i];
            }
        }
        String zeros = "0.";
        for (int i = 0; i < answer.length() - 3; i++) {
            zeros += "0";
        }
        zeros += "1";
        double ans = Double.parseDouble(answer);
        double added = Double.parseDouble(zeros);
        ans += added;

        String added1 = String.valueOf(ans);
        String realNum = "";
        if (added1.length() != digits.length + 2 || added1.length() != digits.length + 1) {
            int i = added1.length();
            while (i != digits.length + 2) {
                added1 += "0";
                i++;
            }
        }
        boolean isFilledWith9 = true;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                isFilledWith9 = false;
                break;
            }
        }
        if (!isFilledWith9) {
            added1 = added1.substring(0, added1.length() - 1);
        }
        for (int i = 0; i < added1.length(); i++) {
            if (added1.charAt(i) != '.') {
                realNum += added1.charAt(i);
            }
        }
        int realLen = realNum.length();
        int[] numbers = new int[realLen];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.valueOf(realNum.charAt(i) + "");
        }
        return numbers;
    }
//    public static int[] plusOne2(int[] digits) {
//        if (digits.length <= 9) {
//            String answer = "";
//            for (int i = 0; i < digits.length; i++) {
//                answer += digits[i];
//            }
//            int num = Integer.parseInt(answer);
//            num += 1;
//            String added1 = String.valueOf(num);
//            int[] answerArray = new int[added1.length()];
//            for (int i = 0; i < added1.length(); i++) {
//                answerArray[i] = Integer.parseInt(added1.charAt(i) + "");
//            }
//            return answerArray;
//        } else {
//            String answer = "";
//            for (int i = 0; i < digits.length; i++) {
//                if (i == 1) {
//                    answer += "." + digits[i];
//                } else {
//                    answer += digits[i];
//                }
//            }
//            String zeros = "0.";
//            for (int i = 0; i < answer.length() - 3; i++) {
//                zeros += "0";
//            }
//            zeros += "1";
//            double ans = Double.parseDouble(answer);
//            double added = Double.parseDouble(zeros);
//            ans += added;
//
//            String added1 = String.valueOf(ans);
//            String realNum = "";
//            if (added1.length() != digits.length + 2 || added1.length() != digits.length + 1) {
//                int i = added1.length();
//                while (i != digits.length + 2) {
//                    added1 += "0";
//                    i++;
//                }
//            }
//            boolean isFilledWith9 = true;
//
//            for (int i = 0; i < digits.length; i++) {
//                if (digits[i] != 9) {
//                    isFilledWith9 = false;
//                    break;
//                }
//            }
//            if (!isFilledWith9) {
//                added1 = added1.substring(0, added1.length() - 1);
//            }
//            for (int i = 0; i < added1.length(); i++) {
//                if (added1.charAt(i) != '.') {
//                    realNum += added1.charAt(i);
//                }
//            }
//            int realLen = realNum.length();
//            int[] numbers = new int[realLen];
//            for (int i = 0; i < numbers.length; i++) {
//                numbers[i] = Integer.valueOf(realNum.charAt(i) + "");
//            }
//            return numbers;
//        }
//    }

    public static void printArr(int[] arr) {
        String array = "{";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                array += arr[i] + "}";
            } else {
                array += arr[i] + ", ";
            }
        }
        System.out.println(array);
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        String binX = Integer.toBinaryString(x);
        String binY = Integer.toBinaryString(y);
        int xLen = binX.length();
        int yLen = binY.length();

        int length = xLen;
        int remaining = 0;
        if (xLen > yLen) {
            remaining = xLen - yLen;
            String addedZeros = "";
            for (int i = 0; i < remaining; i++) {
                addedZeros += "0";
            }
            binY = addedZeros + binY;
        } else if (xLen < yLen) {
            remaining = yLen - xLen;
            String addedZeros = "";
            for (int i = 0; i < remaining; i++) {
                addedZeros += "0";
            }
            binX = addedZeros + binX;
            length = yLen;
        }

        for (int i = 0; i < length; i++) {
            if (binY.charAt(i) != binX.charAt(i)) {
                count++;
            }
        }
        return count;
    }


    ArrayList<Integer> uglyNumbers = new ArrayList<Integer>();

    public static int nthUglyNumber(int n) {

        int integers = 1;
        int untilN = 1;


        return integers;
    }

    public static int nthUglyNumber2(int n) {

//        int count = 1;
//        int i = 1;
//
//        while (i < n) {
//            if ((((count % 2 == 0 && count % 3 == 0)) || ((count % 2 == 0) && count % 5 == 0)
//                    || ((count % 3 == 0) && count % 5 == 0)
//                    || (count % 2 == 0 && count % 3 == 0 && count % 5 == 0)) || count == 1
//                    || count == 2 || count == 3 || count == 5
//                    || Math.sqrt(count) % 2 == 0 || Math.sqrt(count) % 3 == 0 || Math.sqrt(count) % 5 == 0) {
//                i++;
//                if (i == n) {
//                    break;
//                }
//                count++;
//            } else {
//                count++;
//            }
//
//        }
//        return count;
        return -1;
    }

    public static int arrangeCoins(int n) {

        long sqrtOfNtimesTwo = (long) Math.sqrt(2 * (long) n);
        long sum = sqrtOfNtimesTwo * (sqrtOfNtimesTwo + 1) / 2;
        if (sum > n) return (int) sqrtOfNtimesTwo - 1;
        return (int) sqrtOfNtimesTwo;

    }

    public static int arrangeCoins2(int n) {

        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        int countLeft = n;
        for (int i = 1; i <= countLeft; i++) {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                curr.add(-1);
            }
            hashSet.add(curr);
            countLeft -= i;
        }

        int largest = 0;

        for (ArrayList<Integer> curr : hashSet) {
            if (curr.size() > largest) {
                largest = curr.size();
            }
        }

        return largest;
    }
}
