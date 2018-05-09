package org.benz.linkedlist;

import org.benz.common.Node;

public class Traversal {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertFirst("Benson", 34);
		list.insertFirst("Blessy", 34);
		list.insertFirst("Jainy", 30);
		list.insertFirst("Blessen", 38);
		list.insertFirst("Jerry", 4);

		list.printLinkedListFromStart();
		System.out.println("From End");
		list.printLinkedListFromEnd();

		list.insertLast("pappa", 68);
		list.insertLast("Mummy", 65);

		System.out.println("After Inserting from last");
		list.printLinkedListFromStart();
		System.out.println("From End");
		list.printLinkedListFromEnd();

		list.findNode(40);

		LinkedList listA = new LinkedList();
		listA.insertFirst("", 3);
		listA.insertFirst("", 10);
		listA.insertFirst("", 12);
		listA.insertFirst("", 15);
		listA.insertFirst("", 20);

		LinkedList listB = new LinkedList();
		listB.insertFirst("", 22);
		listB.insertFirst("", 22);
		listB.insertFirst("", 11);
		listB.insertFirst("", 22);
		listB.insertFirst("", 22);
		listB.insertFirst("", 22);

		System.out.println("Delete Dup");
		Node node = listB.deleteDuplicate(listB.getStart());
		listB.printLinkedList(node);

		Node head = new Node("Root", 0);
		Node n = null;
		Node prev = null;
		Node fourth = null;

		for (int i = 1; i < 7; i++) {
			prev = n;
			n = new Node("Node" + i, i);
			if (i == 1) {
				head.setNext(n);
			} else {
				prev.setNext(n);
			}
			if (i == 4) {
				fourth = n;
			}
		}

		System.out.println("print new Linked list ");
		listB.printLinkedList(head);

		findMiddle(head);

		n.setNext(fourth);
		System.out.println("Find Loop");
		System.out.println("IsLoop " + isLoop(head));

		System.out.println("Find Start of Loop");
		findNodeAtLoopStart(head);

	}

	private static Node findMiddle(Node head) {
		Node middle = null;
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		System.out.println("Middle Node " + slow.getKey() + "-" + slow.getName());

		return middle;

	}

	private static boolean isLoop(Node head) {
		boolean isLoop = false;

		Node slow = head;
		Node fast = head;

		while (fast != null) {

			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (slow.getKey() == fast.getKey()) {
				System.out.println("Stuck at Node " + slow.getKey() + "-" + slow.getName());
				return true;
			}
		}

		return isLoop;

	}

	public static Node findNodeAtLoopStart(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.getNext() != null) {

			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow.getKey() == fast.getKey()) {
				System.out.println("Loop detected");
				break;
			}
		}

		slow = head;

		while (fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext();
			if (slow.getKey() == fast.getKey()) {
				System.out.println("Found Start of Loop " + slow.getKey() + "-" + slow.getName());
				break;
			}
		}

		return slow;

	}

}
