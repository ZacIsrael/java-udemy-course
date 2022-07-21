/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.*;

public class WordSplitter {

    public static void main(String[] args) {
        // your implementation goes here
        Trie trie = new Trie(new Trie.TrieNode());
        trie.insertDictionary("words.txt");

//        System.out.println(wordSplitter(trie, "with"));
//        System.out.println(wordSplitter(trie, "withdraw"));
//        System.out.println(wordSplitter(trie, "withdrawmoney"));
//        System.out.println(wordSplitter(trie, "withdrawr"));
//        System.out.println(wordSplitter(trie, "withdrawmoneyfrom"));
//        System.out.println(wordSplitter(trie,"wearefrom"));

        System.out.println(splitAllWords(trie,"withdrawmoney"));


    }


    public static HashMap<String, ArrayList<String>> cache = new HashMap<>();
    // A dynamic programming cache to store already computed results

    public static String wordSplitter(Trie dictionary, String text) {
        ArrayList<String> solutions = splitAllWords(dictionary,text);
        // array list of all the possible solutions


        return solutions != null && !solutions.isEmpty() ? solutions.get(0) : "No splitting found.";
        // return the first index in the array list of cache, if array list is null, return no splitting found

    }


    public static ArrayList<String> splitAllWords(Trie trieDict, String word){
        //if already computed the current substring text then return from cache
        if(cache.containsKey(word)){
            // checks if the word is already stored in the cache
            return cache.get(word);
        }
        ArrayList<String> answers = new ArrayList<>();

        if(trieDict.contains(word)){
            // if the the word is in the trie, add the word to the answers array list
            answers.add(word);
        }


        for(int i = 1; i <= word.length(); i++){
            // for the length of the word
            String firstHalf = word.substring(0, i);
            // substring starting from 0 and ending before char i
            if(trieDict.contains(firstHalf)){
                // if the trie contains the this firstHalf substring,
                String secondHalf = word.substring(i);
                ArrayList<String> recurOnSecondHalf = splitAllWords(trieDict, secondHalf);
                // recursively do the same for the second half of the string


                for(String currWord : recurOnSecondHalf){
                    // At this point, the trie contains the secondHalf of the substring as well

                    answers.add(firstHalf + " "+ currWord);
                    // add the words from the recurOnSecondHalf to the firstHalf substring and
                    // then add that string to the answers array list
                }
            }
        }

        cache.put(word, answers);
        // storing the word into the cache


        return answers; // return the answers array list
    }
}
