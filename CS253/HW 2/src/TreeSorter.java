/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.*;
import java.util.PriorityQueue;

public class TreeSorter<K> {
    public static final int REMOVE_MIN = 0;
    public static final int GET_INORDER = 1;
    private TreeSet<K> set;
    private int removalType;
    public TreeSorter(TreeSet<K> set, int removalType){
        this.set = set;
        this.removalType = removalType;
    }
    public ArrayList<K> sort(ArrayList<K> input){
         set.insertList(input);
        switch (removalType){
            case REMOVE_MIN: return priorityQueueSort();
            case GET_INORDER: return inOrderTraversal();
        }
        return null;
    }


    public ArrayList<K> priorityQueueSort(){
        //your implementation goes here
        ArrayList<K> list = new ArrayList<>();
        int size = set.size();

        for (int i = 0; i < size; i++) {
            K minKey = set.min();
            if (minKey != null) {
                // if the node with minimum element is not equal to null,
                // remove the minimum element & add it to the list.
                set.removeMin();
                list.add(minKey);
            }
        }
        return list;
    }
    public ArrayList<K> inOrderTraversal(){
        //your implementation goes here
        ArrayList<K> arrayList = new ArrayList<>();
        LinkedBinaryTree.Node<K> curr = set.tree.root;
        Stack<LinkedBinaryTree.Node<K>> stack = new Stack<>();
        // this method has no node parameter so we cannot use recursion so we must use a stack
        while (curr != null || set.tree.size() > 0){

            while (curr != null){
                // while the current node is not equal to null,
                stack.push(curr); // push the current node onto the stack
                curr = curr.getLeft(); // iterate to the left node
            }
                // we are now at the leftmost node's left reference which is null
                if(stack.isEmpty()){
                    // If the stack is empty, that means we've visited all the node's in the tree
                    break;
                } else{
                    // Otherwise,
                    curr = stack.pop(); // set the current node equal to the last node that was pushed onto the stack
                    if(curr.getElement() != null){
                        // if the current node's element is mot null, meaning that it is an internal node
                        arrayList.add(curr.getElement()); // add the current node's element to the array list
                    }
                    curr = curr.getRight(); // iterate to the right subtree of the node that was just popped from the stack
                }
        }

        return arrayList;
    }

    public long  measurePerformance(ArrayList<K> list, int n){
        long startTime = 0;
        long endTime = 0;

        Collections.shuffle(list);

        for (K key : list) set.put(key);

        switch (n){
            case 0:
              startTime = System.currentTimeMillis();
                priorityQueueSort();
                endTime = System.currentTimeMillis();
                return endTime - startTime;
            case 1:
                startTime = System.currentTimeMillis();
                inOrderTraversal();
                endTime = System.currentTimeMillis();
                return endTime - startTime;
        }

        return startTime - endTime;

    }





    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        RandomizedTreeSet randomizedTreeSet = new RandomizedTreeSet();


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) list.add(i);


        TreeSorter<Integer> treeSorterPQ = new TreeSorter<>(treeSet, 0);
        TreeSorter<Integer> treeSorterIO = new TreeSorter<>(treeSet, 1);



        TreeSorter<Integer> randomPriorityQueueSort = new TreeSorter<>(randomizedTreeSet, 0);
        TreeSorter<Integer> randomInOrder = new TreeSorter<>(randomizedTreeSet, 1);



        long priorityQueueSortExecutionTime = treeSorterPQ.measurePerformance(list, 0);
        System.out.println("priorityQueueSort takes " + priorityQueueSortExecutionTime + " milli seconds.");

        long randomPQsort = randomPriorityQueueSort.measurePerformance(list, 0);
        System.out.println("priorityQueueSort with shuffled list takes " + randomPQsort+ " milli seconds.");

        long inOrderTraversalExecutionTime = treeSorterIO.measurePerformance(list, 1);
        System.out.println("inOrderTraversal takes " + inOrderTraversalExecutionTime + " milli seconds.");

        long randomInOrderSort = randomInOrder.measurePerformance(list, 1);
        System.out.println("InOrderTraversal with shuffled list takes " + randomInOrderSort + " milli seconds.");







    }

}
