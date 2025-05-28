package benchmark;

import java.util.Random;

public class DemoBenchmark2 implements IIBenchmark {
    private int[] array;
    private boolean running = true;

    @Override
    public void initialize(Object... params) {
        int size = (int) params[0];
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }
        running = true; // Reset running flag
    }

    @Override
    public void run() {
        // Bubble sort with cancel support
        for (int i = 0; i < array.length - 1 && running; i++) {
            for (int j = 0; j < array.length - i - 1 && running; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void cancel() {
        running = false;
    }

    @Override
    public void clean() {
        array = null;
    }
}
