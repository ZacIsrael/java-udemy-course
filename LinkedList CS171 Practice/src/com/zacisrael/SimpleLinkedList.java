package com.zacisrael;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList implements SimpleList {

    private class Node{
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.data;
        }
    }

    private Node head;

    public SimpleLinkedList() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(String item) {
        Node temp = new Node(item, head);
        head = temp;
    }

    @Override
    public void addLast(String item) {
        if(isEmpty()){
            addFirst(item);
        } else{
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            // By this point, current.next == null
            current.next = new Node(item, null);
        }
    }

    @Override
    public String getFirst() {
        if(isEmpty()) throw new NoSuchElementException("list is empty");
        return head.data;
    }

    @Override
    public String getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        Node current = head;
        while(current.next != null) current = current.next;
        return current.data;
    }

    @Override
    public String get(int pos) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("list is empty");
        }
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
            if(temp == null) {
                throw new IndexOutOfBoundsException("LinkedList is not long enough. Position is a higher number than the length of the LinkedList.");
            }
        }
        return temp.data;
    }

    @Override
    public String removeFirst() {
        String temp = getFirst();
        head = head.next; // The beginning is now referencing to the next head
        return temp;
    }

    @Override
    public void remove(String key) {
        if(isEmpty()) throw new RuntimeException("cannot delete");

        if(head.data.equals(key)){
            head = head.next; // The beginning is now referencing to the next head
            return;
        }
        Node cur = head;
        Node prev = null;
        while(cur != null && !cur.data.equals(key)){
            prev = cur;
            cur = cur.next;
        }
        if(cur == null) throw new RuntimeException("cannot delete: item does not exist");
        prev.next = cur.next;
    }

    @Override
    public String toString() {
        String output = "";
        if(head == null) throw new NoSuchElementException();
        Node temp = head;
        while(temp != null){
            output += temp + " -> ";
            temp = temp.next;
        }
        output += "[NULL]";
        return output;
    }
    private class MyLinkedListIterator implements Iterator{
        private Node nextNode;

        public MyLinkedListIterator(Node nextNode) {
            this.nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public String next() {
            if(!hasNext()) throw new  NoSuchElementException();
            String res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
