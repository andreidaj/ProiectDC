package benchmark;
<<<<<<< HEAD
public interface IBenchmark {
    void setUp();
=======

public interface IBenchmark {
    void initialize(Object... params);
>>>>>>> fe2d68f3ddf1c0540429c736f80596a52f5d5e53
    void run();
    void run(Object... options);
    void clean();
    void cancel();
    String getResult();
}
