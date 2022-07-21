package com.zacisrael;

public class List {

   public class Node{
       public String data;
       public Node next;

       public Node(String data, Node next) {
           this.data = data;
           this.next = next;
       }
   }

   Node head;

   public boolean isEmpty(){
       return head == null;
   }
   public void addLast(String item){
       if(isEmpty()){
           head = new Node(item,null);
       }else {
           Node current = head;
           while(current.next != null){
               current = current.next;
           }
           current.next = new Node(item,null);
       }

   }
   public void reverse(){
       Node current = head;
       Node prev = null;
       Node next = null;

       while(current != null){
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       head = prev;
   }

   public void printList(){
       Node node = head;
       while (node != null) {
           System.out.print(node.data + " -> ");
           node = node.next;
       }
       System.out.println("NULL");
   }

    public static void main(String[] args) {
        List list = new List();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");

        list.printList();
        list.reverse();
        list.printList();
    }

}


