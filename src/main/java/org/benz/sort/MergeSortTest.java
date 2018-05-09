package org.benz.sort;

public class MergeSortTest {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 5, 90, 100, 60, 55, 65 };
		System.out.println("Initial");
		printArr(arr);
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("Final");
		printArr(arr);
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int middle = start + (end - start) / 2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle + 1, end);
			merge(arr, start, middle, end);
		}
	}

	public static void merge(int[] arr, int start, int middle, int end) {

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
