package com.bridgelabz.www;

public class LinkedList {
	Node head;

	public class Node {

		Object data;
		Node next;

		public Node(Object data) {
			this.data = data;
		}
	}

	public void addFirst(Object data) {
		Node newNode = new Node(data);

		if (head == null)
			head = newNode;
		else {
			Node temp = head;
			head = newNode;
			head.next = temp;

		}
	}

	public void addLast(Object data) {
		Node newNode = new Node(data);
		if (head == null)
			head = newNode;
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void deleteFirst() {
		if (head == null)
			System.out.println("No elements to delete...");
		else if (head.next == null)
			head = null;
		else {

			Node temp = head.next;
			head = temp;

		}
	}

	public void deleteLast() {
		if (head == null)
			System.out.println("No elements to delete...");
		else if (head.next == null)
			head = null;
		else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}
	}

	public void display() {
		if (head == null)
			System.out.println("No elements to display...");
		else if (head.next == null)
			System.out.println(head.data);
		else {
			Node temp = head;
			while (temp != null) {
				if (temp.next != null)
					System.out.print(temp.data + "==>");
				else
					System.out.print(temp.data + "\n");
				temp = temp.next;
			}
		}
	}

	public void search(Object searchData) {
		if (head.data == searchData)
			System.out.println(searchData + " is Found");
		else {
			Node temp = head;

			boolean isFound = false;

			while (temp != null) {
				if (temp.data == searchData) {
					isFound = true;
					break;
				}

				temp = temp.next;
			}

			if (isFound == true)
				System.out.println(searchData + " is Found");
			else
				System.out.println(searchData + " is not found..");
		}
	}

	public int size() {
		int count = 0;

		Node temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;

	}

	public void insertAtSpecificIndex(int userIndex, Object data) {

		// User trying to insert @ first position
		if (userIndex == 0)
			addFirst(data);

		// User trying to insert @ last position
		else if (userIndex == size())
			addLast(data);

		// User trying to insert @ invalid position
		else if (userIndex < 0 || userIndex >= size())
			System.out.println("Invalid index");

		// User trying to insert @ specific index
		else {
			// Creating New Node
			Node newNode = new Node(data);

			// To track traversing
			int index = 0;

			// Pointers to track left & right side elements
			Node left = head;
			Node right = left.next;

			// Traverse or Move till last element before user entered index
			while (index < userIndex - 1) {
				left = left.next;
				right = right.next;
				index++;
			}
			// Connecting new Node with right side elements
			newNode.next = right;
			
			// Connecting left side elements with new Node
			left.next = newNode;
		}
	}
	
	public void deleteAtSpecificIndex(int userIndex)
    {
        if (userIndex == 0)
            deleteFirst();
        else if (userIndex == size())
            deleteLast();
        else
        {
            int index=1;   // userIndex=1
            Node left=head;
            Node right=head.next;
           
            while(index<userIndex)
            {
                left=left.next;
                right=right.next;
                index++;
            }
           
            left.next = right.next;
           
        }
    }
}
