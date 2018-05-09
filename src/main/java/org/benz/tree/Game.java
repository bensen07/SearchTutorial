package org.benz.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	static List<Double> valArray = new ArrayList<Double>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the val");
		int startVal = scanner.nextInt();
		scanner.close();
		rec(startVal);
		System.out.println(valArray.size());
	}

	public static void rec(float val) {
		System.out.println("Rec for Val: " + val);
		valArray.add(new Double(val));
		if (val <= 1)
			return;
		rec(val / 2);
		rec(val - 1);
	}

}
