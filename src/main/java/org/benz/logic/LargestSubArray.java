package org.benz.logic;

public class LargestSubArray {

	public static void main(String[] args) {

		int[] in = { 1, 2, -1, -3, 5, -1, 2 };
		findSumOfLargestArray(in);
	}

	private static int findSumOfLargestArray(int[] in) {
		int currMax = 0;
		int maxNow = 0;
		int start = 0, end = 0;

		currMax = in[0];
		maxNow = in[0];

		for (int i = 1; i < in.length; i++) {
			currMax += in[i];
			if (maxNow < currMax) {
				maxNow = currMax;
				end = i;
			}
			if (currMax < 0) {
				start = i + 1;
				maxNow = 0;
			}
		}
		System.out.println("Start:" + start + "-End:" + end);
		System.out.println("MaxSum " + maxNow);
		return maxNow;
	}

}
