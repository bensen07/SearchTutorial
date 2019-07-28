package org.benz.sort;

public class HeapSortTest {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 5, 90, 100, 60, 55, 65 };
		printArr(arr);
		/*
		 * Create Heap
		 */
		for (int i = arr.length / 2; i >= 0; i--) {
			maxHeapify(arr, arr.length, i);
			
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			maxHeapify(arr, i, 0);
			System.out.println();
			printArr(arr);
		}

		System.out.println("Final Sorted");
		printArr(arr);
	}

	public static void maxHeapify(int[] arr, int heapSize, int parentIndex) {
		int leftIndex = (2 * parentIndex) + 1;
		int rightIndex = (2 * parentIndex) + 2;
		int largest = parentIndex;

		if (leftIndex < heapSize && arr[leftIndex] > arr[largest]) {
			largest = leftIndex;
		}

		if (rightIndex < heapSize && arr[rightIndex] > arr[largest]) {
			largest = rightIndex;
		}

		if (largest != parentIndex) {
			swap(arr, largest, parentIndex);
			maxHeapify(arr, heapSize, largest);
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
