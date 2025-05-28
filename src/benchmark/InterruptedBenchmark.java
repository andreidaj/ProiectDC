package benchmark;

import logging.ILogger;
import timing.ITimer;

public class InterruptedBenchmark implements IBenchmark {
    private final ILogger logger;
    private final ITimer timer;

    public InterruptedBenchmark(ILogger logger, ITimer timer) {
        this.logger = logger;
        this.timer = timer;
    }

    @Override
    public void setUp() {
        logger.log("Preparing InterruptedBenchmark...");
    }

    @Override
    public void run() {
        setUp();
        timer.start();
        try {
            Thread.sleep(3000); // try sleeping 3 seconds
        } catch (InterruptedException e) {
            logger.log("Benchmark was interrupted!");
        }
        timer.stop();
        logger.log("Time elapsed after interruption: " + timer.getElapsedTimeInMillis() + " ms.");
    }
}
