package org.benz.sort;

public class SelectionSort {

	public static void main(String[] args) {
		System.out.println("Selection Sort Start");

		int[] unordered = new int[10];
		int min, out, in = 0;
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

		for (out = 0; out < unordered.length - 1; out++) {
			 System.out.println("OUT " + unordered[out]);
			min = out;

			for (in = out + 1; in < unordered.length; in++) {
				System.out.println("Comparing " + unordered[in] + " -- " + unordered[min]);
				if (unordered[in] < unordered[min]) {
					System.out.println("Change " + unordered[in] + " -- " + unordered[min]);
					min = in;
				}
			}
			int temp = unordered[min];
			unordered[min] = unordered[out];
			unordered[out] = temp;
			//printArray(unordered);

		}
		System.out.println("** Final Sort");
		printArray(unordered);
	}

	private static void printArray(int[] unordered) {
		for (int i = 0; i < unordered.length; i++) {
			System.out.println("New List " + unordered[i]);
		}
	}

}
