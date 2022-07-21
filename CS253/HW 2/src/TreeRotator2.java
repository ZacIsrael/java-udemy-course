import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class TreeRotator2 {

    public static void main(String[] args){
        //an example of two randomly generated BSTs on the same set of keys
//        TreeSet<Integer> ts1 = new TreeSet<>();
//        TreeSet<Integer> ts2 = new TreeSet<>();
//        ArrayList<Integer> list = new ArrayList<>();;
//        for (int i = 0; i < 6; i++) list.add(i);
//        Collections.shuffle(list);
//        for (Integer in : list) ts1.put(in);
//        LinkedBinaryTree<Integer> tree1 = (LinkedBinaryTree<Integer>)ts1.getTree();
//        Collections.shuffle(list);
//        for (Integer in : list) ts2.put(in);
//        LinkedBinaryTree<Integer> tree2 = (LinkedBinaryTree<Integer>)ts2.getTree();
//
//        System.out.println(tree1);
//        System.out.println(tree2);
//
//        printRotations(tree1, tree2);


        //Homework Handout Trees
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

        System.out.println("\nT1\n");
       // printNode(copy1.root);

        List<LinkedBinaryTree.Node<Integer>> tree1ToAllRightBranchesRotatedNodes = createAllRightBranches(copy1);
        System.out.println("\n..... T1 to rightBranchOnlyTree:\n");
      //  printNode(copy1.root);

        List<Integer> keys = new ArrayList<>();
        System.out.println("\nT1 to rightBranchOnlyTree keys:  ");
        for (LinkedBinaryTree.Node<Integer> node : tree1ToAllRightBranchesRotatedNodes) {
            keys.add(node.getElement());
            System.out.print("\t" + node.getElement());
        }

        System.out.println("\n_______________________________________________________________\n.....\nT2\n");
       // printNode(copy2.root);

        List<LinkedBinaryTree.Node<Integer>> tree2ToAllRightBranchesRotatedNodes = createAllRightBranches(copy2);
        System.out.println("\n.....T2 to rightBranchOnlyTree:\n");
       // printNode(copy2.root);
        System.out.println("\nT2 to rightBranchOnlyTree keys of size " + tree2ToAllRightBranchesRotatedNodes.size() + ":  ");

        //When rotating T2 to allRightBranchesTree, we started at the top and moved down.
        //However, to get back to the original tree, we must start in the reverse order.
        for (int i = tree2ToAllRightBranchesRotatedNodes.size() - 1; i >= 0; i--) {
            LinkedBinaryTree.Node<Integer> node = tree2ToAllRightBranchesRotatedNodes.get(i);
            //After the rotation, the previous parent is a right child
            keys.add(node.getRight().getElement());
            System.out.println("\t" + node.getElement() + "(" + (node.getRight() != null ? node.getRight().getElement() : "") + ")");
        }

        System.out.println("\n!!!!! T1 to T2 Keys:  " + keys);
    }


    private static List<LinkedBinaryTree.Node<Integer>> createAllRightBranches(LinkedBinaryTree<Integer> copy) {
        LinkedBinaryTree.Node<Integer> parentNode = copy.root;
        LinkedBinaryTree.Node<Integer> leftChildNode = null;
        List<LinkedBinaryTree.Node<Integer>> rotatedNodes = new ArrayList<>();
        while (parentNode != null) {
            leftChildNode = parentNode.getLeft();

            if (leftChildNode != null && leftChildNode.getElement() != null) {
                System.out.println("rightRotate node with key:  " + leftChildNode.getElement());
                rotatedNodes.add(leftChildNode);
                copy.rotate(leftChildNode);

                //Set parentNode to leftChildNode
                parentNode = leftChildNode;
            } else {
                //Set parentNode to right child node
                parentNode = parentNode.getRight();
            }
        }

        return rotatedNodes;
    }

    //////////////////////The following are utility methods for printing a binary tree /////////////////////
    // TODO:  Create a BinaryTreePrinter class
//    private static <T extends Comparable<?>> void printNode(LinkedBinaryTree.Node<Integer> root) {
//        int maxLevel = maxLevel(root);
//
//        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
//    }
//
//    private static <T extends Comparable<?>> void printNodeInternal(List<LinkedBinaryTree.Node<Integer>> nodes, int level, int maxLevel) {
//        if (nodes.isEmpty() || isAllElementsNull(nodes))
//            return;
//
//        int floor = maxLevel - level;
//        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
//        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
//        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
//
//        printWhitespaces(firstSpaces);
//
//        List<LinkedBinaryTree.Node<Integer>> newNodes = new ArrayList<>();
//        for (LinkedBinaryTree.Node<Integer> node : nodes) {
//            if (node != null) {
//                System.out.print(node.getElement() != null ? node.getElement() : "-");
//                newNodes.add(node.getLeft());
//                newNodes.add(node.getRight());
//            } else {
//                newNodes.add(null);
//                newNodes.add(null);
//                System.out.print(" ");
//            }
//
//            printWhitespaces(betweenSpaces);
//        }
//        System.out.println("");
//
//        for (int i = 1; i <= endgeLines; i++) {
//            for (int j = 0; j < nodes.size(); j++) {
//                printWhitespaces(firstSpaces - i);
//                if (nodes.get(j) == null) {
//                    printWhitespaces(endgeLines + endgeLines + i + 1);
//                    continue;
//                }
//
//                if (nodes.get(j).getLeft() != null)
//                    System.out.print("/");
//                else
//                    printWhitespaces(1);
//
//                printWhitespaces(i + i - 1);
//
//                if (nodes.get(j).getRight() != null)
//                    System.out.print("\\");
//                else
//                    printWhitespaces(1);
//
//                printWhitespaces(endgeLines + endgeLines - i);
//            }
//
//            System.out.println("");
//        }
//
//        printNodeInternal(newNodes, level + 1, maxLevel);
//    }
//
//    private static void printWhitespaces(int count) {
//        for (int i = 0; i < count; i++)
//            System.out.print(" ");
//    }
//
//    private static <T extends Comparable<?>> int maxLevel(LinkedBinaryTree.Node<Integer> node) {
//        if (node == null)
//            return 0;
//
//        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
//    }
//
//    private static <T> boolean isAllElementsNull(List<T> list) {
//        for (Object object : list) {
//            if (object != null)
//                return false;
//        }
//
//        return true;
//    }

}
