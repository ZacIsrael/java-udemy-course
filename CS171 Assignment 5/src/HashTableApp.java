/*THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS
OR COPIED FROM ONLINE RESOURCES. Zac Israel*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashTableApp {

    // Builds and returns a hash table of frequencies from the given input file
    public static HashSeparateChaining getMap(Scanner in){
        HashSeparateChaining map = new HashSeparateChaining();

        while(in.hasNext()){
            String word = in.next(); // read next word in file
            word = sanitize(word);
            word = word.toLowerCase();
           //int wordCount = map.get(word) == null?1: map.get(word) +1;
            // TODO: If this word already exists in the hashtable map,
            Integer wordCount = map.get(word);
            if(wordCount != null) {
                ++wordCount;
                // increment its frequency by 1.
            }else {
                wordCount = 1;
                // Otherwise, add it as a new entry in the hashtable
                // with a frequency of 1.
            }

            map.put(word, wordCount);

        }

        return map;

    }

    private static String sanitize(String word){
        // method that takes care of other delimiters aside from a space
        List<String> specialChars = new ArrayList<>();
        // adds all of these 1 character strings to an array list.
        specialChars.add(",");
        specialChars.add(":");
        specialChars.add(".");
        specialChars.add("?");
        specialChars.add("!");


        String lastChar = word.substring(word.length()-1);
        // String lastChar = the word starting from the last character (so it is a one letter string)
        if(specialChars.contains(lastChar)){
            // If the lastChar is in the array list,
            word = word.substring(0, word.length()-1);
            // set the word = to itself without the last character.
        }
        return word;
    }

    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("hamlet.txt");
            System.exit(-1);
        }

        File input = new File(args[0]);
        Scanner fileReader = null;

        try{
            fileReader = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.  Check the file name and try again.");
            System.exit(-2);
        }

        HashSeparateChaining map = getMap(fileReader);
        System.out.println(map); // invokes map.toString()
        System.out.println("The size of the table is " + map.size());


        // testing delete method
        List<String> keys = map.getKeys();
        int deleteCount = keys.size() / 2;
        for (int i = 0; i < deleteCount; i++) {
            map.delete(keys.get(i));
        }
        System.out.println(map);
        System.out.println("The size of the table is " + map.size());
    }
}

