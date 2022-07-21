package com.zacisrael;

/*THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel and Terry Floyd II*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class KlingDictionary {

    public ArrayList<KlingWord> dict;

    public KlingDictionary() {
        dict = new ArrayList<KlingWord>();
    }

    public int buildDictionary() {
        String[] knWordsArray = {"adanji", "baH", "baktag", "batleth", "Bekk", "fote",
                "forshak", "ghoptu", "lok", "eff", "grr", "keshmalek", "drumpf", "daH", "Kyamo"};

        String[] enWordsArray = {"perfume", "blah", "insult", "sword", "soldier",
                "vote", "car", "insult", "look", "insult", "insult", "gameover", "prince", "duh",
                "Beautiful"};

        String knWord = "";
        String enWord = "";
        int numWords = 0;
        for (int i = 0; i < knWordsArray.length; i++) {
            knWord = knWordsArray[i];
            enWord = enWordsArray[i];
            KlingWord word = new KlingWord(knWord, enWord);
            addWord(word);
            numWords++;
        }
        return numWords;
    }

    public boolean wordExist(KlingWord word) {
        // This a boolean method that returns true if the Kling word is already in the dict
        for (KlingWord k : dict) {
            // Checks for each Kling word in the dict
            if (k == word) {
                // If the current Klingword in the dict matches the test case , return true
                return true;
            }
        }
        // Otherwise, return false
        return false;
    }

    public int addWord(KlingWord newWord) {
        if (!wordExist(newWord)) {
            // If the test case is not already in the dict, add it to the list and return 0
            dict.add(newWord);
            return 0;
        } else {
            // Otherwise return -1
            return -1;
        }
    }

    public int replaceOrAddWord(KlingWord oldWord, KlingWord newWord) {
        for (int i = 0; i < dict.size() ; i++) {

            if(oldWord.getKN() == dict.get(i).getKN()){
                // If the Kling word of the oldWord test case matches the Klingword of the
                // i index in dict, remove the i index in dict and then add the newWord testcase
                // in the i index and return 0
                dict.remove(dict.get(i));
                dict.add(i,newWord);
                return 0;
            }
        }
        // Otherwise, just add the newWord test case to the end of the dict and return -1
        dict.add(newWord);
        return -1;
    }
    public int deleteFromDict(String badEN){
        final int size = dict.size();
        // I declared the integer initial size of the dict as final because I do not want it to change
        dict.removeIf(KlingWord -> KlingWord.getEN() == badEN);
        // Remove the klingword from the dict if the english translation for the word is the same as the testcase
        return size - dict.size();
        // Subtract the initial size from the size after the klingwords were deleted.
    }

    public void shortDict(){
        int limit = 3;
        dict.removeIf(KlingWord -> KlingWord.getKN().length() > limit);
        // remove the Klingword from the dict arraylist if the length of the KN string is longer than 3



    }

    public KlingDictionary createSubDict(){
        KlingDictionary newDict = new KlingDictionary();
        int count = 0;
        for(KlingWord k: dict){
            // For each word in the dict arrayList
            if(k.getKN().charAt(0) == k.getKN().charAt(k.getKN().length()-1)){
                // If the first (index 0) character of the kn in the KlingWord is equal
                // to the last character(index length() -1) of the kn in the KlingWord,
                // add this word to the the newDict
                newDict.addWord(k);
            }
        }
        return newDict;
    }
    public void printDictionary(){
        for(KlingWord kw: dict){
            System.out.println(kw);
        }
    }

    public static void main(String[] args) {
        int result;
        KlingDictionary klingdict = new KlingDictionary();
        result = klingdict.buildDictionary();
        System.out.println("buildDictionary() result => " + result);
        klingdict.printDictionary();

        result = klingdict.addWord(new KlingWord("klingothing", "nothing"));
        System.out.println("\naddKlingWordictoDict() result => " + result);
        klingdict.printDictionary();

        KlingWord testword = new KlingWord("forshak", "vehicle");
        KlingWord newWord = new KlingWord("gamma", "beta");
        result = klingdict.replaceOrAddWord(testword, newWord);
        System.out.println("\nreplaceOrAddWord(" + testword.getKN()+ "," + newWord.getKN() + ") result => " + result);
        klingdict.printDictionary();

        KlingDictionary specialDict = klingdict.createSubDict();
        System.out.println("\nCalled createSubDict()...");
        specialDict.printDictionary();

        klingdict.shortDict();
        System.out.println("\nApplied shortenDict()...");
        klingdict.printDictionary();

        String badEn = "insult";
        result = klingdict.deleteFromDict(badEn);
        System.out.println("\ndeleteFromDict() result => " + result);
    }

}
