package org.benz.linkedlist;

import org.benz.common.Node;

public class LinkedList {

	private Node start;
	private Node end;

	/**
	 * Inserting at the Start
	 * 
	 * @param name
	 * @param value
	 */
	public void insertFirst(String name, int value) {
		Node newNode = new Node(name, value);
		if (null == start) {
			start = newNode;
			end = newNode;
		} else {
			newNode.setNext(start);
			start.setPrev(newNode);
			start = newNode;
		}

	}

	/**
	 * Inserting nodes at the end
	 * 
	 * @param name
	 * @param value
	 */
	public void insertLast(String name, int value) {
		Node newNode = new Node(name, value);
		if (null == end) {
			start = newNode;
			end = newNode;
		} else {
			newNode.setPrev(end);
			end.setNext(newNode);
			end = newNode;
		}
	}

	/**
	 * Utility method for printing from start
	 * 
	 */
	public void printLinkedListFromStart() {
		if (null != start) {
			Node node = start;
			while (node != null) {
				System.out.println("printing Node:{" + node.getName() + "," + node.getKey() + "}");
				node = node.getNext();
			}
		}
	}
	
	public void printLinkedList(Node start) {
		if (null != start) {
			Node node = start;
			while (node != null) {
				System.out.println("printing Node:{" + node.getName() + "," + node.getKey() + "}");
				node = node.getNext();
			}
		}
	}

	/**
	 * Utility method to print from end
	 */
	public void printLinkedListFromEnd() {
		if (null != end) {
			Node node = end;
			while (node != null) {
				System.out.println("printing Node:{" + node.getName() + "," + node.getKey() + "}");
				node = node.getPrev();
			}
		}
	}

	public Node findNode(int value) {
		Node node = null;
		node = start;
		while (node != null) {
			if (node.getKey() == value) {
				System.out.println("Found Node {" + node.getName() + "," + node.getKey() + "}");
				return node;
			}
			node = node.getNext();
		}
		if (node == null) {
			System.out.println("Node not found");
		}
		return node;
	}

	public Node deleteDuplicate(Node head) {

		Node curr = head;
		Node prev = head;
		Node next = prev;
		int num = 0;

		while (curr != null) {
			if (curr.getKey() != prev.getKey()) {
				prev.setNext(curr);
				prev = prev.getNext();
				num++;
			}
			curr = curr.getNext();
		}
		if (num == 0) {
			prev.setNext(null);
			head.setNext(null);
		}
		return next;

	}

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

}
