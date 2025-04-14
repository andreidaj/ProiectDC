package benchmark;

public interface ITimer {
    void start();
    void stop();
    long getElapsedTime(); // nanosecunde
}
