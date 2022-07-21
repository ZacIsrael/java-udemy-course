package com.zacisrael;

// We want to "throw" Java exceptions in our code,
// so we must import them first:
import org.w3c.dom.Node;

import java.util.NoSuchElementException;


public class SimpleLinkedList implements SimpleList {

    private class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return this.data;
        }

    }
    @Override
    public String getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public String getLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Node current = head;

        while (current.next != null) current = current.next;

        return head.data;
    }

    @Override
    public String get(int pos) {
        if (isEmpty()) throw new IndexOutOfBoundsException();

        Node temp = head;

        for (int k = 0; k < pos; k++) {
            temp = temp.next;
            if(temp.next == null) throw new IndexOutOfBoundsException("String not found");

        }
        return temp.data;
    }

    @Override
    public String removeFirst() {
        String temp = getFirst();
        head = head.next;
        return temp;
    }

    @Override
    public void remove(String key) {
        // Corner case: list is empty
        if (isEmpty()) throw new RuntimeException("cannot delete");

        // Corner case: key to be removed exists at head
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }

        // Otherwise, key may (or may not) exist elsewhere in the list
        Node cur = head;
        Node prev = null;
        while (cur.data != key && cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        // Corner case: key does NOT exist!
        if (cur == null)
            throw new RuntimeException("cannot delete: item does not exist");

        // If we made it here, then key definitely exists
        // Delete cur node
    }

    @Override
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

    private Node head;

    // Constructs an empty list
    public SimpleLinkedList() {
        head = null;
    }

    // Returns true if the list is empty
    public boolean isEmpty() {
        return head == null;
    }


    // Inserts a new node at the beginning of this list
    public void addFirst(String item) {
        Node temp = new Node(item, head);
        head = temp;
    }

    // Inserts a new node to the end of this list
    public String addLast(String item) {

        if (isEmpty()) {
            addFirst(item);
        } else {
            Node current = head;
            while (current.next != null) current = current.next;

            current.next = new Node(item, head);


        }
        return item;

    }
}


