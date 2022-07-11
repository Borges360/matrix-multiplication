import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplicationV31 {

    public int[][] calculate(int[][] matriz1, int[][] matriz2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < matrixSize; i++) {

            int finalI = i;
            Thread thread1 = new Thread(() -> {

            for (int k = 0; k < matrixSize; k++) {

                for (int j = 0; j < matrixSize; j++) {

                    matrix[finalI][j] = matrix[finalI][j] + matriz1[finalI][k] * matriz2[k][j];

                }
            }
        });
        thread1.start();
        threads.add(thread1);
        if (threads.size() % 128 == 0) {
            waitForThreads(threads);
        }
    }
        return matrix;
}

    private void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }

}
