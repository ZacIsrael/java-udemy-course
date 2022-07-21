package com.zacisrael;

public class Solution {



    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr.next != null){
            if(curr.val == curr.next.val){
                ListNode tempNext = curr.next;
                if(tempNext.next == null){
                    curr.next = null;
                } else{
                    curr.next = tempNext.next;
                    tempNext.next = null;
                }
            }
            curr = curr.next;
        }
        return head;
    }






}
