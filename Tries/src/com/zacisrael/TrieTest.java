package com.zacisrael;

public class TrieTest {

    char c;
    TrieTest[] children;
    boolean word;

    public TrieTest() {
        this.c = 0;
        this.children = new TrieTest[26];
        this.word = false;
    }

    public void add(String s){
        if(s.isEmpty()){
            // we hit the end of the word
            this.word = true;
            return;
        }

        char letter = s.charAt(0);
        int index = letter - 'a'; // 'a' value of 97, 'b' has value of 98 , and so on

        if(this.children[index] == null){
            this.children[index] = new TrieTest();
        }
        this.children[index].add(s.substring(1)); // recursive call until the string is empty
    }

    public boolean isWord(String s){
        if(s.isEmpty()){
            return this.word;
        }
        char letter = s.charAt(0);
        int index = letter - 'a';

        if(this.children[index] == null){
            return false;
        }

        return this.children[index].isWord(s.substring(1));
    }

}
