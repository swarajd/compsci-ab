import java.io.*;
import java.util.Scanner;

class SuperPrime {

	static boolean isPrime(int n, int d) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		if (n % d == 0)
			return false;
		if (d >= (int)Math.sqrt(n))
			return true;
		else
			return isPrime(n, d+2);
	}
	
	static boolean isSuperPrime(int n) {
		String strnum = n + "";
		int strlen = strnum.length();
		if (strlen == 1) {
			return isPrime(n,3);
		} else {
			String shortnum = strnum.substring(0,strlen-1);
			boolean checksOut = isPrime(n,3) && isSuperPrime(Integer.parseInt(shortnum));
			return checksOut;
		}
	}
	
	static void getSuperPrimes(int n) {
		boolean exists = false;
		int counter = 0;
		long startTime = System.currentTimeMillis();
		for (int i = (int)Math.pow(10,n-1)+1; i < (int)Math.pow(10,n); i = i + 2) {
			if (isSuperPrime(i)) {
				counter++;
				exists = true;
				System.out.println(i);
			}
		}
		if (exists) {
			System.out.println("There are " + counter + " super primes with " + n + " digits");
		} else {
			System.out.println("There are no super primes with " + n + " digits");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.print("how many digits: ");
		int digits = user.nextInt();
		getSuperPrimes(digits);
	}
}

