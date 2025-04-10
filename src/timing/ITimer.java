package timing;
public interface ITimer {
    void start();
    void stop();
    long getElapsedTimeInSeconds();
}
