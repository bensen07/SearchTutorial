package org.benz.common;

public class MatrixRotation {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(arr);
		transpose(arr);
		System.out.println("after transpose");
		print(arr);
		reverseMatrix(arr);
		System.out.println("after reverse");
		print(arr);
	}

	static void transpose(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

	}

	static void reverseMatrix(int[][] arr) {

		int row = arr.length;
		int col = arr[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0, k = col-1; j < k; j++, k--) {
				int temp = arr[j][i];
				arr[j][i] = arr[k][i];
				arr[k][i] = temp;
			}
		}

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
