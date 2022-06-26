import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrixMultiplicationV31 {

    public synchronized int[][] calculate(int[][] matriz1, int[][] matriz2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        CountDownLatch latchA = new CountDownLatch((int) (Math.pow(matrixSize, 3)));
        List<Thread> threads = new ArrayList<>();
        AtomicInteger i = new AtomicInteger();
        for (i.get(); i.get() < matrixSize; i.getAndIncrement()) {
            final int newI = i.get();
            Thread thread1 = new Thread(() -> {

                AtomicInteger k = new AtomicInteger();
                for (k.get(); k.get() < matrixSize; k.getAndIncrement()) {
                    final int newk = k.get();

                    AtomicInteger j = new AtomicInteger();
                    for (j.get(); j.get() < matrixSize; j.getAndIncrement()) {

                        final int newj = j.get();
                        matrix[newI][newj] = matrix[newI][newj] + matriz1[newI][newk] * matriz2[newk][newj];
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
