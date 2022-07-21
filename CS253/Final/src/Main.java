import java.util.*;

public class Main {
    /**
     * Design a dynamic programming algorithm in pseudo code for the following problem: Given  a  number W and n items  with
     * weights w1, w2, . . . , wn,  find  a  combination of those items that maximizes the total weight without exceeding W.
     * For example, if W = 13 and the weights of n = 4 items were 1,3,8,11, a best solution would  consist  of  the  items
     * with  weights  1,11  for  a  total  weight  of  12,  and  no  other combination does better without going over 13.
     * What is the runtime of your algorithm?
     *
     * @param args
     */

    public static void main(String[] args) {
        // write your code here
        List<Integer> nItems = new ArrayList<Integer>();
        nItems.add(22);
        nItems.add(3);
        nItems.add(11);
        nItems.add(32);
        nItems.add(2);
        nItems.add(17);
        nItems.add(41);
        nItems.add(15);
        nItems.add(9);
        nItems.add(19);
        nItems.add(0);
        nItems.add(1);
        System.out.println(combination(150, nItems));


    }

    public static List<Integer> combination(int w, List<Integer> arr) {
        int n = arr.size();
        List<Integer> answer = new ArrayList<Integer>();
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr.get(i));
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(pq.remove());
        }

        while (!stack.isEmpty()){
            if(stack.peek() + count <= w){
                answer.add(stack.peek());
                count += stack.pop();
            } else{
                stack.pop();
            }

        }

        if(answer.get(answer.size()-1) == 0){
            answer.remove(answer.size()-1);
        }
        return answer;
    }

    public static HashMap<Integer, List<Integer>> cache = new HashMap<>();

//    public static List<Integer> combination(int w, List<Integer> arr) {
//
//        if (cache.containsKey(arr.get(0))) {
//            System.out.println("The integer at the first index of the array is " + arr.get(0));
//            return cache.get(arr.get(0));
//        }
//
//
//        ArrayList<Integer> answers = new ArrayList<>();
//        if (w > arr.get(0)) {
//            answers.add(arr.get(0));
//        }
//
//        for (int i = 1; i <= arr.size(); i++) {
//
//            int curr = arr.get(0);
//
//            if (w > arr.get(0)) {
//
//
//                List<Integer> otherIntegers = arr.subList(i, arr.size());
//
//                    List<Integer> recurOnOtherInts = combination(w, otherIntegers);
//
//
//
//                for (Integer integer : recurOnOtherInts) {
//                    answers.add(curr);
//                    answers.add(integer);
//                }
//
//            }
//        }
//
//        cache.put(arr.get(0), answers);
//
//        return answers;
//    }

}
