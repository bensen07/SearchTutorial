package org.benz.logic;

import java.util.Stack;

public class Span {

	public static void main(String[] args) {

		int[] arg = { 7, 6, 5, 8, 6, 10 };
		Stack<Integer> currMax = new Stack<Integer>();

		int[] result = new int[arg.length];

		result[0] = 1;
		currMax.push(0);
		for (int i = 1; i < arg.length; i++) {
			System.out.println("Starting for index:" + i + "-Value:" + arg[i]);
			System.out.println("Stack " + currMax);
			while (!currMax.isEmpty() && arg[i] >= arg[currMax.peek()]) {
				System.out.println("poping " + currMax.peek());
				currMax.pop();

			}
			System.out.println("After poping Stack  " + currMax);
			result[i] = currMax.empty() ? (i + 1) : i - currMax.peek().intValue();
			System.out.println("Adding [" + i + "] " + (currMax.empty() ? (i + 1) : i - currMax.peek().intValue()));

			currMax.push(i);

		}

		for (int i = 0; i < arg.length; i++) {
			System.out.print(result[i] + " ,");
		}
	}
}
