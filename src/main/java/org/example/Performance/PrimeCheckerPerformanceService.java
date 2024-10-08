package org.example.Performance;

import org.example.primeNumbers.abstraction.PrimeChecker;
import org.example.primeNumbers.PrimeFinderService;

import java.util.List;

public class PrimeCheckerPerformanceService implements PrimeCheckerPerformanceTest {

    @Override
    public long measureExecutionTime(int start, int end, PrimeChecker primeChecker, int numberOfThreads) {
        PrimeFinderService service = new PrimeFinderService(numberOfThreads, primeChecker);
        long startTime = System.nanoTime();

        List<Integer> primes = service.findPrimes(start, end);

        long endTime = System.nanoTime();
        System.out.println("Found " + primes.size() + " primes.");

        return (endTime - startTime) / 1_000_000; // Convert to milliseconds
    }


}
