import java.io.*;
import java.util.*;
import java.lang.Math;

public class SuperPrime {
    public static boolean isPrime(int n, int d) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        if (n % d == 0)
            return false;
        if (d >= (int)Math.sqrt(n)) {
            return true;
        } else {
            return isPrime(n, d+2);
        }
    }
    public static boolean isSuperPrime(int n) {
        String nstr = n + "";
        String shortnstr = nstr.substring(0,nstr.length()-1);
        int shortn = Integer.parseInt(shortnstr);
        boolean bothCheckOut = isPrime(n,3) && isPrime(shortn,3);
        return bothCheckOut;
    }
    //might use sieve for later 
    public static void sieve(int upperBound) {
        int upperBoundSquareRoot = (int)Math.sqrt(upperBound);
        boolean[] isComposite = new boolean[upperBound+1];
        for (int i = 2; i <= upperBoundSquareRoot; i++) {
            if (!isComposite[i]) {
                System.out.print(i + " ");
                for (int j = i * i; j <= upperBound; j += i) {
                    isComposite[j] = true;
                }
            }
        } 
        for (int i = upperBoundSquareRoot; i <= upperBound; i++) {
            if (!isComposite[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public static void getSuperPrimes(int digits) {
        boolean arePrimes = false;
        int counter = 0;
        for (int i = (int)Math.pow(10,digits-1); i < (int)Math.pow(10,digits); i++) {
            if (isSuperPrime(i)) {
                arePrimes = true;
                counter++;
                System.out.println(i);
            }
        }
        if (!arePrimes) {
            System.out.println("there are no " + digits + " digit primes");
        } else {
            System.out.println("there are " + counter + " " + digits + " digit super primes");
        }
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        getSuperPrimes(6);
        long endTime = System.currentTimeMillis();
        System.out.println("Took "+(endTime - startTime) + " ns"); 
        //sieve(100);
    }
}
