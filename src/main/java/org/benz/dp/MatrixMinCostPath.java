package org.benz.dp;

public class MatrixMinCostPath {

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println("MinCostPath " + minCostPath(cost, 2, 2));
	}

	public static int minCostPath(int[][] cost, int row, int col) {
		// int row = cost.length;
		// int col = cost[0].length;
		printArray(cost);
		System.out.println();

		int[][] dp = new int[row + 1][col + 1];
		dp[0][0] = cost[0][0];
		printArray(dp);
		System.out.println();

		for (int i = 1; i <= row; i++) {
			dp[i][0] = dp[i - 1][0] + cost[i][0];
		}
		printArray(dp);
		System.out.println();
		for (int j = 1; j <= col; j++) {
			dp[0][j] = dp[0][j - 1] + cost[0][j];
		}
		printArray(dp);
		System.out.println();

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + cost[i][j];
			}
		}
		printArray(dp);
		System.out.println();

		return dp[row][col];
	}

	private static void printArray(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ,");
			}
			System.out.println();
		}
	}

}
