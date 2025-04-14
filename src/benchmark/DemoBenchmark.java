package benchmark;

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
    }

    @Override
    public void run() {
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
    }
}
