package com.zacisrael;
// This class represents the application code that tests BST.java functions
public class BSTTester{

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;

        // inserting the first (root) node:
        root = tree.insert(root, 8);

        // inserting remaining nodes:
        tree.insert(root, 4);
        tree.insert(root, 12);
        tree.insert(root, 2);
        tree.insert(root, 6);
        tree.insert(root, 10);
        tree.insert(root, 14);

        // testing the traversal functions:
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(root);
        System.out.println();

        // test the getMinValue function
        System.out.println("\nThe minimum value of this BST is " + tree.getMinValue(root));

        // test the getMaxValue function
        System.out.println("The maximum value of this BST is " + tree.getMaxValue(root));

       //  test the search function
        int item = 10;  // exists
        System.out.println("\nSearching for item [" + item + "] in the BST: " + tree.search(root, item).key);
        item = 5;  // does not exist
        System.out.println("Searching for item [" + item + "] in the BST: " + tree.search(root, item));

        //test deleting a node
        // int del = 8;
        // tree.delete(root, del);
        // System.out.println();
        // System.out.println("Deleting item [" + del + "]...");
        // tree.printInorder(root);
        // System.out.println();


        // Uncomment below when implementation is complete:
      /*
      //test Ceil function
      System.out.println("\nTesting the ceil function for different values: ");
      for (int i = 0; i < 16; i++) {
        System.out.println(i + " " + tree.findCeil(root, i));
      }
      //test Floor function
      System.out.println("\nPrinting tree again [Inorder]: ");
      tree.printInorder(root);
      System.out.println("\nTesting the floor function for different values: ");
      for (int i = 0; i < 16; i++) {
        System.out.println(i + " " + tree.findFloor(root, i));
      }
      */

    }
}

