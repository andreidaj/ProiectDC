package benchmark;

import logging.ILogger;
import timing.ITimer;

public class Benchmark implements IBenchmark {
    private ILogger logger;
    private ITimer timer;

    public Benchmark(ILogger logger, ITimer timer) {
        this.logger = logger;
        this.timer = timer;
    }

    @Override
    public void setUp() {
        logger.log("Setting up the benchmark...");
    }

    @Override
    public void run() {
        setUp();
        timer.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.stop();
        logger.log("Benchmark finished. Time elapsed: " + timer.getElapsedTimeInSeconds() + " seconds.");
    }
}
