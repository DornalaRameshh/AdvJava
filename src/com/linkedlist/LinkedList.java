package com.linkedlist;

// Node class representing each element in the linked list
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the list
}

// LinkedList class representing the linked list
public class LinkedList {
    Node head; // Head (first node) of the linked list

    // Method to insert a new node at the end of the list
    public void insert(int data){
        // Create a new node and set its data
        Node node = new Node();
        node.data = data;

        // If the linked list is empty, make the new node the head
        if (head == null) {
            head = node;
        } else {
            // Otherwise, traverse to the end of the list
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            // Insert the new node at the end
            n.next = node;
        }
    }

    // Method to display the nodes in the list
    public void show(){
        // Start from the head node
        Node n = head;
        // Traverse the list until the end
        while (n != null) {
            // Print the data of each node
            System.out.print(n.data + "->");
            n = n.next;
        }
        // Print null at the end to indicate the end of the list
        System.out.println("null");
    }

    // Method to insert a new node at the beginning of the list
    public void insertAtStart(int data){
        // Create a new node and set its data
        Node node = new Node();
        node.data = data;
        // Make the new node's next point to the current head
        node.next = head;
        // Update the head to be the new node
        head = node;
    }

    // Method to delete the first node in the list
    public void deleteFirst(){
        // If the list is empty, print a message and return
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // Update the head to point to the second node
        head = head.next;
    }

    // Method to delete the last node in the list
    public void deleteLast(){
        // If the list is empty, print a message and return
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // If the list has only one node, set head to null
        if (head.next == null) {
            head = null;
            return;
        }

        // Traverse the list to find the second-to-last node
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            secondLast = secondLast.next;
            lastNode = lastNode.next;
        }
        // Set the second-to-last node's next to null, removing the last node
        secondLast.next = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements into the list
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // Display the initial list
        System.out.print("Initial List: ");
        list.show();

        // Insert an element at the start of the list
        list.insertAtStart(5);
        System.out.print("After inserting 5 at the beginning: ");
        list.show();

        // Delete the first element of the list
        list.deleteFirst();
        System.out.print("After deleting the first node: ");
        list.show();

        // Delete the last element of the list
        list.deleteLast();
        System.out.print("After deleting the last node: ");
        list.show();
    }
}
