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
    Node insert(Node node, int key) { // 8, 35, 27, 16, 6, 4, 45
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
        // Base Cases: root is null or key is present at root
        if( node == null || node.key == key )
            return node;

        // search key is smaller than root's key
        if( key < node.key ){
            return search(node.left, key);
        }

        // search key is larger than root's key
        else{
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
            node.left = delete( node.left, key );
        else if( key > node.key )
            node.right = delete( node.right, key );
        else { //node.key == key => found the node to be deleted!
            // Case 1: if node is a leaf
            if( node.left == null && node.right == null )
                return null;

            // Case 2: if node has one subtree
            if( node.left == null ) { // has right subtree
                return node.right;
            }
            else if( node.right == null ) { // has left subtrees
                return node.left;
            }

            // Case 3: if node has two subtrees
            // Step 1: find the min of right subtree
            int replaceKey = getMinValue(node.right);
            // Step 2: replace the delete node's key with replaceKey
            node.key = replaceKey;
            // Step 3: delete the node with replaceKey
            node.right = delete(node.right, replaceKey);
        } //end of node.key == key
        return node;
    }
    public Node deleteMin(Node node){
        if(node. left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);

        return node;

    }

    public Node deleteMax(Node node){
        if(node.right == null){
            return node.left;
        }
        node.right = deleteMax(node.right);
        return node;
    }


    /* ----------------- BST Traversal Methods ------------- */
	/* Given a binary tree, print its nodes according to the
	"bottom-up" postorder traversal. */
    void printPostorder(Node node)
    { // L, R, C
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
    { // L, C, R
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
    { // C, L, R
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
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

    int findFloor(Node node , int input){
        if(node == null){
            return -1;
        }

        if(node.key == input){
            return node.key;
        }

        if(node.key > input){
            return findFloor(node.left, input);
        }

        int floor = findFloor(node.right, input);
        if(floor >= input){
            return floor;
        } else{
            return node.key;
        }
    }

}

// This code has been contributed by Mayank Jaiswal

