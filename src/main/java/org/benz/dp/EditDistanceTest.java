package org.benz.dp;

public class EditDistanceTest {

	public static void main(String[] args) {
		String src = "Saturday";
		String dest = "Sunday";
		System.out.println("MinEdit " + editDistance(src, dest));
	}

	public static int editDistance(String src, String dest) {

		int dp[][] = new int[src.length() + 1][dest.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= src.length(); i++) {
			for (int j = 1; j <= dest.length(); j++) {
				if (src.charAt(i - 1) == dest.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}

		return dp[src.length()][dest.length()];
	}

}
