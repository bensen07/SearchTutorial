package org.benz.stack;

public class PostFix {

	private Stack<String> opStack;
	private String expression;

	public PostFix(String expression) {
		this.opStack = new Stack<String>();
		this.expression = expression;
	}

	public String doTrans() {
		StringBuilder transExp = new StringBuilder();
		char[] chars = expression.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];

			switch (c) {
			case '+':
			case '-':
				String s = foundOperator(c, 1);
				if (null != s) {
					transExp.append(s);
				}
				break;
			case '/':
			case '*':
				String t = foundOperator(c, 2);
				if (null != t) {
					transExp.append(t);
				}
				break;
			case '(':
				opStack.push(String.valueOf(c));
				break;
			case ')':
				String x = foundRightparen();
				if (null != x) {
					transExp.append(x);
				}
				break;
			default:
				transExp.append(c);

			}

		}
		if (!opStack.isEmpty()) {
			while (!opStack.isEmpty()) {
				transExp.append(opStack.pop());
			}
		}
		opStack.printStack();
		return transExp.toString();

	}

	private String foundOperator(char c, int priority) {
		System.out.println("Found Operator" + c + ":" + priority);
		if (opStack.isEmpty()) {
			opStack.push(String.valueOf(c));
			return null;
		}
		String stackTopOp = opStack.pop();
		int stackTopOppriority = getpriority(stackTopOp);
		System.out.println("StackTopOp:" + stackTopOp + ", priority:" + stackTopOppriority);

		if (stackTopOppriority < priority || stackTopOp.equals("(")) {
			opStack.push(stackTopOp);
			opStack.push(String.valueOf(c));
		} else {
			opStack.push(String.valueOf(c));
			return stackTopOp;
		}
		return null;
	}

	private int getpriority(String operator) {

		int priority = 0;
		if (null != operator) {
			switch (operator) {
			case "+":
			case "-":
				priority = 1;
				break;
			case "/":
			case "*":
				priority = 2;
				break;
			default:
				break;
			}
		}
		return priority;
	}

	private String foundRightparen() {
		StringBuilder sBuilder = new StringBuilder();
		while (true) {
			String s = opStack.pop();
			if (s.equals("("))
				break;
			sBuilder.append(s);
		}

		return sBuilder.toString();

	}
}
