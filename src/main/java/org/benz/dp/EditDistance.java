package org.benz.dp;

public class EditDistance {

	public static void main(String[] args) {
		String src = "sunday";
		String dest = "saturday";
		System.out.println("Edit Distance " + editDst(src, dest));
	}

	public static int editDst(String src, String dest) {

		int m = src.length();
		int n = dest.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (src.charAt(i - 1) == dest.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]);
				}
			}
		}

		return dp[m][n];
	}

}
