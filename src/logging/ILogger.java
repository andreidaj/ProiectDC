package logging;
public interface ILogger {
    void log(String message);
    void writeTime(String message, long timeInNanos, TimeUnit unit);
}
