package timing;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

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
    public long getElapsedTimeInMillis() {
        if (startTime == null || endTime == null) {
            throw new IllegalStateException("Timer was not started and stopped properly.");
        }
        return Duration.between(startTime, endTime).toMillis();
    }
    public long getElapsedTime(TimeUnit unit) {
        if (startTime == null || endTime == null) {
            throw new IllegalStateException("Timer was not started and stopped properly.");
        }
        long nanos = Duration.between(startTime, endTime).toNanos();
        return unit.convert(nanos, TimeUnit.NANOSECONDS);
    }

}
