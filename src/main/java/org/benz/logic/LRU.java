package org.benz.logic;

import java.util.HashMap;
import java.util.Map;

public class LRU {

	public static void main(String[] args) {

		LRUCache c = new LRUCache(3);
		c.set("A", 10);
		c.set("B", 3);
		c.set("C", 6);
		c.set("D", 5);
		c.set("E", 2);
		System.out.println(c.get("B"));
		System.out.println(c.get("A"));

	}

}

class LRUCache {
	int capacity = 0;
	int count = 0;
	Node head;
	Node end;
	Map<String, Node> cache;
	Map<String, Node> dataStore;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		cache = new HashMap<String, Node>();
		dataStore = new HashMap<String, Node>();
	}

	public int get(String key) {
		System.out.println("Get " + key);
		System.out.println("Current Cache " + cache);
		if (cache.containsKey(key)) {
			reArrangeNodes(cache.get(key));
			setHead(cache.get(key));
			System.out.println("Found in Cache " + cache.get(key).getVal());
			return cache.get(key).getVal();
		} else {
			Node n = fetchData(key);
			if (null == n) {
				System.out.println("Element Not Found in Store");
				return -1;
			}
			cache.remove(end.getKey());
			cache.put(key, n);
			reArrangeNodes(end);
			setHead(n);
			System.out.println("Not Found in Cache. Inserting into cache " + n);
			System.out.println("Current Cache " + cache);
			System.out.println("Head: " + head + " End: " + end);

			return n.getVal();
		}
	}

	public Node fetchData(String key) {
		System.out.println("Fetch Node for " + key);
		System.out.println("Head: " + head + " End: " + end);
		Node t = dataStore.get(key);
		System.out.println("Found Node " + t);
		return t;
	}

	public Node searchData(String key, Node t) {
		System.out.println("Currently Inspecting " + t);
		if (t != null) {
			if (!t.getKey().equalsIgnoreCase(key)) {
				searchData(key, t.getNext());
			} else {
				return t;
			}
		}
		return null;
	}

	public void set(String key, int value) {
		System.out.println("Set " + key + ":" + value);
		if (!cache.containsKey(key)) {
			System.out.println("Not present in cache. Create and Insert");
			Node newNode = new Node(key, value);
			dataStore.put(key, newNode);
			if (cache.size() >= capacity) {

				cache.remove(end.getKey());
				reArrangeNodes(end);

			}

			setHead(newNode);
			cache.put(key, newNode);
			System.out.println("Current Cache after setting " + cache);
		} else {
			System.out.println("Found in cache");
			Node temp = cache.get(key);
			reArrangeNodes(temp);

			setHead(temp);
			System.out.println("Current cache after rearranging " + cache);
		}

	}

	private void setHead(Node temp) {
		if (head == null) {
			head = temp;
			end = temp;
		} else {
			temp.setPrev(null);
			temp.setNext(head);
			head.setPrev(temp);
			if (head.getNext() == null) {
				end = head;
			}
			head = temp;
		}
	}

	private void reArrangeNodes(Node temp) {
		System.out.println("Remove and Rearrange " + temp);
		if (temp.getPrev() != null) {
			temp.getPrev().setNext(temp.getNext());
		} else {
			head = temp.getNext();
		}

		if (temp.getNext() != null) {

			temp.getNext().setPrev(temp.getPrev());
		} else {
			end = temp.getPrev();
		}
	}
}

class Node {
	private String key;
	private int val;
	private Node prev;
	private Node next;

	public Node(String key, int val) {
		this.key = key;
		this.val = val;
	}

	public Node(String key, int val, Node prev, Node next) {
		this.key = key;
		this.val = val;
		this.prev = prev;
		this.next = next;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return new StringBuilder("{").append("key:").append(key).append(",").append("value:").append(val).append("}")
				.toString();
	}

}