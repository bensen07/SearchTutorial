package org.benz.logic;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String test = "restful";
		String val = "fluster";

		if (test.length() != val.length()) {
			System.out.println("Not an Anagram");
		} else {
			char[] testVal = test.toCharArray();
			for (int i = 0; i < testVal.length; i++) {
				for (int j = 0; j < val.length(); j++) {
					if (testVal[i] == val.charAt(j)) {
						System.out.println("Match Found " + testVal[i] + " at " + j);
						if (j < val.length()) {
							val = val.substring(0, j) + val.substring(j + 1, val.length());
							System.out.println("New String " + val);
						}
					}
				}
			}
			if (val.length() > 0) {
				System.out.println("Not Anagram");
			} else {
				System.out.println("Ïts an Anagram");
			}
		}

		System.out.println("New Way");
		isAnagram("fluster", test);
	}

	public static void isAnagram(String src, String dest) {

		char[] srcChars = src.toCharArray();
		Arrays.sort(srcChars);
		String newSrc = String.valueOf(srcChars);
		char[] destChars = dest.toCharArray();
		Arrays.sort(destChars);
		String newDest = String.valueOf(destChars);

		System.out.println("Comparing " + newSrc + " and " + newDest);

		if (newSrc.equals(newDest)) {
			System.out.println("Is Anagram");
		} else {
			System.out.println("Not Anagram");
		}

	}

}
