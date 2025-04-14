package benchmark;

public class Timer implements ITimer {
    private long startTime;
    private long endTime;

    @Override
    public void start() {
        startTime = System.nanoTime();
    }

    @Override
    public void stop() {
        endTime = System.nanoTime();
    }

    @Override
    public long getElapsedTime() {
        return endTime - startTime;
    }
}
