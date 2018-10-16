package org.benz.common;

public class StockPrices {

	public static void main(String[] args) {

		int[] arr = { 110, 60, 40, 90, 120, 90 };
		System.out.println("MaxProfit " + maxProfit(arr));
	}

	public static int maxProfit(int[] arr) {

		int[] dp = new int[arr.length];

		dp[0] = 0;
		int minValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			dp[i] = Math.max(dp[i - 1], arr[i] - minValue);
			minValue = Math.min(minValue, arr[i]);
			System.out.println("Minvalue:" + minValue);
		}

		return dp[arr.length - 1];

	}

}
