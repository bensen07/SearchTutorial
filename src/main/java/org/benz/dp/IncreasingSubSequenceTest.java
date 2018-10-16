package org.benz.dp;

import java.util.Arrays;

public class IncreasingSubSequenceTest {

	public static void main(String[] args) {

		int arr[] = { 3, 6, 4, 5, 8, 10 };
		System.out.println("Increasing SubSequenceLength " + incSequenceLength(arr));
	}

	public static int incSequenceLength(int[] arr) {

		int dp[] = new int[arr.length];

		Arrays.fill(dp, 1);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		return dp[arr.length-1];
	}

}
