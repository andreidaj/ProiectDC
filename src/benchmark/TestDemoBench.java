package benchmark;

public class TestDemoBench {
    public static void main(String[] args) {
        IBenchmark bench = new DemoBenchmark();
        ITimer timer = new Timer();

        int size = 10000;
        bench.initialize(size);

        timer.start();
        bench.run();
        timer.stop();

        long elapsed = timer.getElapsedTime();
        System.out.println("Elapsed time: " + elapsed + " ns");
    }
}
