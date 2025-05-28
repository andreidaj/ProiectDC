package bench.cpu;

import benchmark.IBenchmark;
import logging.ILogger;
import timing.ITimer;

public class CPUFixedPoint implements IBenchmark {
    private final ILogger logger;
    private final ITimer timer;
    private final int iterations;

    public CPUFixedPoint(ILogger logger, ITimer timer, int iterations) {
        this.logger = logger;
        this.timer = timer;
        this.iterations = iterations;
    }

    @Override
    public void setUp() {
        // Warm-up: simple integer ops
        int x = 0;
        for (int i = 0; i < 1_000_000; i++) {
            x += i;
            x *= 2;
        }
    }

    @Override
    public void run() {
        setUp();

        int result = 0;
        timer.start();

        for (int i = 0; i < iterations; i++) {
            result += i;
            result *= 2;
            result ^= (i << 1);
            result /= 3;
            result %= 1000;
        }

        timer.stop();
        double timeSec = timer.getElapsedTimeInMillis() / 1000.0;

        double mops = iterations / timeSec / 1_000_000;
        logger.log("Fixed-point MOPS: " + String.format("%.2f", mops));
    }
}
