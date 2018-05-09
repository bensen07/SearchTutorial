package org.benz.logic;

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("Fibonacci Series Start");
		int count = 10;
		noLoop(count);
		recursiveLogic(count);
		System.out.println("Fibonacci Series End");
	}

	private static void noLoop(int count) {
		System.out.println("NoLoop Start");
		int a = 0;
		int b = 1;
		int c = 0;

		System.out.println(a);
		System.out.println(b);
		for (int i = 0; i < count - 2; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.println(c);
		}
		System.out.println("NoLoop End");
	}

	private static void recursiveLogic(int count) {
		System.out.println("RecursiveLogic Start");
		int a = 0;
		int b = 1;

		System.out.println(a);
		System.out.println(b);
		recFib(count - 2, a, b);
		System.out.println("RecursiveLogic End");
	}

	private static void recFib(int count, int a, int b) {
		if (count > 0) {
			int c = a + b;
			a = b;
			b = c;
			System.out.println(c);
			recFib(count - 1, a, b);
		}
	}

}
