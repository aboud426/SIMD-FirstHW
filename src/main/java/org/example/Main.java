package org.example;

import org.example.Performance.PrimeCheckerPerformanceService;
import org.example.primeNumbers.abstraction.PrimeChecker;
import org.example.primeNumbers.algorithm.SievePrimeChecker;
import org.example.primeNumbers.algorithm.SimplePrimeChecker;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main() {
        PrimeChecker simpleChecker = new SimplePrimeChecker();
        PrimeChecker sieveChecker = new SievePrimeChecker();

        PrimeCheckerPerformanceService performanceTester = new PrimeCheckerPerformanceService();

        // Define the configurations
        List<Integer> ranges = Arrays.asList(1000, 10000, 100000);
        List<Integer> threadCounts = Arrays.asList(1, 2, 4, 8);

        System.out.println("Performance testing with different ranges, threads, and algorithms:");

        for (int range : ranges) {
            for (int threadCount : threadCounts) {
                System.out.println("\nRange: " + range + ", Threads: " + threadCount);

                System.out.println("Using SimplePrimeChecker:");
                runPerformanceTest(performanceTester, simpleChecker, range, threadCount);

                System.out.println("Using SievePrimeChecker:");
                runPerformanceTest(performanceTester, sieveChecker, range, threadCount);
            }
        }
    }

    private static void runPerformanceTest(PrimeCheckerPerformanceService tester, PrimeChecker checker, int range, int threads) {
        int start = 2;
        int end = range;
        long duration = tester.measureExecutionTime(start, end, checker, threads);
        System.out.println("Execution time: " + duration + " ms");
    }
}
