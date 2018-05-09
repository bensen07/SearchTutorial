package org.benz.sort;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter number of elements");
			int len = scanner.nextInt();
			int[] sortArray = new int[len];

			System.out.println("Enter " + len + " element:");
			scanner.useDelimiter("\\s");
			int i = 0;
			while (i < len) {
				sortArray[i++] = scanner.nextInt();
			}
			print(sortArray);

			for (int j = 1; j < sortArray.length; j++) {
				int startIndex = j;
				int sortVal = sortArray[j];
				System.out.println("Comparing SortVal:" + sortVal + " ArrayVal[" + (startIndex - 1) + "]:"
						+ sortArray[startIndex - 1]);
				while (startIndex > 0 && sortVal < sortArray[startIndex - 1]) {
					System.out.println("Shift and Insert Val " + sortVal);
					sortArray[startIndex] = sortArray[startIndex - 1];
					sortArray[startIndex - 1] = sortVal;
					print(sortArray);
					startIndex--;
				}
			}
		} finally {
			scanner.close();
		}
	}

	static void print(int[] array) {
		System.out.println("printing array");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
