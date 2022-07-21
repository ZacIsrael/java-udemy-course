/*THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS
OR COPIED FROM ONLINE RESOURCES. Zac Israel*/

import java.util.ArrayList;
import java.util.List;

public class HashSeparateChaining {

    private class Node {
        Entry entry;
        Node next;

        Node(Entry entry) {
            this.entry = entry;
        }
    }

    Node[] hashTable;
    int arraySize;
    int tableSize;

    public HashSeparateChaining() {
        hashTable = new Node[10];
        arraySize = 10;

    }

    /**
     * TODO: Write a resizing method for the hash table.
     */
    private void resize() {
        if (arraySize >= (tableSize / 5) && arraySize <= (tableSize / 3)) {
            // If the arraySize greater less than or equal to the number of entries divided by 5 OR the arraySize
            // is less than or equal to the number of entries divided by 3, leave the hashTable as it is.
            return;
        } else if (arraySize < tableSize / 5) {
            // If the arraySize is less than the number of entries divided by 5, set the array size equal to
            // the number of entries divide by 3. This way, the average length of each bucket (in this case, linked list)
            // will always be at least 3.
            arraySize = tableSize / 3;
        } else {
            // Otherwise, set the arraySize equal to the number of entries divided by 5. This way, the average length of
            // each bucket (in this case, linked list) will never be greater than 5.
            arraySize = tableSize / 5;
        }

        if (arraySize == 0) {
            // if the arraySize is 0, set it equal to 1.
            // Without this if statement, we will get an error in the hash function
            arraySize = 1;
        }

        // For debugging purposes
        System.out.println("arraySize:  " + arraySize);

        Node[] reSizedTable = new Node[arraySize]; // New hashTable with the resized arraySize
        for (int i = 0; i < hashTable.length; i++) { // iterates through all of the buckets
            Node traversingList = hashTable[i]; // Used for traversing bucket (linked list) number i.
            while (traversingList != null) { // while the i bucket is not equal to null

                // Creates a node and assigns it to the value of the next node in the i bucket
                Node nextInTraversingList = traversingList.next;

                // computes the hash for the given key in the i bucket with the resized arraySize
                int newHash = hash(traversingList.entry.getKey());

                // the next node in the i bucket is set to the hash bucket of the resized table
                traversingList.next = reSizedTable[newHash];

                // The current node in hash bucket of the resized table will be equal to the current re-hashed node
                // in the i bucket of the original hashTable
                reSizedTable[newHash] = traversingList;

                // iterates to the next node in the i bucket
                traversingList = nextInTraversingList;
                // continues until traversingList is equal to null which means that it is at the end of the bucket (linked list)
            }
        }
        hashTable = reSizedTable; // set the hashTable equal to the resized hashTable
    }

    /**
     * Computes the index in the hash table from a given key
     */
    private int hash(String key) {
        int hashCode = key.hashCode();
        return (hashCode & 0x7fffffff) % arraySize;
    }

    /**
     * Returns the number of entries in the hash table.
     */
    public int size() {
        return tableSize;
    }

    /**
     * Checks whether the hash table is empty
     */
    public boolean isEmpty() {
        return tableSize == 0;
    }

    /**
     * Returns the node containing the given key value if it exists in the table.
     * Otherwise, it returns a null value.
     */
    private Node findEntry(String key) {
        int index = hash(key);

        Node currentNode = hashTable[index];
        while (currentNode != null && !currentNode.entry.getKey().equals(key))
            currentNode = currentNode.next;

        return currentNode;

    }

    /**
     * Returns the integer value paired with the given key, if the key is in the table.
     * Otherwise, it returns null.
     */
    public Integer get(String key) {
        Node searchResult = findEntry(key);

        if (searchResult != null)
            return searchResult.entry.getValue();
        else
            return null;

    }

    /**
     * If the given key is not in the table, creates a new entry and adds it to the table.
     * Otherwise, it updates the value associated with the given key.
     */
    public void put(String key, Integer value) {

        Node searchResult = findEntry(key);

        if (searchResult != null) {
            searchResult.entry.setValue(value);
            return;
        }
        // Increments the number of entries every time a new entry is added
        tableSize++;

        // calls resize method
        resize();

        Entry newEntry = new Entry(key, value);
        Node newNode = new Node(newEntry);

        int index = hash(key);
        if (hashTable[index] != null) {
            newNode.next = hashTable[index];
        }
        hashTable[index] = newNode;
        resize();


    }

    /**
     * Removes the entry containing the given key
     * from the table, if the key exists in the table.
     */
    public void delete(String key) {
        Node searchResult = findEntry(key);
        if (searchResult == null)
            return;

        int index = hash(key);
        if (hashTable[index] == searchResult) {
            hashTable[index] = searchResult.next;
        } else {
            Node currentNode = hashTable[index];
            while (currentNode.next != searchResult)
                currentNode = currentNode.next;
            currentNode.next = searchResult.next;
        }
        // Decrement the number of entries
        tableSize--;
        // call resize method
        resize();
    }

    /**
     * Produces a string representation of the table.
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < arraySize; i++) {
            output += "\n (" + i + "): ";
            Node currentNode = hashTable[i];
            if (currentNode == null)
                output += currentNode + "\n";
            else {
                while (currentNode != null) {
                    output += " -> " + currentNode.entry;
                    currentNode = currentNode.next;
                }
                output += "\n";
            }
        }
        return output;
    }


    /**
     * Helper method to test delete method
     * @return
     */
    public List<String> getKeys() {
        List<String> keys = new ArrayList<String>();
        for (Node node : hashTable) { // for each loop that iterates through all of the nodes in the hashTable
            keys.add(node.entry.getKey()); // adds the String of the current node entry to the "keys" ArrayList
            while(node.next!= null){ // while the node's next reference is not equal to null
                node = node.next; // set the node = to its next reference (iterating)
                keys.add(node.entry.getKey()); // adds the String of the current node entry to the "keys" ArrayList
            }
        }
        return keys; // return the "keys"  arrayList
    }
}

