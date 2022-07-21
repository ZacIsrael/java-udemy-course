package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST tree = new BST();
        Node root = null;

        // inserting the first (root) node:
        root = tree.insert(root, 8);

        // inserting remaining nodes:
        tree.insert(root, 6);
        tree.insert(root, 4);
        tree.insert(root, 35);
        tree.insert(root, 27);
        tree.insert(root, 45);
        tree.insert(root, 16);
        tree.insert(root, 2);
        tree.insert(root, 7);

        // testing the traversal functions:
//        System.out.println("Preorder traversal of binary tree is ");
//        // current,left, right
//        tree.printPreorder(root);


        System.out.println("Inorder traversal of binary tree is ");
        // left,current , right
        tree.printInorder(root);


//        System.out.println("\nPostorder traversal of binary tree is ");
//        // left , right , current
//        tree.printPostorder(root);
//        System.out.println();


        tree.deleteMin(root);
        System.out.println("The minimum value in the BST has been deleted.");
        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder(root);
        System.out.println("\n");


        tree.deleteMin(root);
        System.out.println("The minimum value in the BST has been deleted.");
        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder(root);
        System.out.println("\n");


        tree.deleteMin(root);
        System.out.println("The minimum value in the BST has been deleted.");
        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder(root);
        System.out.println("\n");

        tree.deleteMin(root);
        System.out.println("The minimum value in the BST has been deleted.");
        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder(root);
        System.out.println("\n");






        /*
        // test the getMinValue function
        System.out.println("\nThe minimum value of this BST is " + tree.getMinValue(root));

        // test the getMaxValue function
        System.out.println("The maximum value of this BST is " + tree.getMaxValue(root));

        // test the search function
        int item = 35;  // exists
        System.out.println("\nSearching for item [" + item + "] in the BST: " + tree.search(root, item).key);
        item = 3;  // does not exist
        System.out.println("Searching for item [" + item + "] in the BST: " + tree.search(root, item));

        //test deleting a node
//         int del = 8;
//         tree.delete(root, del);
//         System.out.println();
//         System.out.println("Deleting item [" + del + "]...");
//         tree.printInorder(root);
//         System.out.println();


        // Uncomment below when implementation is complete:

      //test Ceil function
//      System.out.println("\nTesting the ceil function for different values: ");
//      for (int i = 0; i < 21; i++) {
//        System.out.println(i + " " + tree.findCeil(root, i));
//      }
      //test Floor function
      System.out.println("\nPrinting tree again [Inorder]: ");
      tree.printInorder(root);
      System.out.println("\nTesting the floor function for different values: ");
      for (int i = 0; i < 45; i++) {
        System.out.println(i + " " + tree.findFloor(root, i));
      } */
//

    }
}
