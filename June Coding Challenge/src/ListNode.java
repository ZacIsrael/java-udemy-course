import java.util.List;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }

    public static void main(String[] args) {

//        ListNode listNode = new ListNode(4);
//        ListNode second = new ListNode(5);
//        ListNode third = new ListNode(1);
//        ListNode fourth = new ListNode(9);
//
//        listNode.next = second;
//        second.next = third;
//        third.next = fourth;
//
//        System.out.println(listNode);
//        listNode.deleteNode(new ListNode(4));
//        System.out.println(listNode);



    }

    public void deleteNode(ListNode node){

        ListNode curr = this;
        ListNode prev = curr;

        while(curr.next != null){
            ListNode next = curr.next;

            if(curr.val == node.val){
                if(curr == prev){
                    ListNode temp = curr;
                    curr = curr.next;
                    temp.next = null;
                    temp = null;
                    break;
                }
                prev.next = next;
                curr.next = null;
                curr = null;
                break;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        String list = "ListNode{ ";
        ListNode curr = this;
        while(curr != null){
            list += curr.val + " -> ";
            curr = curr.next;
        }

        return list;
    }
}
