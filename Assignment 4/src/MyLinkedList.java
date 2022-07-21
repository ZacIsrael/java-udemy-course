import java.util.*;
/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS.
 Zac Israel */

public class MyLinkedList {
    /*******************************************************/
    class Node {
        private long data;
        private Node next;

        public Node(long data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return "" + this.data;
        }

    }

    /********************************************************/

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // Returns true if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Inserts a new node at the beginning of this list
    public void addFirst(long item) {
        head = new Node(item, head);
        size++;
    }

    // Inserts a new node to the end of this list
    public void addLast(long item) {
        if (isEmpty())
            addFirst(item);
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            // Now current is pointing to the last element!
            current.next = new Node(item, null);
            size++;
        }
    }

    // Returns the first element (data) in the list
    public long getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.data;
    }

    // Returns the last element (data) in the list
    public long getLast() {
        if (head == null) throw new NoSuchElementException();
        Node tmp = head;
        while (tmp.next != null) tmp = tmp.next;
        return tmp.data;
    }

    // Returns a reference to the Node at the given position,
    // assuming that node indexes start at zero
    public Node get(int pos) {
        if (head == null) throw new IndexOutOfBoundsException();
        Node tmp = head;
        for (int k = 0; k < pos; k++) {
            tmp = tmp.next;
            if (tmp == null) throw new IndexOutOfBoundsException();
        }
        return tmp;
    }

    public long[] toArray() {
        if (head == null) throw new IndexOutOfBoundsException();
        long[] result = new long[getSize()];
        int i = 0;
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            result[i] = tmp.data;
            i++;
        }
        return result;
    }

    // Removes and returns the first element (data) in the list.
    public long removeFirst() {
        long temp = getFirst();
        head = head.next;
        size--;
        return temp;
    }

    // Removes the first occurrence of the specified element in this list.
    public void remove(long key) {
        if (head == null)
            throw new RuntimeException("cannot delete");

        if (head.data == key) {
            head = head.next;
            size--;
            return;
        }

        Node cur = head;
        Node prev = null;
        while (cur != null && cur.data != key) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) throw new RuntimeException("cannot delete");
        prev.next = cur.next;
        size--;
    }

    // Returns a string representation
    public String toString() {
        String output = "";
        if (head == null) throw new NoSuchElementException();
        Node tmp = head;
        while (tmp != null) {
            output += tmp + " -> ";
            tmp = tmp.next;
        }
        output += "[NULL]";
        return output;
    }


    //-------------------------------------------------------------------------
    //----- Use MergeSort algorithm to sort the nodes in this linked list -----
    //-------------------------------------------------------------------------
    // TODO: Find the middle element of the list that begins at the passed node
    public Node getMiddle(Node node) {
        int i = 0; // initializes a counter to track how many elements are in the list
        Node test = node; // keeps track of where the halfway mark is starting from the node testcase
        while (node.next != null) {
            // as long as the next node is not equal to null, increment the counter by 1.
            node = node.next;
            i++;
        }
        // By now i is the number of elements in the list
        int k = i / 2; // k is equal to half the number of the elements in the list

        for (int j = 0; j < k; j++) {
            test = test.next;
        }
        return test;

    }

    //
//    // MergeSort starting point
    public void mergeSort() {
        if (head == null) throw new RuntimeException("Cannot sort empty list.");
        head = sort(head);
    }

    //
//    // TODO: Sort this linked list using merge sort (recursively)
    public Node sort(Node node) {

        if (node.next == null) {
            // If the node's next's reference is null, just return the node. This means that the method has sorted
            // through and reached the end of the specific list (firstHalf, secondHalf) or the list only contains
            // one element which means that it is already sorted so the method can just return the node.

            return node;
        }
        Node mid = getMiddle(node); // initializing a node that is the middle of the list
        Node afterMid = mid.next; // this node will be the first node in the second list

        mid.next = null;
        // the middle has to point to null next because if it does not, the sort method
        // will sort the entire list instead of only sorting the first half.


        Node firstHalf = sort(node); // sorts first half of the list ( head to mid )
        Node secondHalf = sort(afterMid); // sorts second half of the list ( afterMid to last node in the list )
        return merge(firstHalf, secondHalf);
        // merges the firstHalf and secondHalf and returns the head of the full list sorted

    }

    //
//    // TODO: Merge two sorted lists (can be non-recursive)
    public Node merge(Node left, Node right) {
        Node test;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }


      if (left.data <= right.data) {
            // If the node left is less than or equal to the node right,
            test = left; //set the test Node equal to the left
            test.next = merge(left.next, right); // and then set the test next reference equal to merge(left.next, right).
            // This method will continue until left.next is equal to null

        } else {
            // Otherwise,
            test = right; // set the node test equal to the node right
            test.next = merge(left, right.next);
            // and then set the test next reference equal to merge(left, right.next).
            // This method will continue until right.next is equal to null
        }


        return test; // This is now the head of the list and the list is now sorted

    }

    public static void main(String[] args) {
        // Test your merge sort implementation here!
        MyLinkedList list = new MyLinkedList();
        list.addLast(3);
        list.addLast(2);
        list.addLast(8);
        list.addLast(10);
        list.addLast(5);
        System.out.println("Before list.mergeSort()...");
        System.out.println(list);
        list.mergeSort();
        System.out.println("\nAfter list.mergeSort()...");
        System.out.println(list);
    }

} // End of MyLinkedList class

