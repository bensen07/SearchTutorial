package org.benz.stack;

public class StackTutorial {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(50);

		System.out.println("pop " + stack.pop());
		System.out.println("peek " + stack.peek());
		System.out.println("pop " + stack.pop());
		System.out.println("pop " + stack.pop());
		System.out.println("pop " + stack.pop());

		PostFix postFix = new PostFix("(A+B)*(C/D)+F");
		System.out.println("Trans: " + postFix.doTrans());
	}

}
