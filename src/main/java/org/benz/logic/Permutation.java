
package org.benz.logic;

public class Permutation {

	public static void main(String[] args) {

		String src = "ABCDE";

		permutation("", src);

		// combString(src);
	}

	private static void permutation(String prefix, String src) {
		System.out.println("Permutation of " + prefix + " && " + src);
		int len = src.length();
		// System.out.println("Len: " + len);
		if (len == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < len; i++) {

				char s = src.charAt(i);
				// System.out.println("Currently working on " + s);
				StringBuilder str = new StringBuilder();
				str.append(src.substring(0, i)).append(src.substring(i + 1, len));
				// System.out.println("Remaining String " + str.toString());

				permutation(prefix + s, str.toString());

			}
		}
	}

	public static void combString(String s) {
		// Print initial string, as only the alterations will be printed later
		System.out.println(s);
		char[] a = s.toCharArray();
		int n = a.length;
		int[] p = new int[n]; // Weight index control array initially all zeros. Of course, same size of the
								// char array.
		int i = 1; // Upper bound index. i.e: if string is "abc" then index i could be at "c"
		while (i < n) {
			if (p[i] < i) { // if the weight index is bigger or the same it means that we have already
							// switched between these i,j (one iteration before).
				int j = ((i % 2) == 0) ? 0 : p[i];// Lower bound index. i.e: if string is "abc" then j index will always
													// be 0.
				swap(a, i, j);
				// Print current
				System.out.println(join(a));
				p[i]++; // Adding 1 to the specific weight that relates to the char array.
				i = 1; // if i was 2 (for example), after the swap we now need to swap for i=1
			} else {
				p[i] = 0;// Weight index will be zero because one iteration before, it was 1 (for
							// example) to indicate that char array a[i] swapped.
				i++;// i index will have the option to go forward in the char array for "longer
					// swaps"
			}
		}
	}

	private static String join(char[] a) {
		StringBuilder builder = new StringBuilder();
		builder.append(a);
		return builder.toString();
	}

	private static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
