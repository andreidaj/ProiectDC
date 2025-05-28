package benchmark;

import java.util.List;

public class Testbench {
    private final List<IBenchmark> benchmarks;

    public Testbench(List<IBenchmark> benchmarks) {
        this.benchmarks = benchmarks;
    }

    public void runAll() {
        for (IBenchmark b : benchmarks) {
            b.run();
        }
    }
}
