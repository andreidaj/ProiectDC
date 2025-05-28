import bench.cpu.CPUDigitsOfPI_MonteCarlo;
import benchmark.*;
import logging.ConsoleLogger;
import timing.Timer;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        Timer timer = new Timer();

        IBenchmark demo = new DemoBenchmark(logger, timer);
        IBenchmark interrupted = new InterruptedBenchmark(logger, timer);

        Testbench testbench = new Testbench(Arrays.asList(demo, interrupted));
        testbench.runAll();

        logger.log("Last benchmark duration in seconds (via TimeUnit): " +
                timer.getElapsedTime(TimeUnit.SECONDS));
        int[] digitCounts = {50, 100, 500, 1000, 2000, 5000, 10000, 20000}; // extensibil până la 100k

        int[] iterationCounts = {1_000, 5_000, 10_000, 50_000, 100_000, 500_000, 1_000_000};

        IBenchmark benchmark = new CPUDigitsOfPI_MonteCarlo(new ConsoleLogger(), new Timer(), iterationCounts);
        benchmark.run();
    }
}
