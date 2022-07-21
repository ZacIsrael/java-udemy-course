package com.zacisrael;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {


        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        TreeNode p2 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q2 = new TreeNode(1, new TreeNode(1), new TreeNode(2));

        System.out.println("This should evaluate to true: " + isSameTree(p, q));
        System.out.println("This should evaluate to false: " + isSameTree(p2, q2));

        TreeNode p3Left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        TreeNode p3Right = new TreeNode(7, new TreeNode(6), new TreeNode(8));
        TreeNode p3 = new TreeNode(5, p3Left, p3Right);

        TreeNode q3Left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        ;
        TreeNode q3Right = new TreeNode(7, new TreeNode(6), new TreeNode(8));
        TreeNode q3 = new TreeNode(5, q3Left, q3Right);

        System.out.println("This should evaluate to true: " + isSameTree(q3, p3));
        System.out.println("This should evaluate to false: " + isSameTree(p2, q3));
        System.out.println("This should evaluate to false: " + isSameTree(p, q2));

        TreeNode testCase4 = new TreeNode(1, new TreeNode(2), new TreeNode());
        TreeNode q4 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("This should evaluate to false: " + isSameTree(testCase4, q4));

        TreeNode zac = new TreeNode(0, new TreeNode(-5), null);
        TreeNode kyara = new TreeNode(0, new TreeNode(-8), null);
        System.out.println("This should evaluate to false: " + isSameTree(zac, kyara));

        /*
        [1,2,3]
[1,2,3]
        */
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // root cases
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;

        if (p.val == q.val) {
            if (hasLeft(p) && !hasLeft(q)) return false;
            if (!hasLeft(p) && hasLeft(q)) return false;
            if (hasRight(p) && !hasRight(q)) return false;
            if (!hasRight(p) && hasRight(q)) return false;
            if (hasLeft(p) && hasLeft(q) && !hasRight(p) && !hasRight(q)) {
                return isSameTree(p.left, q.left);
            }
            if (!hasLeft(p) && !hasLeft(q) && hasRight(p) && hasRight(q)) {
               return isSameTree(p.right, q.right);
            }
            if (hasLeft(p) && hasLeft(q) && hasRight(p) && hasRight(q)) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

            }
            return true;
        }

        return false;
    }

    public static boolean hasLeft(TreeNode curr) {
        return curr.left != null;
    }

    public static boolean hasRight(TreeNode curr) {
        return curr.right != null;
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int count = 0;

        TreeNode curr = root;
        while (curr.right == null) {
            curr = curr.left;
        }
        while (curr.left == null) {
            curr = curr.right;
        }
        // curr is now the first node that has two children

        TreeNode prev = null;
        while (curr != null) {
            if (curr != root) {
                count++;
            }

            if (curr.left != null) {
                prev = curr;
                curr = curr.left;
            } else if (curr.right != null) {
                prev = curr;
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            }
        }

        if (count == 0) return 1;

        return (int) Math.pow(2, count);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        ArrayList<Integer> rootVal = new ArrayList<Integer>();
        rootVal.add(root.val);
        if (root.left == null && root.right == null) {
            answer.add(rootVal);
            return answer;
        }

        TreeNode curr = root;
        Stack<List<Integer>> stack = new Stack<List<Integer>>();

        TreeNode prev = null;
        while (curr != null) {
            List<Integer> list = new ArrayList<Integer>();
            if (curr.left != null) {
                list.add(curr.left.val);
            }
            if (curr.right != null) {
                list.add(curr.right.val);
            }

            if (curr.left != null || curr.right != null) {
                stack.add(list);
            }
            if (curr.left != null) {
                prev = curr;
                curr = curr.left;

            } else if (curr.right != null) {
                prev = curr;
                curr = curr.right;
            } else if ((curr.right == null && curr.left == null) && (curr == prev.left) && (prev.right != null)) {
                curr = prev.right;
            } else if ((curr.right == null && curr.left == null) && (curr == prev.left) && (prev.right == null)) {
                break;
            } else if ((curr.right == null && curr.left == null) && (prev.right == curr)) {
                break;
            }


        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }

        answer.add(rootVal);


        return answer;
    }

}
