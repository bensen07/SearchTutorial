package org.benz.common;

public class MergeIntervals {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 6, 8, 11, 12, 13, 14, 18, 19, 20 };
		System.out.println(combineIntervals(arr));
	}

	public static String combineIntervals(int[] arr) {
		StringBuilder str = new StringBuilder();

		if (null == arr || (null != arr && arr.length == 0)) {
			throw new IllegalArgumentException("No Source Array");
		}

		int start = arr[0];
		int prev = arr[0];
		boolean isContinous = false;
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - 1 == prev) {
				isContinous = true;
			} else {

				if (!isContinous) {
					str.append(start).append(",");
				} else {
					str.append(start).append("-").append(prev).append(",");
				}

				start = arr[i];
				isContinous = false;
			}
			prev = arr[i];

		}

		// Handle Last Element Scenario
		if (isContinous) {
			str.append(start).append("-").append(prev).append(",");
		} else {
			str.append(prev).append(",");
		}

		return str.toString();
	}

}
