package org.benz.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {
	static {
		x = 5;
	}

	static int x, y;

	public static void main(String[] args) {
		System.out.println(5%9);
	}

	private static void test() {
		System.out.println("Entering");
		List<Integer> vals = new ArrayList<Integer>();

		vals.add(10);
		vals.add(20);
		vals.add(30);
		BigDecimal total = BigDecimal.ZERO;
		vals.forEach(val -> {
			total.add(new BigDecimal(val.intValue()));
		});

		System.out.println(String.format("Total: %d", total.intValue()));
	}
}
