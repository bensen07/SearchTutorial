package org.benz.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 5, 90, 100, 60, 55, 65 };
		System.out.println("Current Arr");

		printArr(arr);
		System.out.println("");
		mergeSort(arr, 0, arr.length - 1);
		printArr(arr);
	}

	private static void mergeSort(int[] arr, int start, int end) {
		System.out.println("MergeSort " + start + " to " + end);
		printArr(arr, start, end);
		System.out.println();
		if (start < end) {
			int middle = start + (end - start) / 2;

			mergeSort(arr, start, middle);
			mergeSort(arr, middle + 1, end);

			merge(arr, start, middle, end);
		}
	}

	private static void merge(int[] arr, int start, int middle, int end) {
		System.out.println("Merging " + start + " - " + middle + " - " + end);
		printArr(arr, start, end);
		System.out.println("");
		int[] helper = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			helper[i] = arr[i];
		}

		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle && j <= end) {
			if (helper[i] < helper[j]) {
				arr[k] = helper[i];
				i++;
			} else {
				arr[k] = helper[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			arr[k] = helper[i];
			i++;
			k++;
		}

		printArr(arr, start, end);
		System.out.println("\nAfter Merging");
	}

	/**
	 * Utility method to print
	 * 
	 * @param arr
	 */
	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	private static void printArr(int[] arr, int start, int end) {
		for (int i = start; i < end; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
