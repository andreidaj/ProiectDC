package logging;

public class ConsoleLogger implements ILogger {

    @Override
    public void writeTime(String message, long timeInNanos, TimeUnit unit) {
        double converted = TimeUnit.convert(timeInNanos, unit);
        System.out.println(message + " " + converted + " " + unit);
    }
}
