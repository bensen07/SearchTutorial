package org.benz.logic;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println("Check prime Number Start");
		int num = 34;
		boolean isprime = true;
		for (int i = 2; i < num / 2; i++) {
			System.out.println("Checking " + i);
			if (num % i == 0) {
				System.out.println("Not prime");
				isprime = false;
				break;
			}
		}
		if (isprime) {
			System.out.println("Its prime Number");
		}
		System.out.println("Check prime Number Ends");
	}

}
