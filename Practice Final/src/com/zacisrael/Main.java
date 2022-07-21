package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Node head = new Node(0);
        head.next = head;
        print(head);
        insertValueRec(head, 5);
        print(head);
        insertValueRec(head, 3);
        print(head);
        insertValueRec(head, 4);
        print(head);


        insertValue(head, 2);
        print(head);
        insertValue(head, 6);
        print(head);
        insertValue(head, 1);
        print(head);


    }

    public static void print(Node n) {
        do {
            System.out.print(n.value + "->");
            n = n.next;
        } while (n.value != 0);
        System.out.println("END");
    }

    public static void insertValue(Node n, int x){
        Node xNode = new Node(x);
        Node original = n;
        while(n.next.value != 0){ // while te next value in the list is not equal to 0 (the head) n
            if(n.value < x && n.next.value > x){ // If the value of n is less than x and n's next reference has a value greater than x,
                Node originalNext = n.next;
                n.next = xNode; // set n's next reference equal to the a new node with x as its value
                xNode.next = originalNext; // set the new node's next reference equal to the original next reference of node n
                return; // end the method

            } else if(n.value == x){
                // if the value of node n is equal to x, break out of the method
                return;
            }
            else{
                // otherwise, iterate to the next node in the list
                n = n.next;
            }
    }
        n.next = xNode;
        xNode.next = original;
    }

    public static void insertValueRec(Node n, int x){
        Node xNode = new Node(x);

            if((n.value < x && n.next.value > x) || (n.value < x && n.next.value == 0)){
                // if x is greater than the current n and less than next n or the next n is 0,
                Node currNext = n.next;
                n.next = xNode; // set the node with x as its value to the next reference of the n node
                xNode.next = currNext; // set the x node's next reference equal to to the original next of the n node
                return;
            } else if(n.value == x){
                // if the value of the current node n is equal to the test case x, then end the method
                return;
            }else {
                    // recur to the next node in the list
                    insertValueRec(n.next, x);

            }
    }





}
