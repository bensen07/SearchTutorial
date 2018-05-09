package org.benz.sort;

public class BubbleSortTest {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 5, 90, 100, 60, 55, 65 };
		System.out.println("Initial");
		printArr(arr);
		bubbleSort(arr);
		System.out.println("Final");
		printArr(arr);
	}

	public static void bubbleSort(int[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) {

			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
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
