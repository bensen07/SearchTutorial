package org.benz.sort;

public class BubbleSort {

	public static void main(String[] args) {
		System.out.println("Bubble Sort Start");

		int[] unordered = new int[10];
		unordered[0] = 20;
		unordered[1] = 10;
		unordered[2] = 100;
		unordered[3] = 60;
		unordered[4] = 40;
		unordered[5] = 80;
		unordered[6] = 90;
		unordered[7] = 70;
		unordered[8] = 30;
		unordered[9] = 50;

		for (int out = unordered.length - 1; out > 1; out--) {
			// System.out.println("OUT " + unordered[out]);
			for (int in = 0; in < out; in++) {
				System.out.println("Comparing " + unordered[in] + " -- " + unordered[in + 1]);
				if (unordered[in] > unordered[in + 1]) {
					System.out.println("Change " + unordered[in] + " -- " + unordered[in + 1]);
					int temp = unordered[in];
					unordered[in] = unordered[in + 1];
					unordered[in + 1] = temp;
					for (int i = 0; i < unordered.length; i++) {
						System.out.print("" + unordered[i]+",");
					}
				}
			}
		}
	}
}
