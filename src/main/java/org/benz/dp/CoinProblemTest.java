package org.benz.dp;

public class CoinProblemTest {

	public static void main(String[] args) {
		int coin[] = { 2, 3, 4, 6 };
		int total = 8;
		ways(coin, total);
	}

	public static int ways(int[] coin, int sum) {

		int[][] dp = new int[coin.length + 1][sum + 1];

		// for (int i = 0; i <= coin.length; i++) {
		// dp[i][0] = 1;
		// }
		//
		// for (int i = 1; i <= coin.length; i++) {
		// for (int j = 1; j <= sum; j++) {
		// if (j >= coin[i-1]) {
		// dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i-1]];
		// } else {
		// dp[i][j] = dp[i - 1][j];
		// }
		// }
		// }

		// for sum 0, no coins are needed so total ways is 1Ï
		for (int i = 0; i <= coin.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= coin.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coin[i - 1] < j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coin[i - 1]]);
				}
			}
		}

		print(dp);
		return 0;

	}

	public static void print(int[][] arr) {

		int row = arr.length;
		int col = arr[0].length;

		System.out.println("Row:" + row + " - Col:" + col + "\n");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
}
