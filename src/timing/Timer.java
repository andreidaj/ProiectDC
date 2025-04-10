package timing;

import java.time.Duration;
import java.time.Instant;

public class Timer implements ITimer {
    private Instant startTime;
    private Instant endTime;

    @Override
    public void start() {
        this.startTime = Instant.now();
    }

    @Override
    public void stop() {
        this.endTime = Instant.now();
    }

    @Override
    public long getElapsedTimeInSeconds() {
        if (startTime == null || endTime == null) {
            throw new IllegalStateException("Timer was not started and stopped properly.");
        }
        return Duration.between(startTime, endTime).toSeconds();
    }
}
