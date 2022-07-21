package com.zacisrael;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Tries {
    public static void main(String[] args) {
        List<String> setOfStrings = new ArrayList<>();
        setOfStrings.add("pqrs");
        setOfStrings.add("pprt");
        setOfStrings.add("psst");
        setOfStrings.add("qqrs");
        setOfStrings.add("pqrs");

        final Trie trie = new Trie();
        setOfStrings.forEach(string -> trie.insert(string));
        System.out.println(trie.query("pqrs"));
//        System.out.println(trie.query("abc"));
//        System.out.println(trie.query("psst"));
//



    }
}

    class Trie{
        final TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        public int query(String s){
            TrieNode current = root.next(s.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                if(current == null){
                    return 0;
                }
                current = current.next(s.charAt(i));
            }
            return current.terminating;
        }
// 'a' = 97
        public void insert(final String s){
            TrieNode current = root.next(s.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                if(current.trieNodes[s.charAt(i) - 'a'] == null){
                    current.trieNodes[s.charAt(i)-'a'] = new TrieNode();
                }
                current = current.next(s.charAt(i));
            }
            current.terminating++;
        }
        public void delete(final String s){
            TrieNode current = root;
            for (int i = 0; i < s.length(); i++) {
                if(current == null){
                    throw new RuntimeException("String does not exist!");
                }
                current = current.next(s.charAt(i));
            }
            current.terminating--;
        }
        public void update(final String old, final String updated){
            delete(old);
            insert(updated);
        }

    }
    class TrieNode{
        int terminating;
        final TrieNode[] trieNodes = new TrieNode[26];

        public TrieNode next(char c){
            return trieNodes[c - 'a']; // make sure that it doesn't exceed 26 (numbers of letters in the alphabet
        }
    }


