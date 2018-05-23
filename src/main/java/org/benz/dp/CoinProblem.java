package org.benz.dp;

import java.util.Arrays;

public class CoinProblem {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int c = coinChange(coins, 4);
		System.out.println("Total ways " + c);
	}

	public static int coinChange(int[] coins, int n) {
		int[] dp = new int[n + 1];

		Arrays.fill(dp, 0);

		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= n; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		return dp[n];
	}

	public static void print(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");

	}
}
