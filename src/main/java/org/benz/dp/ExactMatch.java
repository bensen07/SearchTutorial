package org.benz.dp;

import java.util.Scanner;

public class ExactMatch {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.print("Enter Source String");
			String src = scanner.nextLine();

			System.out.print("Enter Query String");
			String query = scanner.nextLine();

			System.out.println("Src String:" + src + " Query String:" + query);

			bruteForceMatch(src, query);
			dpSolution(src, query);

		} catch (Exception e) {

		}

	}

	private static void dpSolution(String src, String query) {
		int row = src.length() + 1;
		int col = query.length() + 1;

		boolean[][] dp = new boolean[row][col];

		dp[0][0] = true;

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {

				if (src.charAt(i - 1) == query.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] || true;
				} else {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}

			}
		}
		printArray(dp);
		System.out.println("Dp[" + src.length() + "][" + query.length() + "]: " + dp[src.length()][query.length()]);

	}

	private static void bruteForceMatch(String src, String query) {
		int queryLength = query.length();
		System.out.println("queryLength " + queryLength);
		int len = 0;
		boolean found = false;
		int startIndex = 0;
		while (!found) {

			startIndex = src.indexOf(query.charAt(0), startIndex);
			System.out.println("StartIndex :" + startIndex);
			if (startIndex == -1) {
				found = false;
				break;
			}

			len = 0;
			while (len <= query.length()) {

				System.out.println("Matching " + src.charAt(startIndex) + " && " + query.charAt(len));
				if (src.charAt(startIndex) == query.charAt(len)) {
					len++;
					startIndex++;
					System.out.println("Updated Index:" + startIndex + " && " + len);
				} else {
					System.out.println("Break");
					break;
				}

				if (len == query.length()) {
					found = true;
					break;
				}

			}

			if (found) {
				break;
			}

		}

		if (!found) {
			System.out.println("Brute Force Not Found");
		} else {
			System.out.println("Brute Force Found");
		}
	}

	private static void printArray(boolean[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ,");
			}
			System.out.println();
		}
	}
}
