package org.benz.dp;

/**
 * Count number of ways to climb n stairs using 1, 2 or 3 steps at a time
 * 
 * @author George
 *
 */
public class Steps {

	public static void main(String[] args) {
		System.out.println("Rec Stairs " + climbStairsRec(5));
		System.out.println("DP Stairs " + climbStairsDP(5));

	}

	public static int climbStairsRec(int n) {

		if (n == 1 || n == 0) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return climbStairsRec(n - 1) + climbStairsRec(n - 2) + climbStairsRec(n - 3);
		}

	}

	public static int climbStairsDP(int n) {

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[0] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		return dp[n];
	}

}
