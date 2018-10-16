package org.benz.logic;

public class MatrixRotation {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(arr);
		// transpose(arr);
		// print(arr);
		// reverseMatrix(arr);
		//rotateMatrixInplace(arr);
		rotate(arr, arr.length);
		print(arr);
	}

	public static void transpose(int[][] arr) {
		System.out.println("Transpose");
		int row = arr.length;
		int col = arr[0].length;

		System.out.println("Row:" + row + " - Col:" + col);

		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {

				System.out.println("Swapping arr[" + i + "][" + j + "]:" + arr[i][j] + " and arr[" + j + "][" + i + "]:"
						+ arr[j][i]);
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		System.out.println("End Transpose");
	}

	private static void reverseMatrix(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0, k = col - 1; j < k; j++, k--) {
				int temp = arr[j][i];
				arr[j][i] = arr[k][i];
				arr[k][i] = temp;
			}
		}

	}

	// public static void rotate(int[][] matrix, int n) {
	// for (int layer = 0; layer < n / 2; ++layer) {
	// int first = layer;
	// int last = n - 1 - layer;
	// System.out.println("Layer:" + layer + ", First:" + first + ", Last:" + last);
	// for (int i = first; i < last; ++i) {
	// int offset = i - first;
	// System.out.println("Offset:" + offset);
	//
	// System.out.println("Swapping matrix[" + first + "][" + i + "]:" +
	// matrix[first][i] + " with matrix[" + i
	// + "][" + last + "]:" + matrix[i][last]);
	// int top = matrix[first][i]; // save top
	//
	// // left -> top
	// System.out.println("Swapping matrix[" + (last - offset) + "][" + first + "]:"
	// + matrix[last - offset][first] + " with matrix[" + first + "][" + i + "]:" +
	// matrix[first][i]);

	// matrix[first][i] = matrix[last - offset][first];
	//
	// // bottom -> left
	// System.out.println("Swapping matrix[" + (last) + "][" + (last - offset) +
	// "]:"
	// + matrix[last][last - offset] + " with matrix[" + (last - offset) + "][" +
	// first + "]:"
	// + matrix[last - offset][first]);

	// matrix[last - offset][first] = matrix[last][last - offset];
	//
	// // right -> bottom
	// System.out.println("Swapping matrix[" + (i) + "][" + (last) + "]:" +
	// matrix[i][last] + " with matrix["
	// + (last) + "][" + last + "]:" + matrix[last - offset][first]);
	//

	// matrix[last][last - offset] = matrix[i][last];

	// // top -> right
	// matrix[i][last] = top; // right <- saved top
	// }
	// }
	// }

	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; layer++) {
			System.out.println("Working on Layer:" + layer);
			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; ++i) {
				int offset = i - first;
				System.out.println(
						" I:" + i + "\n first:" + first + "\n last:" + last + "\n last-offset:" + (last - offset));
				int top = matrix[first][i];
				// Replacing values in first row with values from first column of each row
				matrix[first][i] = matrix[last - offset][first];

				// Replacing value of first column of each row with value from last row
				matrix[last - offset][first] = matrix[last][last - offset];

				// Replacing last row with value from from last column of each row
				matrix[last][last - offset] = matrix[i][last];

				// Replacing last column of each row with first row data
				matrix[i][last] = top;

			}

		}

	}

	public static void rotateMatrixInplace(int[][] matrix) {
		int length = matrix.length - 1;

		for (int i = 0; i <= (length) / 2; i++) {
			for (int j = i; j < length - i; j++) {

				// Coordinate 1
				System.out.println("taking " + i + "" + j);
				int p1 = matrix[i][j];

				// Coordinate 2
				System.out.println("taking " + j + "" + (length - i));
				int p2 = matrix[j][length - i];

				// Coordinate 3
				System.out.println("taking " + (length - i) + "" + (length - j));
				int p3 = matrix[length - i][length - j];

				// Coordinate 4
				System.out.println("taking " + (length - j) + "" + i);
				int p4 = matrix[length - j][i];

				// Swap values of 4 coordinates.
				matrix[j][length - i] = p1;
				matrix[length - i][length - j] = p2;
				matrix[length - j][i] = p3;
				matrix[i][j] = p4;
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
