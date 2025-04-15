package logging;

public enum TimeUnit {
    NANO, MICRO, MILLI, SEC;

    public static double convert(long timeInNanos, TimeUnit targetUnit) {
        switch (targetUnit) {
            case NANO:
                return timeInNanos;
            case MICRO:
                return timeInNanos / 1_000.0;
            case MILLI:
                return timeInNanos / 1_000_000.0;
            case SEC:
                return timeInNanos / 1_000_000_000.0;
            default:
                throw new IllegalArgumentException("Unknown time unit");
        }
    }
}
