package org.benz.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Traingleperimeter {

	public static void main(String[] args) {
		//System.out.println("Entering Triangleperimeter");
		Scanner scanner = new Scanner(System.in);
		
		int totalNumSides = Integer.parseInt(scanner.nextLine());
		int a, b, c, totalperimeter = 0;
		StringBuilder strBuilder = null;
		List<String> sideList = null;
		String sides = scanner.nextLine();
		scanner.close();
		if (null != sides) {
			sideList = Arrays.asList(sides.split(" "));
			//System.out.println("sideList " + sideList);
			if (totalNumSides != sideList.size()) {
				throw new IllegalArgumentException("Total Num of Sides doesnt match the inputs providedÏ");
			}
		}
		if (null != sideList) {

			for (int i = 0; i < totalNumSides - 1; i++) {
				a = Integer.parseInt(sideList.get(i));
				b = Integer.parseInt(sideList.get(i + 1));
				// System.out.println(a + "," + b);
				for (int j = i + 2; j < totalNumSides; j++) {
					c = Integer.parseInt(sideList.get(j));
					System.out.println(a + "," + b + "," + c);
					if ((a + b) <= c) {
						continue;
					} else {
						if (totalperimeter < (a + b + c)) {
							totalperimeter = (a + b + c);
							strBuilder = new StringBuilder(String.valueOf(a)).append(" ").append(b).append(" ")
									.append(c);
							System.out.println("New Sides " + strBuilder.toString());
							System.out.println("New Total perimeter " + totalperimeter);
						}
					}
				}

			}

			if (null == strBuilder) {
				strBuilder = new StringBuilder("-1");
			}
		}
		System.out.println(strBuilder.toString());
	}

}
