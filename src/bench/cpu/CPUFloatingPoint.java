package bench.cpu;

import benchmark.IBenchmark;
import logging.ILogger;
import timing.ITimer;

public class CPUFloatingPoint implements IBenchmark {
    private final ILogger logger;
    private final ITimer timer;
    private final int iterations;

    public CPUFloatingPoint(ILogger logger, ITimer timer, int iterations) {
        this.logger = logger;
        this.timer = timer;
        this.iterations = iterations;
    }

    @Override
    public void setUp() {
        double x = 1.0;
        for (int i = 0; i < 1_000_000; i++) {
            x += i;
            x *= 1.0001;
            x = Math.sqrt(x);
        }
    }

    @Override
    public void run() {
        setUp();

        double result = 0.0;
        timer.start();

        for (int i = 1; i <= iterations; i++) {
            result += i * 1.00001;
            result *= 0.99999;
            result = Math.sqrt(result + i);
            result /= 1.0001;
        }

        timer.stop();
        double timeSec = timer.getElapsedTimeInMillis() / 1000.0;

        double mops = iterations / timeSec / 1_000_000;
        logger.log("Floating-point MOPS: " + String.format("%.2f", mops));
    }
}
