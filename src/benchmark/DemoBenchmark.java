package benchmark;

import logging.ILogger;
import timing.ITimer;

public class DemoBenchmark implements IBenchmark {
    private ILogger logger;
    private ITimer timer;

    public DemoBenchmark(ILogger logger, ITimer timer) {
        this.logger = logger;
        this.timer = timer;
    }

    @Override
    public void setUp() {
        logger.log("Setting up DemoBenchmark...");
    }

    @Override
    public void run() {
        setUp();
        timer.start();

        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }

        timer.stop();
        logger.log("Sum is: " + sum);
        logger.log("Time elapsed: " + timer.getElapsedTimeInMillis() + " ms.");
    }
}
