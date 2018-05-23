package org.benz.stack;

public class SortStack {

	public static void main(String[] args) {

		java.util.Stack<Integer> source = new java.util.Stack<Integer>();

		source.push(20);
		source.push(10);
		source.push(50);
		source.push(30);
		source.push(40);
		source.push(0);

		System.out.println("UnSorted " + source);

		System.out.println("Sorted " + sort(source));

	}

	public static java.util.Stack<Integer> sort(java.util.Stack<Integer> src) {
		java.util.Stack<Integer> result = null;

		if (null != src && !src.isEmpty()) {
			result = new java.util.Stack<Integer>();

			while (!src.isEmpty()) {

				int tmp = src.pop();
				while (!result.isEmpty() && result.peek() > tmp) {
					src.push(result.pop());

				}
				result.push(tmp);

			}

		}
		return result;
	}

}
