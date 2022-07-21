/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.*;

public class TreeRotator {

    public static void main(String[] args) {
       // an example of two randomly generated BSTs on the same set of keys
        TreeSet<Integer> ts1 = new TreeSet<>();
        TreeSet<Integer> ts2 = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) list.add(i);
        Collections.shuffle(list);
        for (Integer in : list) ts1.put(in);
        LinkedBinaryTree<Integer> tree1 = (LinkedBinaryTree<Integer>)ts1.getTree();
        Collections.shuffle(list);
        for (Integer in : list) ts2.put(in);
        LinkedBinaryTree<Integer> tree2 = (LinkedBinaryTree<Integer>)ts2.getTree();
        System.out.println(tree1);
        System.out.println(tree2);

        printRotations(tree1, tree2);

     //   Homework Handout Trees
//        TreeSet<Integer> ts3 = new TreeSet<>();
//        List<Integer> list3 = Arrays.asList(new Integer[]{0, 1, 4, 3, 5, 2});
//        for (Integer in : list3) ts3.put(in);
//        LinkedBinaryTree<Integer> tree3 = (LinkedBinaryTree<Integer>)ts3.getTree();
//
//        TreeSet<Integer> ts4 = new TreeSet<>();
//        List<Integer> list4 = Arrays.asList(new Integer[]{1, 0, 3, 2, 4, 5});
//        for (Integer in : list4) ts4.put(in);
//        LinkedBinaryTree<Integer> tree4 = (LinkedBinaryTree<Integer>)ts4.getTree();
//
//        printRotations(tree3, tree4);

    }

    public static void printRotations(LinkedBinaryTree<Integer> bt1, LinkedBinaryTree<Integer> bt2){
        //start with shallow copies of each of the trees
        LinkedBinaryTree<Integer> copy1 = new LinkedBinaryTree<>(bt1);
        LinkedBinaryTree<Integer> copy2 = new LinkedBinaryTree<>(bt2);
        //your implementation goes here

        if(bt1.isEmpty() || bt2.isEmpty()){ // if either of the trees are empty, don't do anything
            return;
        }
        List<LinkedBinaryTree.Node<Integer>> tree1Right = allRightBranch(copy1); // turns copy1 into an all right tree


        List<Integer> keysToRotate = new ArrayList<>(); // list to store the rotated keys
        for(LinkedBinaryTree.Node<Integer> key: tree1Right){ // adding the nodes that we have rotated to the list
            keysToRotate.add(key.getElement());
        }
        List<LinkedBinaryTree.Node<Integer>> tree2Right = allRightBranch(copy2); // turns copy 2 into an all right tree

        // copy1 & copy2 are the same because they are both all right trees
        // Now we must transform the all right tree back to bt2, so we must go in reverse order
        for (int i = tree2Right.size()-1; i >= 0 ; i--) { // iterating through the tree2 list in reverse order

            LinkedBinaryTree.Node<Integer> test =  tree2Right.get(i);
            keysToRotate.add(test.getRight().getElement());
            // the right node of the current element is the node that we have to rotate to the left (reverse order)
        }

        System.out.println("To rotate from tree 1 to tree 2, you must rotate the following keys in this order " + keysToRotate);
    }

    private static List<LinkedBinaryTree.Node<Integer>> allRightBranch(LinkedBinaryTree<Integer> duplicate){

        LinkedBinaryTree.Node<Integer> curr = duplicate.root;
        LinkedBinaryTree.Node<Integer> leftChild = null;
        List<LinkedBinaryTree.Node<Integer>> rotatedKeys = new ArrayList<>();

        while(curr != null){
            leftChild = curr.getLeft();
            if(leftChild != null && leftChild.getElement() != null){ // if the the current node has a left child and its element is not equal to null,
                //System.out.println("Rotate node with element: " + leftChild.getElement() + " to the right.");
                rotatedKeys.add(leftChild);
                duplicate.rotate(leftChild); // rotating the left child so it becomes a parent of the current node and the current node becomes its right child
                curr = leftChild; // set the current node equal to the node we just rotated and iterate down the tree
            } else{
                curr = curr.getRight(); // otherwise, the current node has no left child so we can iterate to the right child of the current node
            }

        }
        return rotatedKeys; // return the list of the keys that were rotated

    }
}
