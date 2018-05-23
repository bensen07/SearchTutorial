package org.benz.logic;

import java.util.Arrays;

public class CoinProblem {

	public static void main(String[] args) {
		int[] coins = { 1,2,3 };
		long c = coinChange(coins, 4);
		System.out.println("Total ways " + c);
	}

	public static long coinChange(int[] coins, int n) {

		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < coins.length; i++) {
			System.out.println("Working with Coin:" + coins[i]);
			for (int j = coins[i]; j <= n; j++) {
				System.out.println("table[" + j + "]=" + table[j]);
				System.out.println("table[" + j + "-" + coins[i] + "]=" + table[j - coins[i]]);
				table[j] += table[j - coins[i]];
				System.out.println("New Table[" + j + "]=" + table[j]);
			}
			print(table);
		}

		return table[n];
	}

	public static void print(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");

	}
}
