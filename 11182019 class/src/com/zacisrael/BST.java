package com.zacisrael;

// Example of a Java implementation of a Binary Search Tree

// A binary tree node
class Node {
    int key;
    Node left, right;

    Node(int data) {
        key = data;
        left = right = null;
    }
}

// A binary search tree (BST) class
class BST {
    /* Given a binary search tree and a number,
    inserts a new node with the given number in
    the correct place in the tree. Returns the new
    root pointer. */
    Node insert(Node node, int key) {
		/* 1. If the tree is empty, return a new,
		single node */
        if (node == null) {
            return (new Node(key));
        } else {
            /* 2. Otherwise, recur down the tree */
            if (key <= node.key) {
                node.left = insert(node.left, key);
            } else {
                node.right = insert(node.right, key);
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    /* Given a non-empty binary search tree,
    return the minimum key value found in that
    tree. Note that the entire tree does not need
    to be searched. */
    int getMinValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return (current.key);
    }

    int getMaxValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.right != null) {
            current = current.right;
        }
        return (current.key);
    }

    /* TODO: Given a non-empty binary search tree,
    search for a given key and return the node that
    contains it, if exists. Return null if key does not exist. */
    public Node search(Node node, int key)
    {
        if(node.key == key || node == null) {
            // Base Cases: root is null or key is present at root
            return node;
        }
        if(key < node.key) {
            // search key is smaller than root's key
           return search(node.left, key);
        }
       else {
            // search key is larger than root's key
           return search(node.right, key);
        }


    }

    /* TODO: Given a non-empty binary search tree,
    search for a given key and delete the node that
    contains it. Return null if key does not exist. */
    public Node delete(Node node, int key)
    {
        // Base Case: If tree is empty
        if (node == null) return node;

        // Otherwise, recur down the tree
        if( key < node.key )
        {
            //TODO
        }
        else if( key > node.key )
        {
            //TODO
        }
        else { //node.key == key => found the node to be deleted!

            // TODO Case 1: if node is a leaf
            // .... //

            // TODO Case 2: if node has one subtree
            // .... //

            // TODO Case 2: if node has two subtrees
            // .... //

        } //end of node.key == key
        return node;
    }


    /* ----------------- BST Traversal Methods ------------- */
	/* Given a binary tree, print its nodes according to the
	"bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /*TODO: Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        //TODO
        /* then recur on left subtree */
        //TODO
        /* now recur on right subtree */
        //TODO
    }
    /* ----------------- End of BST Traversal Methods ------------- */

    /* Find the ceil of a given input in BST. Ceil is defined as the
    "smallest key in the tree that is greater than or equal to the given key".
    If input is larger than the max key in BST, return -1 */
    int findCeil(Node node, int input) {
        // Base case
        if (node == null) {
            return -1;
        }

        // We found equal key
        if (node.key == input) {
            return node.key;
        }

        // If root's key is smaller, ceil must be in right subtree
        if (node.key < input) {
            return findCeil(node.right, input);
        }

        // Else, either left subtree or root has the ceil value
        int ceil = findCeil(node.left, input);

        if (ceil >= input)
            return ceil;
        else
            return node.key;
    } // end of ceil


    /* TODO: Find the floor of a given input in BST. Floor is defined as the
    "largest key in the tree that is less than or equal to the given key".
    If input is smaller than the min key in BST, return -1 */
    int findFloor(Node node, int input) {
        return -1; //TODO
    } // end of floor

}

// This code has been contributed by Mayank Jaiswal

