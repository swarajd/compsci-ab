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
		/*
		if (d >= (int)Math.sqrt(n))
			return true;
		else
			return isPrime(n, d+2);
		*/
	}
	
	static boolean isSuperPrime(int n) {
		String strnum = n + "";
		int strlen = strnum.length();
		if (strlen == 1) {
			return isPrime(n,3);
		} else {
			String shortnum = strnum.substring(0,strlen-1);
			if (isPrime(n,3)) {
				return isSuperPrime(Integer.parseInt(shortnum));
			} else {
				return false;
			}
		}
	}
	
	static void getSuperPrimes(int n) {
	
		int init = (int)Math.pow(10,n-1);
		int N = init * 10;
		
		boolean exists = false;
		int counter = 0;
		
		boolean[] primeArr = new boolean[N + 1];
		
		
		for (int i = 2; i <= N; i++) {
			primeArr[i] = true;
		}
		
		for (int i = 2; i*i <= N; i++) {
			if (primeArr[i]) {
				for (int j = i; i*j <= N; j++) {
					primeArr[i*j] = false;
				}
			}
		}
		
		long startTime = System.currentTimeMillis();

		for (int i = init; i <= N; i++) {
			if (primeArr[i]) {
				if (isSuperPrime(i)) {
					counter++;
					exists = true;
					System.out.println(i);
				}	
			}
		}
		
		long endTime = System.currentTimeMillis();
		/*for (int i = init; i < init * 10; i += 2) {
			if (isSuperPrime(i)) {
				counter++;
				exists = true;
				System.out.println(i);
			}
		}*/
		if (exists) {
			System.out.println("There are " + counter + " super primes with " + n + " digits");
		} else {
			System.out.println("There are no super primes with " + n + " digits");
		}
		System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.print("how many digits: ");
		int digits = user.nextInt();
		getSuperPrimes(digits);
	}
}

