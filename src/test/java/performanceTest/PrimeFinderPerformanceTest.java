package performanceTest;

import org.example.Performance.PrimeCheckerPerformanceService;
import org.example.Performance.PrimeCheckerPerformanceTest;
import org.example.primeNumbers.abstraction.PrimeChecker;
import org.example.primeNumbers.algorithm.SievePrimeChecker;
import org.example.primeNumbers.algorithm.SimplePrimeChecker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrimeFinderPerformanceTest {

    private static PrimeChecker simpleChecker;
    private static PrimeChecker sieveChecker;
    private static PrimeCheckerPerformanceTest performanceTester;

    @BeforeAll
    static void setUp() {
        simpleChecker = new SimplePrimeChecker();
        sieveChecker = new SievePrimeChecker();
        performanceTester = new PrimeCheckerPerformanceService();
    }

    @Test
    void testSimpleCheckerWithSmallRange() {
        int start = 2;
        int end = 1000;
        int numberOfThreads = 4;
        long maxDuration = 1000; // ms

        long duration = performanceTester.measureExecutionTime(start, end, simpleChecker, numberOfThreads);
        PerformanceAssertions.assertExecutionTime(duration, maxDuration);
    }

    @Test
    void testSieveCheckerWithSmallRange() {
        int start = 2;
        int end = 1000;
        int numberOfThreads = 4;
        long maxDuration = 500; // ms

        long duration = performanceTester.measureExecutionTime(start, end, sieveChecker, numberOfThreads);
        PerformanceAssertions.assertExecutionTime(duration, maxDuration);
    }

    @Test
    void testSimpleCheckerWithLargeRange() {
        int start = 2;
        int end = 100000;
        int numberOfThreads = 4;
        long maxDuration = 5000; // ms

        long duration = performanceTester.measureExecutionTime(start, end, simpleChecker, numberOfThreads);
        PerformanceAssertions.assertExecutionTime(duration, maxDuration);
    }

    @Test
    void testSieveCheckerWithLargeRange() {
        int start = 2;
        int end = 100000;
        int numberOfThreads = 4;
        long maxDuration = 3000; // ms

        long duration = performanceTester.measureExecutionTime(start, end, sieveChecker, numberOfThreads);
        PerformanceAssertions.assertExecutionTime(duration, maxDuration);
    }
}
