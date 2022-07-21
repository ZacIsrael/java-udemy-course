/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.io.*;
import java.util.*;

public class Trie {

    public static class TrieNode {
        //each child of a TrieNode corresponds to a certain letter
        char c;
        private HashMap<Character, TrieNode> charMap = new HashMap<>();
        private boolean endOfWord = false;

        public TrieNode() {
        } // need an empty constructor to represent the root TrieNode in the Trie

        public TrieNode(char c) { // this constructor is needed for when we need to add a letter into the charMap
            this.c = c;
        }


    }

    public TrieNode root;

    public Trie(TrieNode root) {
        this.root = root;
    }

    public void insert(String s) {
        HashMap<Character, TrieNode> children = root.charMap;
        // HashMap that contains the children of the root (at most 26 children, 1 for each letter in the alphabet)

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i); // current character in the String s
            TrieNode added; // TrieNode that will be added
            if (children.containsKey(curr)) added = children.get(curr);
                // If the current TriedNode already has the curr char in their charMap (set of children key & value pairs),
                // set the "added' Trie Node equal to TrieNode with a key of the curr char
            else {
                // Otherwise,
                added = new TrieNode(curr); // create a new TrieNode with the curr char as the input
                children.put(curr, added);
                // put the key value pair of curr and the added TrieNode in the current TrieNode's children hasMap
            }

            children = added.charMap; // iterate to the children hashMap of the "added" TrieNode

            // Once the loop hits the char in the string s, set the endOfWord equal to true
            if (i == s.length() - 1) added.endOfWord = true;
        }
    }

    public boolean contains(String s) {
        // your implementation goes here
        HashMap<Character, TrieNode> search = root.charMap;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            TrieNode check;
            if (search.containsKey(curr)) {
                // if the HashMap contains the i char in String s,
                check = search.get(curr);
                // set the check TrieNode equal to the TrieNode in the search HashMap with the Key equal to char i
                search = check.charMap;
                // set the search equal check HashMap in order to iterate down the Trie
            } else {
                // Otherwise the i char in String s is not in the HashMap so return false
                return false;
            }

            if (i == s.length() - 1 && check.endOfWord == true) {
                // if we get to the last char in s and this TrieNode's endOfWord is et true, return true
                // if it's false, that means s is not in the trie, but s is some prefix of a word already in the trie
                return true;
            }
        }
        return false; // return false
    }

    //given a file with one word per line, insert all the words in the
    //file into the trie
    public void insertDictionary(String filename) {
        // your implementation goes here

        Scanner scanner;
        try {
            scanner = new Scanner(new FileInputStream(filename)); // scans the file
            while (scanner.hasNextLine()) {
                // while the text file has a next line, insert the nextline into the trie
                insert(scanner.nextLine());
            }
        } catch (IOException e) {
            // Catches the exception
            System.err.print(e);
        }


    }

    @Override
    public String toString() {
        return "Trie{" +
                "root of the Trie is " + root.c + " and the root's " +
                "children are " + root.charMap +
                '}';
    }

    public static void main(String[] args) {
        Trie trie = new Trie(new TrieNode());
        trie.insertDictionary("words.txt");

        System.out.println(trie.contains("accurate")); // true
        System.out.println(trie.contains("accurat")); // false
        System.out.println(trie.contains("asshole")); // false
        System.out.println("\n");
        System.out.println(trie.contains("zone")); // true
        System.out.println(trie.contains("zo")); // false
        System.out.println("\n");
        System.out.println(trie.contains("without")); // true
        System.out.println(trie.contains("witho")); // false


    }
}