package org.benz.logic;

import java.util.Stack;

public class TowersOfHanoi {

	public static void main(String[] args) {

		int n = 5;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[1], towers[2]);
		towers[1].print();

	}

}

class Tower {

	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<Integer>();
		this.index = i;
	}

	public int index() {
		return this.index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() < d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t) {
		if (!disks.isEmpty()) {
			int top = disks.pop();
			t.add(top);
			System.out.println("Moved disk:" + top + " from Tower:" + this.index + " to Tower:" + t.index());
		}
	}

	public void print() {
		System.out.println("Contents of Tower " + index());
		for (int i = disks.size() - 1; i >= 0; i--) {
			System.out.println("" + disks.get(i));
		}
	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		System.out.println("Entering Move " + (n) + " disks from Tower:" + index() + " to Destination:"
				+ destination.index() + " and Buffer:" + buffer.index());
		if (n > 0) {

			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
		System.out.println("Exiting Move " + (n) + " disks from Tower:" + index() + " to Destination:"
				+ destination.index() + " and Buffer:" + buffer.index());
	}

}
