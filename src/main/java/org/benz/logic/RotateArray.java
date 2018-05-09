package org.benz.logic;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {

	public static void main(String[] args) {
		int[] data = new int[] { 1, 2, 4, 5, 8, 9, 10 };
		int b = 36;
		List<Integer> output = new ArrayList<Integer>();

		int startIndex = b;
		int size = data.length;

		int tempIndex = startIndex%size;
		
		
		for (int i = tempIndex; i < size; i++) {
			output.add(data[i]);
		}

		for (int i = 0; i < tempIndex; i++) {
			output.add(data[i]);
		}

		System.out.print(output);
	}

}
