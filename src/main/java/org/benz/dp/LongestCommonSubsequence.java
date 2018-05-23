package org.benz.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String src = "AGGTAB";
		String dest = "GXTXAYB";
		System.out.println("LCS " + lcs(src.toCharArray(), dest.toCharArray()));
	}

	public static int lcs(char[] src, char[] dest) {
		int m = src.length;
		int n = dest.length;

		int[][] lcs = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (src[i - 1] == dest[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;

				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}

			}
		}
		return lcs[m][n];
	}

}
