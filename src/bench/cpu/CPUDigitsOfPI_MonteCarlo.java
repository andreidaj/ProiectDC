package bench.cpu;

import benchmark.IBenchmark;
import logging.ILogger;
import timing.ITimer;

import java.io.PrintWriter;
import java.util.Random;

public class CPUDigitsOfPI_MonteCarlo implements IBenchmark {
    private final ILogger logger;
    private final ITimer timer;
    private final int[] iterationCounts;

    public CPUDigitsOfPI_MonteCarlo(ILogger logger, ITimer timer, int[] iterationCounts) {
        this.logger = logger;
        this.timer = timer;
        this.iterationCounts = iterationCounts;
    }

    @Override
    public void setUp() {
        // No setup needed
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter("runtimes_montecarlo.csv")) {
            writer.println("Iterations,TimeMillis");

            for (int n : iterationCounts) {
                // Warm-up
                for (int i = 0; i < 1000; i++) {
                    double x = Math.random();
                    double y = Math.random();
                    double r = x * x + y * y;
                }

                timer.start();
                double pi = computePiMonteCarlo(n);
                timer.stop();

                long time = timer.getElapsedTimeInMillis();
                writer.println(n + "," + time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double computePiMonteCarlo(int n) {
        int insideCircle = 0;
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            if (x * x + y * y <= 1.0) {
                insideCircle++;
            }
        }

        return 4.0 * insideCircle / n;
    }
}
