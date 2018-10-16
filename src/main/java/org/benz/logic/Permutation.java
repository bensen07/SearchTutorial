package org.benz.logic;

public class Permutation {

	public static void main(String[] args) {

		String src = "ABCDE";

		permutation("", src);
	}

	private static void permutation(String prefix, String src) {

		int len = src.length();
		//System.out.println("Len: " + len);
		if (len == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < len; i++) {

				char s = src.charAt(i);
				//System.out.println("Currently working on " + s);
				StringBuilder str = new StringBuilder();
				str.append(src.substring(0, i)).append(src.substring(i + 1, len));
				//System.out.println("Remaining String " + str.toString());

				permutation(prefix + s, str.toString());

			}
		}
	}

}
