package org.benz.common;

public class Node {

	private String name;
	private int key;
	private Node next;
	private Node prev;

	public Node(String name, int value) {
		this.name = name;
		this.key = value;
	}

	public Node(String name, int value, Node next, Node prev) {
		this.name = name;
		this.key = value;
		this.next = next;
		this.prev = prev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		if (((Node) obj).getKey() == this.key && this.name.equalsIgnoreCase(((Node) obj).getName())) {
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public int hashCode() {
//		int hashCode = 37 * this.key + 37 * this.getName().hashCode();
//		return hashCode;
//	}

}
