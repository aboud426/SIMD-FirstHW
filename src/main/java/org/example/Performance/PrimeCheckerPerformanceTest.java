package org.example.Performance;

import org.example.primeNumbers.abstraction.PrimeChecker;

public interface PrimeCheckerPerformanceTest {
    long measureExecutionTime(int start, int end, PrimeChecker primeChecker, int numberOfThreads);

}
