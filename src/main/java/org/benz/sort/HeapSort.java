package org.benz.sort;

public class HeapSort {

	public static void main(String[] args) {

		System.out.println("Entering");
		int[] arr = new int[] { 30, 25, 50, 10, 5, 15, 55, 60 };
		printArr(arr);
		int heapSize = arr.length;
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			// System.out.println("\nHeapify " + i);
			heapify(arr, arr.length, i);
			printArr(arr);
		}

		for (int i = heapSize - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
			printArr(arr);

		}
		System.out.println("Final");
		printArr(arr);
	}

	private static void heapify(int[] arr, int heapSize, int parent) {
		System.out.println("Heapify " + heapSize + " & node: " + parent);
		int parentVal = arr[parent];

		int left = calculateLeftIndex(parent);
		int right = calculateRightIndex(parent);
		int largest = parent;

		if (left < heapSize && arr[largest] < arr[left]) {
			largest = left;
		}

		if (right < heapSize && arr[largest] < arr[right]) {
			largest = right;
		}

		if (largest != parent) {
			swap(arr, parent, largest);

			heapify(arr, heapSize, largest);
		}

	}

	private static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " - " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int calculateLeftIndex(int parent) {
		int index = (2 * parent) + 1;
		System.out.println("LeftIndex:" + index);
		return index;
	}

	private static int calculateRightIndex(int parent) {
		int index = (2 * parent) + 2;
		System.out.println("RightIndex:" + index);
		return index;
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
