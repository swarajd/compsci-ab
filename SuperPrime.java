import java.io.*;
import java.util.Scanner;

class SuperPrime {
    
    public static boolean[] primeArr;
    
    static boolean isSuperPrime(int n) {
        if (n%10 == n) {
            return primeArr[n];
        } else {
            String strnum = n + "";
            int strlen = strnum.length();
            String shortnum = strnum.substring(0,strlen-1);
            if (primeArr[n]) {
                return isSuperPrime(Integer.parseInt(shortnum));
            } else {
                return false;
            }
        }
    }
    
    static void getSuperPrimes(int n) {
    
        int init;
        int N;
        if (n == 1) {
            init = 1;
            N = 10;
        } else {
            init = (int)Math.pow(10,n-1);
            N = init * 10;
        }
        
        boolean exists = false;
        int counter = 0;
        
        SuperPrime.primeArr = new boolean[N + 1];
        
        long startTime = System.currentTimeMillis();
        
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
        if (n == 1) {
            for (int i = init+1; i <= N; i ++) {
                if (primeArr[i]) {
                    if (isSuperPrime(i)) {
                        counter++;
                        exists = true;
                        System.out.println(i);
                    }   
                }
            }
        } else {
            for (int i = init+1; i <= N; i += 2) {
                if (primeArr[i]) {
                    if (isSuperPrime(i)) {
                        counter++;
                        exists = true;
                        System.out.println(i);
                    }   
                }
            }
        }
        
        long endTime = System.currentTimeMillis();
        if (exists) {
            System.out.println("There are " + counter + " super primes with " + n + " digits");
        } else {
            System.out.println("There are no super primes with " + n + " digits");
        }
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        while(true) {
            System.out.print("how many digits: ");
            int digits = user.nextInt();
            getSuperPrimes(digits);
        }
    }
}

