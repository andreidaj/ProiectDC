import benchmark.Benchmark;
import logging.ConsoleLogger;
import timing.Timer;

public class Main {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        Timer timer = new Timer();

        Benchmark benchmark = new Benchmark(consoleLogger, timer);
        benchmark.run();

        FileLogger fileLogger = new FileLogger("benchmark_log.txt");
        Benchmark fileBenchmark = new Benchmark(fileLogger, timer);
        fileBenchmark.run();
    }
}

