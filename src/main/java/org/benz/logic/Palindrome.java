package org.benz.logic;

public class Palindrome {

	public static void main(String[] args) {
		String test = "tooot";
		StringBuffer s = new StringBuffer();
		for (int i = test.length() - 1; i >= 0; i--) {
			System.out.println("Char At " + test.charAt(i));
			s.append(test.charAt(i));
			System.out.println("New Reverse String " + s.toString());

		}
		System.out.println("Reverse String " + s.toString());
		if (s.toString().equalsIgnoreCase(test)) {
			System.out.println(String.format("%s is a palindrome", s.toString()));
		} else {
			System.out.println(String.format("%s is not a palindrome", s.toString()));
		}

		System.out.println("Doing another way");
		palindrome(test);
	}

	public static void palindrome(String val) {
		int n = val.length();
		for (int i = 0; i < n / 2; i++) {
			if (val.charAt(i) != val.charAt(n - i - 1)) {
				System.out.println("Not palindrome");
				return;
			}
		}
		System.out.println("Is palindrome");

	}

}
