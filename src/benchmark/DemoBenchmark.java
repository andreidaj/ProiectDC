package benchmark;

<<<<<<< HEAD
import logging.ILogger;
import timing.ITimer;

public class DemoBenchmark implements IBenchmark {
    private ILogger logger;
    private ITimer timer;

    public DemoBenchmark(ILogger logger, ITimer timer) {
        this.logger = logger;
        this.timer = timer;
    }

    @Override
    public void setUp() {
        logger.log("Setting up DemoBenchmark...");
=======
import java.util.Random;

public class DemoBenchmark implements IBenchmark {
    private int[] array;

    @Override
    public void initialize(Object... params) {
        int size = (int) params[0];
        array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }
>>>>>>> fe2d68f3ddf1c0540429c736f80596a52f5d5e53
    }

    @Override
    public void run() {
<<<<<<< HEAD
        setUp();
        timer.start();

        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }

        timer.stop();
        logger.log("Sum is: " + sum);
        logger.log("Time elapsed: " + timer.getElapsedTimeInMillis() + " ms.");
=======
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public void run(Object... options) {
        run();
    }

    @Override
    public void clean() {
        array = null;
    }

    @Override
    public void cancel() {
    }

    @Override
    public String getResult() {
        return "Sort completed.";
>>>>>>> fe2d68f3ddf1c0540429c736f80596a52f5d5e53
    }
}
