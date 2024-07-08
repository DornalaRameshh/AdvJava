package com.linkedlist;

public class LinkedList {
    Node head;

    // Method to insert a new node at the end of the list
    public void insert(int data){
        Node node = new Node();
        node.data = data;
        //node.next = null;  // Newly created node will have its next as null

        // If head is null, make the new node as head
        if (head == null) {
            head = node;
        } else {
            // Traverse to the end of the list and insert the new node there
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    // Method to display the nodes in the list
    public void show(){
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("null");
    }
}
