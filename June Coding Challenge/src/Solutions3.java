import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solutions3 {

    public static void main(String[] args) {

        // System.out.println(calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));

//        System.out.println(singleNumber(new int[]{2,2,3,2}));
//        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
//        System.out.println(singleNumber(new int[]{0,0,0,5}));

//        System.out.println(numTrees(3)); // 5
//        System.out.println(numTrees(4)); // 14
//        System.out.println(numTrees(5)); // 42
//        System.out.println(numTrees(6)); // 132

//        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
//        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(numSquares(12)); // 3: 4 + 4 + 4
        System.out.println(numSquares(13)); // 2: 9 + 4:
        System.out.println(numSquares(16)); // 1: 16
        System.out.println(numSquares(29)); // 2: 25 + 4
        System.out.println(numSquares(30)); // 3: 25 + 4 + 1
        System.out.println(numSquares(57)); // 3: 49 + 4 + 4
        System.out.println(numSquares(48)); // 3: 16 + 16 + 16
    }


    public static int numSquares(int n) {
        PriorityQueue<Integer> answers = new PriorityQueue<>();
        int count = 0;

        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int squared = i * i;
            squares.add(squared);
        }
        int i = squares.size() - 1;
        int track = 0;

        for (int j = i; j >= 0; j--) {
            if(n % squares.get(j) == 0){
                answers.add(n / squares.get(j));
            }
            track = squares.get(j);
            count++;
            for (int k = i; k >= 0; k--) {
                if (track + squares.get(k) <= n) {
                    track += squares.get(k);
                    count++;
                    k++;
                }
            }
            if (track == n) {
                answers.add(count);
                count = 0;
                track = 0;
            } else {
                count = 0;
                track = 0;
            }
        }
        return answers.poll();
    }

    public static int findDuplicate(int[] nums) {

        int answer = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    answer = nums[i];
                    break;
                }
            }
            if (answer == nums[i]) {
                break;
            }
        }
        return answer;
    }

    public static int numTrees(int n) {

        int count = 0;
        return count;
    }

    public static int singleNumber(int[] nums) {

        int len = nums.length;
        if (len == 1) return nums[0];
        int curr = nums[0];
        ArrayList<Integer> check = new ArrayList<>();
        check.add(nums[0]);
        for (int i = 0; i < len; i++) {
            if (i == 0) continue;
            if (!check.contains(nums[i])) {
                curr = nums[i];
                check.add(nums[i]);
            }

        }

        return curr;
    }

    public static int calculateMinimumHP(int[][] dungeon) {

        int path = 7;
        int start = dungeon[0][0];
        path += start;
        boolean wasLast = false;
        for (int row = 0; row < dungeon.length; row++) {
            for (int col = 0; col < dungeon[row].length; col++) {
                if (wasLast)
                    System.out.println("At index [" + row + "][" + col + "] the number is " + dungeon[row][col]);
                if (row == 0 && col == 0) continue;
                if (path + dungeon[row][col] > 0) {
                    path += dungeon[row][col];
                    if (col == dungeon[row].length - 1) {
                        wasLast = true;
                    }
                } else {
                    break;
                }

            }
        }
        return path;
    }
}
