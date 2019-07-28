package org.benz.common;

public class KElements {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 60, 90 };
		int pos = binarySearch(arr, 0, arr.length - 1, 50);

		System.out.println("Pos " + pos + " val:" + arr[pos]);
	}

	static int binarySearch(int[] arr, int start, int end, int n) {
		int middle = start + (end - start) / 2;
		System.out.println("Start: " + start + " middle:" + middle + " end:" + end);
		if (arr[middle] == n) {
			return middle;
		}

		if (arr[middle] < n && arr[middle + 1] > n) {
			return middle;
		}

		if (n > arr[middle]) {
			return binarySearch(arr, middle + 1, end, n);
		}

		return binarySearch(arr, start, middle - 1, n);

	}

}
