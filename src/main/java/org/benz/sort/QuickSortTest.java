package org.benz.sort;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 5, 90, 100, 60, 55, 65 };
		System.out.println("Initial");
		printArr(arr);
		quickSort(arr, 0, arr.length - 1);
		System.out.println("Final");
		printArr(arr);
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {

			int i = start;
			int j = end;
			int middle = start + (end - start) / 2;

			while (arr[i] < arr[middle]) {
				i++;
			}

			while (arr[j] > arr[middle]) {
				j--;
			}

			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
			if (i < end) {
				quickSort(arr, i, end);

			}
			if (j > start) {
				quickSort(arr, start, j);
			}

		}

	}

	public static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
