package org.benz.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

	private List<T> vals;
	private int top;

	public Stack() {
		this.vals = new ArrayList<T>();
		this.top = -1;
	}

	public void push(T val) {
		this.vals.add(val);
		this.top++;
	}

	public T pop() {
		if (top < 0) {
			return null;
		}
		return this.vals.remove(top--);
	}

	public T peek() {
		if (top < 0) {
			return null;
		}
		return this.vals.get(top);
	}

	public boolean isEmpty() {
		return this.vals.isEmpty();
	}

	public void printStack() {
		System.out.println("Stack " + this.vals);
	}
}
