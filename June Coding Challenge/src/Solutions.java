

import java.util.*;

public class Solutions {

    public static void main(String[] args) {

//        moveZeroes(new int[]{0, 1, 0, 3, 12});
//        moveZeroes(new int[]{0,0,1});
//        moveZeroes(new int[]{1,0,0,1});

//        ListNode listNode = new ListNode(4);
//        ListNode second = new ListNode(5);
//        ListNode third = new ListNode(1);
//        ListNode fourth = new ListNode(9);
//
//        listNode.next = second;
//        second.next = third;
//        third.next = fourth;
//
//        System.out.println(listNode);
//        deleteNode(second);
//        System.out.println(listNode);


//        System.out.println( twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
//        System.out.println( twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));


        //reverseString(new char[]{'h', 'e','l','l', 'o'});

        //  reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});

//        System.out.println(change(5, new int[]{1,2,5}));
//        System.out.println(change(3, new int[]{2}));
//        System.out.println(change(10, new int[]{10}));

//        System.out.println(isPowerOfTwo(1)); // true
//        System.out.println(isPowerOfTwo(16)); // true
//        System.out.println(isPowerOfTwo(218)); // false
//        System.out.println(isPowerOfTwo(256)); // true
//        System.out.println(isPowerOfTwo(512)); // true
//        System.out.println(isPowerOfTwo(346)); // false
//        System.out.println(isPowerOfTwo(48)); // false
//        System.out.println(isPowerOfTwo(0));

//        System.out.println(isSubsequence("abc", "ahbgdc")); // true
//        System.out.println(isSubsequence("axc", "ahbgdc")); // false
//
//        System.out.println(isSubsequence("zacchaeus", "zhhachhfnchaeus")); // true
//        System.out.println(isSubsequence("zacchaeus", "zhhachhfnchaeusm")); // true
//        System.out.println(isSubsequence(" ", "ahbgdc")); // false

//        System.out.println(searchInsert(new int[]{1,3,5,6}, 5)); // 2
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 2)); // 1
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 7)); // 4
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 0)); // 0

        //     sortColors(new int[]{2,0,2,1,1,0});

