package org.example.primeNumbers;

import java.util.List;

public class PrimeFinderServiceThread extends Thread {
    private final PrimeFinderService primeFinderService;
    private final int start;
    private final int end;
    private List<Integer> primes;

    public PrimeFinderServiceThread(PrimeFinderService primeFinderService, int start, int end) {
        this.primeFinderService = primeFinderService;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is finding primes in range: " + start + " to " + end);
        primes = primeFinderService.findPrimesInRange(start, end);
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
