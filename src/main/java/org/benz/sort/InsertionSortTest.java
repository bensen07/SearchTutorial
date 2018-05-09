package org.benz.sort;

public class InsertionSortTest {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 5, 90, 100, 60, 55, 65 };
		System.out.println("Initial");
		printArr(arr);
		insertionSort(arr);
		System.out.println("Final");
		printArr(arr);
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length ; i++) {

			int startIndex = i;
			while (startIndex > 0) {
				if (arr[startIndex] < arr[startIndex - 1]) {
					swap(arr, startIndex, startIndex - 1);
				}
				startIndex--;
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
