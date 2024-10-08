package org.example.primeNumbers;

import org.example.primeNumbers.abstraction.PrimeChecker;
import java.util.ArrayList;
import java.util.List;

public class PrimeFinderService {
    private final int numberOfThreads;
    private final PrimeChecker primeChecker;

    public PrimeFinderService(int numberOfThreads, PrimeChecker primeChecker) {
        this.numberOfThreads = numberOfThreads;
        this.primeChecker = primeChecker;
    }

    public List<Integer> findPrimes(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        List<PrimeFinderServiceThread> threads = new ArrayList<>();
        int rangeSize = (end - start + 1) / numberOfThreads;

        // Split the range across threads
        for (int i = 0; i < numberOfThreads; i++) {
            int rangeStart = start + i * rangeSize;
            int rangeEnd = (i == numberOfThreads - 1) ? end : rangeStart + rangeSize - 1;

            // Create and start PrimeFinderServiceThread
            PrimeFinderServiceThread thread = new PrimeFinderServiceThread(this, rangeStart, rangeEnd);
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to complete
        for (PrimeFinderServiceThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Collect results from all threads
        for (PrimeFinderServiceThread thread : threads) {
            synchronized (primes) {
                primes.addAll(thread.getPrimes());
            }
        }

        return primes;
    }

    // Delegate prime checking to the PrimeChecker
    public List<Integer> findPrimesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (primeChecker.isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }
}
