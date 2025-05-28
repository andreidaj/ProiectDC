import bench.cpu.CPUFixedPoint;
import bench.cpu.CPUFloatingPoint;
import logging.ConsoleLogger;
import timing.Timer;
import benchmark.IBenchmark;

public class Main1 {
    public static void main(String[] args) {
        int iterations = 100_000_000;
        ConsoleLogger logger = new ConsoleLogger();
        Timer timer = new Timer();

        IBenchmark fixed = new CPUFixedPoint(logger, timer, iterations);
        fixed.run();

        IBenchmark floating = new CPUFloatingPoint(logger, timer, iterations);
        floating.run();
    }
}