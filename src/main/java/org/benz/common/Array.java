package org.benz.common;

public class Array {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 1, 2, 3, 5, 9 };
		binarySearch(arr, 0, arr.length - 1);
	}

	static int findStartPoistion(int[] arr) {
		int pos = 0;

		if (null == arr || (null != arr && arr.length == 0)) {
			throw new IllegalArgumentException("Source is null");
		}

		if (arr.length == 1) {
			pos = 0;
			return pos;
		}

		int start = 0;
		int end = arr.length;

		int middle = 0;

		while (true) {
			middle = (start + end) / 2;
			System.out.println("Middle " + middle);

			if (middle >= end) {
				throw new IllegalArgumentException("Not Found");

			}
			if (arr[middle - 1] > arr[middle] && arr[middle] > arr[middle + 1]) {

				return middle + 1;
			} else {
				start = middle + 1;
				end = arr.length;

			}
		}

	}

	static int binarySearch(int[] arr, int start, int end) {
		System.out.println("Start:" + start + " & End:" + end);
		int mid = start + (end - start) / 2;

		System.out.println("Mid " + mid);

		if (end < start) {
			return 0;
		}

		if (mid < end && arr[mid] > arr[mid + 1]) {
			System.out.println("Found mid+1 " + (mid + 1));
			return mid + 1;
		}
		if (mid > start && arr[mid - 1] > arr[mid]) {
			System.out.println("Found Mid " + mid);
			return mid;
		}

		if (arr[end] > arr[mid]) {
			return binarySearch(arr, start, mid - 1);
		}

		return binarySearch(arr, mid + 1, end);
	}

}
