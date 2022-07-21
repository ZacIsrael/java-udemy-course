import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie(new Trie.TrieNode());
        trie.insertDictionary("words.txt");

        System.out.println(wordSplitterRec(trie, "with"));
        System.out.println(wordSplitterRec(trie, "withdraw"));
        System.out.println(wordSplitterRec(trie, "withdrawmoney"));
        System.out.println(wordSplitterRec(trie, "withdrawr"));
        System.out.println(wordSplitterRec(trie, "withdrawmoneyfrom"));


    }

    public static String wordSplitterRec(Trie trie, String s) {

        if(s.length() == 0){
            return "";
        } else{
            int index = 0;
            String test = "";
            while(index < s.length()){
                test += s.charAt(index);
                if(trie.contains(test)){
                    return test + " " + wordSplitterRec(trie, s.substring(index + 1));
                } else{
                    index++;
                }
            }
        }
//        int length = s.length();
//        if (length == 0) {
//            return "";
//        }
//
//        for (int i = 1; i <= length; i++) {
//
//            String subString = s.substring(0, i);
//
//            if (trie.contains(subString)) {
//                return subString + " " + wordSplitterRec(trie, s.substring(i));
//            }
//
//            if(i == length && !trie.contains(subString)){
//                break;
//            }
//
//        }

        return "No splitting found.";
    }



    public static String wordSplitterLast(Trie trie, String word) {
        Stack<Character> lastChars = new Stack<>();
        // stack that holds the last characters of the string if the current word is not in the dictionary
        String answer = "";
        while (!word.isEmpty()) {
            // while the word is not an empty string
            if (trie.contains(word)) {
                // if the word is in the dictionary, add the word and a space to the answer string
                answer += word + " ";
                word = "";
                // set the word equal to an empty string
                int j = lastChars.size();
                if (!lastChars.isEmpty()) {
                    // if the stack is not empty, add all the characters in the stack back to the word
                    for (int i = 0; i < j; i++) {
                        word += lastChars.pop();
                    }
                }
            } else {
                // Otherwise,
                if (word.length() == 1) {
                    // if it reaches this point, this means that there is only 1 char in the string
                    // and that char is not in the dictionary, then no splitting will be found
                    return "No splitting found.";
                } else {
                    // Otherwise,
                    lastChars.add(word.charAt(word.length() - 1));
                    //add the last character in the word to the stack

                    // set the word equal to itself without the last character
                    word = word.substring(0, word.length() - 1);

                }
            }
        }
        return answer; // return the answer
    }

    public static String wordSplitter(Trie trie, String word) {
        String front = wordSplitterFront(trie, word);
        String last = wordSplitterLast(trie, word);

        if (front == "No splitting found." && last == "No splitting found.") {
            return "No splitting found.";
        } else if (front == "No splitting found." && last != "No splitting found.") {
            return last;
        } else if (front != "No splitting found." && last == "No splitting found.") {
            return front;
        } else {
            return last;
        }
    }

    public static String wordSplitterFront(Trie trie, String word) {
        Stack<Character> visited = new Stack<>();
        String answer = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            visited.add(word.charAt(i));
        }
        String test = "";
        while (!visited.isEmpty()) {
            test += visited.pop();
            if (trie.contains(test)) {
                answer += test + " ";
                test = "";
            } else if (visited.isEmpty() && !trie.contains(test)) {
                return "No splitting found.";
            }
        }
        return answer;
    }


    /*
    int medianCount = (int) Math.ceil(array.size()/5);
        int remainderCount = array.size() % 5;

        // Size of the last group which may not be 5 in case the list size is not divisible by 5
        int lastLoopSize = remainderCount != 0? remainderCount : 5;

    for (int i = 0; i < medianCount; i++) {
            //  Divide the n elements of the input array into n/5 groups of 5 elements each and at most one group made up
            // of the remaining n mod 5 elements.
            ArrayList<T> subList = new ArrayList<>();
            int loopSize = 5;
            if(i == medianCount-1){
                loopSize = lastLoopSize;
            }
            for (int j = 0; j < loopSize; j++) {
                subList.add(array.get((i*5) + j));
            }
            T median = getMedian(subList);
            // Find the median of each of the (ceiling) n/5 groups by first insertion-sorting the elements of each
            // group (of which there are at most 5) and then picking the median from the sorted list of group elements.
            medians.add(median);
        }


         private int partition(ArrayList<T> a, int left, int right, int pIdx) {
        T pivot = a.get(pIdx);
        exch(a, pIdx, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {

            if (a.get(i).compareTo(pivot) < 0 ||  a.get(i).compareTo(pivot) == 0)
                exch(a, i, storeIndex++);
        }
        exch(a, right, storeIndex);
        return storeIndex;
    }





        */

}



