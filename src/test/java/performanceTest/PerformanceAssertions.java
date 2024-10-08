package performanceTest;

import org.junit.jupiter.api.Assertions;


public class PerformanceAssertions {
    public static void assertExecutionTime(long duration, long maxDuration) {
    Assertions.assertTrue(duration <= maxDuration, "Execution time exceeded: " + duration + " ms (Max allowed: " + maxDuration + " ms)");
}
}
