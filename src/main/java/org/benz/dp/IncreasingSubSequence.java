package org.benz.dp;

import java.util.Arrays;

public class IncreasingSubSequence {

	public static void main(String[] args) {
		int[] arr = { 3, 10, 2, 1, 20 };
		System.out.println("MaxSequence " + incSubSequence(arr));
	}

	public static int incSubSequence(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int max = 1;
		int[] ls = new int[arr.length];

		Arrays.fill(ls, 1);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && ls[i] < ls[j] + 1) {
					ls[i] = ls[j] + 1;
					if (max <= ls[i]) {
						max = ls[i];
					}
				}
			}
		}

		return max;
	}

}
