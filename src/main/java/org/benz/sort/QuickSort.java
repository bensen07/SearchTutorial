package org.benz.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 50, 30, 5, 25, 20, 15, 35 };
		System.out.println("Current Arr");

		printArr(arr);
		System.out.println("");
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);

	}

	/**
	 * Recursive method to do quickSort
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] arr, int start, int end) {
		System.out.println("QuickSort " + start + " - " + end);
		if (start < end) {
			int i = start;
			int j = end;

			int median = start + (end - start) / 2;
			System.out.println("Median Value " + arr[median]);

			while (arr[i] < arr[median]) {
				i++;
			}

			while (arr[j] > arr[median]) {
				j--;
			}

			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
			printArr(arr);
			if (j > start) {
				System.out.println("Starting Left Side");
				quickSort(arr, start, j);
			}
			if (i < end) {
				System.out.println("Starting Right Side");
				quickSort(arr, i, end);
			}
		}
	}

	/**
	 * Utility method to do Swap
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " & " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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

}
