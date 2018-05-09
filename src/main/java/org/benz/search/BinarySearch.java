package org.benz.search;

import org.benz.sort.QuickSort;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 50, 10, 15, 25, 20, 35, 30 };
		int search = 11;
		QuickSort.quickSort(arr, 0, arr.length - 1);
		boolean found = binarySearch(arr, 0, arr.length - 1, search);
		if (found) {
			System.out.println("Found " + search);
		} else {
			System.out.println("Not Found");
		}
	}

	public static boolean binarySearch(int[] arr, int start, int end, int key) {
		boolean found = false;
		if (start < end) {
			int middle = start + (end - start) / 2;
			if (arr[middle] == key) {
				return true;
			}
			if (key < arr[middle]) {
				found = binarySearch(arr, start, middle, key);
			}
			if (key > arr[middle]) {
				found = binarySearch(arr, middle + 1, end, key);
			}
		}
		return found;
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
