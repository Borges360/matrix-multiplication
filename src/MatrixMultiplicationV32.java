import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MatrixMultiplicationV32 {

    public synchronized int[][] calculate(int[][] matrix1, int[][] matrix2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        CountDownLatch latchA = new CountDownLatch((int) (Math.pow(matrixSize, 3)));
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < matrixSize; i++) {
            Thread thread1 = new Thread(new ThreadRunnableV32(matrix1, matrix2, matrix, matrixSize, i, latchA));
            thread1.start();
            threads.add(thread1);
            if (threads.size() % 100 == 0) {
                waitForThreads(threads);
            }
        }
        try {
            latchA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
