import java.util.Stack;

public class TreeNode {

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(6);
//        treeNode.left = node2;
//        treeNode.right = node3;
//        node3.left = node6;
//        node2.right = node5;
//        node2.left = node4;
//        TreeNode test2 = new TreeNode(1);

//        System.out.println( treeNode.searchBST(treeNode, 3));
//        System.out.println( treeNode.searchBST(treeNode, 5));
//        System.out.println(treeNode.searchBST(treeNode, 10));
//        System.out.println(treeNode.searchBST(treeNode, 1));
//        System.out.println(treeNode.searchBST(treeNode, 7));
//        System.out.println(treeNode.searchBST(treeNode, 2));

//        System.out.println(countNodes(treeNode));
//        System.out.println(countNodes(test2));

//        TreeNode test = new TreeNode(1, new TreeNode(0), new TreeNode(2));
//        TreeNode test_3;
//        test_3 = new TreeNode(3, test, new TreeNode(4));


        TreeNode testing = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node9 = new TreeNode(9, new TreeNode(5), new TreeNode(1));
        TreeNode node4 = new TreeNode(4, node9, new TreeNode(0));
        System.out.println(sumNumbers(testing));
        System.out.println(sumNumbers(node4));



    }

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


    public static int sumNumbers(TreeNode root) {

      return helper(root, 0);
    }
    private static int helper(TreeNode root, int sum){
        if(root == null) return 0;
        int newSum = root.val + (sum * 10);
        if(root.left == null && root.right == null){
            // leaf node
            return newSum;
        }
        return helper(root.left, newSum) + helper(root.right, newSum); // return sum of two subtrees
    }


    public static int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        count++;

        if (root.left != null && root.right != null) {
            return count + countNodes(root.left) + countNodes(root.right);
        } else if (root.left == null && root.right != null) {
            return count + countNodes(root.right);
        } else if (root.left != null && root.right == null) {
            return count + countNodes(root.left);
        }


        return count;
    }


    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return tree(0, 0, inorder.length - 1, preorder, inorder);

    }

    public TreeNode tree(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {

        if (preStart > preOrder.length - 1 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int index = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inOrder[i]) {
                index = i;
            }
        }

        root.left = tree(preStart + 1, inStart, index - 1, preOrder, inOrder);
        root.right = tree(preStart + index - inStart + 1, index + 1, inEnd, preOrder, inOrder);

        return root;
    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        TreeNode leftSubTree = invertTree(root.left); // traversal of left subtree
        TreeNode rightSubTree = invertTree(root.right); // traversal of right subtree

        root.right = leftSubTree; // set the root's right child = to the left subtree
        root.left = rightSubTree; // set the root's left child = to the right subtree
        return root; // return the root node


    }

    private TreeNode reverseBST(int num) {

        if (this == null) {
            return new TreeNode(num);
        } else {
            if (this.val < num && this.left == null) {
                return this.left = new TreeNode(num);
            }
            if (this.val > num && this.right == null) {
                return this.right = new TreeNode(num);
            }
            if (this.val < num && this.left != null) {
                return this.left.reverseBST(num);
            }
            if (this.val > num && this.right != null) {
                return this.right.reverseBST(num);
            }


            return this;
        }
    }

    private TreeNode insert(int num) {

        if (this == null) {
            return new TreeNode(num);
        } else {
            if (this.val < num && this.right == null) {
                return this.right = new TreeNode(num);
            }
            if (this.val > num && this.left == null) {
                return this.left = new TreeNode(num);
            }
            if (this.val < num && this.right != null) {
                return this.right.insert(num);
            }
            if (this.val > num && this.left != null) {
                return this.left.insert(num);
            }


            return this;
        }


    }


}
