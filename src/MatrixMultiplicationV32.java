import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplicationV32 {

    public synchronized int[][] calculate(int[][] matrix1, int[][] matrix2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < matrixSize; i++) {
            Thread thread1 = new Thread(new ThreadRunnableV32(matrix1, matrix2, matrix, matrixSize, i));
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
