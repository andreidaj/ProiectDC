package benchmark;

public interface IIBenchmark {
    void initialize(Object... params);
    void run();
    void cancel();
    void clean();
}
