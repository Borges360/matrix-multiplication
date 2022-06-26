import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MatrixMultiplicationV31 {

    public synchronized int[][] calculate(int[][] matriz1, int[][] matriz2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        CountDownLatch latchA = new CountDownLatch((int) (Math.pow(matrixSize, 3)));
        List<Thread> threads = new ArrayList<>();
        
        for (int i = 0; i < matrixSize; i++) {
            int finalI = i;
            Thread thread1 = new Thread(() -> {

                for (int k = 0; k < matrixSize; k++) {
                    
                    for (int j = 0; j < matrixSize; j++) {
                        
                        matrix[finalI][j] = matrix[finalI][j] + matriz1[finalI][k] * matriz2[k][j];
                        latchA.countDown();

                    }
                }
            });
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
