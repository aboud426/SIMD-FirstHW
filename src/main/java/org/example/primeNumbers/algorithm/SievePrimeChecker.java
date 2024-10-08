package org.example.primeNumbers.algorithm;

import org.example.primeNumbers.abstraction.PrimeChecker;

import java.util.ArrayList;
import java.util.List;

public class SievePrimeChecker implements PrimeChecker {
    @Override
    public boolean isPrime(int number) {
        // This method could use precomputed data or optimizations if necessary
        return sieve(number).contains(number);
    }

    // Generates a list of primes up to max using the Sieve of Eratosthenes
    private List<Integer> sieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) isPrime[i] = true;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }
}
