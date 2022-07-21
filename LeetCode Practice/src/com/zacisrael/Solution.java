package com.zacisrael;

public class Solution {

    public int maxDepth(TreeNode root) {
        int leftCount = 0;
        int rightCount = 0;

        while(root.left != null){
            leftCount++;
            maxDepth(root.left);
        }
        while(root.right != null){
            rightCount++;
            maxDepth(root.right);
        }

        if(leftCount > rightCount){
            return 1 + leftCount;
        } else{
            return 1 + rightCount;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode reversed = reverse(head);
        ListNode temp = head;
        while(temp.next != null && reversed.next != null){
            if(temp.next == reversed.next){
                temp = temp.next;
                reversed = reversed.next;
            }
        }
        if(temp == reversed){
            return true;
        } else{
            return false;
        }
    }


    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode test = head;
        ListNode next = null;
        while(test!= null){
            next = test.next;
            test.next = prev;
            prev = test;
            test = next;
        }
        head = prev;
        return head;

    }


}
