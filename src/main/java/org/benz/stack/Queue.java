package org.benz.stack;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

	private List<T> vals;
	private int front;
	private int rear;

	public Queue() {
		this.vals = new ArrayList<T>();
		this.front = 0;
		this.rear = -1;
	}

	public void enque(T val) {
		this.vals.add(++rear, val);
	}

	public T deque() {

		rear--;

		return this.vals.remove(front);
	}

}