//        System.out.println(largestDivisibleSubset(new int[]{1,2,3}));
//        System.out.println(largestDivisibleSubset(new int[]{1,2,4,8}));
//        System.out.println(largestDivisibleSubset(new int[]{1}));
//        System.out.println(largestDivisibleSubset(new int[]{1,2,4,8,16}));
//        System.out.println(largestDivisibleSubset(new int[]{546, 669}));
//        System.out.println(largestDivisibleSubset(new int[]{3,4,16,8}));
//        System.out.println(largestDivisibleSubset(new int[]{2,3,4,8}));

        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 1));
        System.out.println(findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},
                0, 2, 0));


    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[][] arr = new int[n][n];
        for (int[] curr: flights) {
            arr[curr[0]][curr[1]] = curr[2];
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.offer(new int[]{0, src, K+1});

        while (!heap.isEmpty()){
            int[] curr = heap.poll();
            int price = curr[0], dest = curr[1], remainStops = curr[2];

            if(dest == dst) return price;

            if(remainStops > 0){
                for (int i = 0; i < n; i++) {
                    if(arr[dest][i] > 0){
                        heap.offer(new int[]{price + arr[dest][i], i, remainStops-1});
                    }
                }
            }

        }
        return -1;
//        int distance = 0;
//        int len = flights.length;
//        for (int i = 0; i < len; i++) {
//            if((K == 0) && ((flights[i][0] == src && flights[i][1] == dst) ||
//                    (flights[i][0] == dst && flights[i][1] == src))){
//                    return flights[i][2];
//            }
//            for (int j = 0; j < flights[i].length; j++) {
//               // System.out.println("Coordinate [" + i + "][" + j + "] = " + flights[i][j] + "\n");
//
//
//            }
//        }
//
//        return -1;
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {


        int len = nums.length;

        if (len == 0) return new ArrayList<>();

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int[] parent = new int[len];
        Arrays.fill(parent, -1);

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {

                if ((nums[i] % nums[j] == 0) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }

        int max = dp[0], pos = 0;

        for (int i = 1; i < len; i++) {
            if (dp[i] > max) {
                max = dp[i];
                pos = 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (pos != -1) {
            list.add(nums[pos]);
            pos = parent[pos];
        }

        Collections.reverse(list);
        return list;

//        List<Integer> list2 = new ArrayList<>();
//        List<Integer> list3 = new ArrayList<>();
//        int len = nums.length;
//        if(len == 0) return list2;
//        if(len == 1){
//            list2.add(nums[0]);
//            return list2;
//        }
//
//
//        for (int i = 0; i < len; i++) {
//          if((nums[i] % 2 == 0) || (2 % nums[i] == 0)){
//              list2.add(nums[i]);
//          }
//            if((nums[i] % 3 == 0) || (3 % nums[i] == 0)){
//                list3.add(nums[i]);
//            }
//        }
//
//        if(list2.isEmpty()){
//            list2.add(nums[0]);
//        }
//        if(list3.isEmpty()){
//            list3.add(nums[0]);
//        }
//        if(list2.size() > list3.size()){
//            Collections.sort(list2);
//            return list2;
//        } else{
//            Collections.sort(list3);
//            return list3;
//        }

        /*

        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return list;
        if(len == 1){
            list.add(nums[0]);
            return list;
        }


        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if(i == 0){
                continue;
            }
            if((curr % nums[i-1] == 0) || (nums[i-1] % curr == 0)){
                int prev = nums[i-1];
                if(!list.contains(prev)){
                    list.add(prev);
                }
                if(!list.contains(curr)){
                    list.add(curr);
                }
            }
        }

        if(list.isEmpty()){
            list.add(nums[0]);
        }
        Collections.sort(list);
        return list;
        */
    }

    public static void sortColors(int[] nums) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            if (nums[i] == 1) {
                count1++;
            }
            if (nums[i] == 2) {
                count2++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if ((i >= count0) && (i < count0 + count1)) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

    }

    public static int searchInsert(int[] nums, int target) {

        int index = 0;
        int len = nums.length;
        if (nums[0] > target) return 0;
        if (nums[len - 1] < target) return len;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
            if ((i > 0) && (nums[i] > target && nums[i - 1] < target)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
        int sIndex = 0;
        int tIndex = 0;
        while (tIndex < t.length()) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;

                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;
        }
        return false;

//        int sLen = s.length();
//        if(s.equals(t)) return true;
//        if(sLen == 1 && t.contains(s)) return true;
//        if(sLen == 1 && !t.contains(s)) return false;
//        if(s.isEmpty()) return true;
//        if(t.isEmpty()) return false;
//
//
//        for (int i = 0; i < t.length(); i++) {
//            if(sLen == t.length() && !s.equals(t)){
//                return false;
//            }
//
//            if((!s.contains(t.charAt(i)+"")) || (s.contains(t.charAt(i)+"") && s.charAt(i) != t.charAt(i))){
//                t = removeChar(t, i);
//                i--;
//            }
//
//        }
//        if(s.equals(t)){
//            return true;
//        }
//        return false;
    }

    public static String removeChar(String s, int index) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (i != index) {
                answer += s.charAt(i);
            }
        }
        return answer;
    }

    public static boolean isPowerOfTwo(int n) {

        if (n < 1) return false;
        if (n == 1) return true;

        if (n % 2 == 0) {
            return isPowerOfTwo(n / 2);
        }

        return false;
    }

    public static int change(int amount, int[] coins) {

//        int len = coins.length;
//        int[][] answer = new int[len+1][amount+1];
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j <= amount ; j++) {
//                if(j == 0) answer[i][j] =1;
//                else if(i == 0) answer[i][j] = 0;
//                else{
//                    answer[i][j] = answer[i-1][j] + (j-coins[i-1] < 0? 0: answer[i][j-coins[i-1]]);
//                }
//            }
//        }
//        return answer[coins.length][amount];
        return -1;
    }

    public static int[][] reconstructQueue(int[][] people) {


        List<int[]> result = new ArrayList<>();

        Arrays.sort(people, (y, z) -> {
            return (y[0] == z[0] ? y[1] - z[1] : z[0] - y[0]);
        });

        for (int[] x : people) result.add(x[1], x);

        return result.toArray(new int[people.length][2]);
    }

    public static void reverseString(char[] s) {

        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            swap(i, len - 1 - i, s);
        }

    }

    public static void swap(int i, int j, char[] s) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

    }


    public static int twoCitySchedCost(int[][] costs) {

        int len = costs.length;
        //Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));

        int answer = 0;
        for (int i = 0; i < len / 2; ++i) {
            answer += costs[i][0];
        }
        for (int i = len / 2; i < len; ++i) {
            answer += costs[i][1];
        }
        return answer;

//        int sum = 0;
//        PriorityQueue<Integer> sumA = new PriorityQueue<Integer>();
//        PriorityQueue<Integer> sumB = new PriorityQueue<Integer>();
//        int len = costs.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < costs[i].length; j++) {
////                if(i < len/ 2){
////                    sum += costs[i][0];
////                } else{
////                    sum += costs[i][1];
////                }
////                if(costs[i][0] < costs[i][1] && sumA.size() != len/2){
////                    sumA.add(costs[i][0]);
////                    break;
////                } else{
////                    if(sumB.size() == costs.length/2){
////                        sumA.add(costs[i][0]);
////                        break;
////                    }
////                    sumB.add(costs[i][1]);
////                    break;
////                }
//            }
//        }

//        int sizeOfA = sumA.size();
//        int sizeOfB = sumB.size();
//        for (int i = 0; i < sizeOfA; i++) {
//            sum += sumA.poll();
//        }
//        for (int i = 0; i < sizeOfB; i++) {
//            sum+= sumB.poll();
//        }
        // return sum;
    }

    public static void deleteNode(ListNode node) {

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }


    public static void moveZeroes(int[] nums) {

        int length = nums.length;
        if (nums.length == 1) return;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                if ((i != length - 1) && (nums[i + 1] == 0) && (i + 1 != length - 1)) {
                    swap(i + 1, i + 2, nums);
                }

                int j = i;
                while (j < length - 1) {
                    swap(j, j + 1, nums);
                    j++;
                }

            }


        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
