import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrixMultiplicationV3 {

    public synchronized int[][] calculate(int[][] matriz1, int[][] matriz2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        CountDownLatch latchA = new CountDownLatch((int) (Math.pow(matrixSize, 3)));
        AtomicInteger i = new AtomicInteger();
        for (i.get(); i.get() < matrixSize; i.getAndIncrement()) {
            final int newI = i.get();
            Thread thread1 = new Thread(() -> {

                AtomicInteger k = new AtomicInteger();
                for (k.get(); k.get() < matrixSize; k.getAndIncrement()) {
                    final int newk = k.get();
                    Thread thread2 = new Thread(() -> {

                        AtomicInteger j = new AtomicInteger();
                        for (j.get(); j.get() < matrixSize; j.getAndIncrement()) {
                            final int newj = j.get();
                            Thread thread3 = new Thread(() -> {
                                matrix[newI][newj] = matrix[newI][newj] + matriz1[newI][newk] * matriz2[newk][newj];
                                latchA.countDown();
                            });
                            thread3.start();
                        }
                    });
                    thread2.start();
                }
            });
            thread1.start();
        }
        try {
            latchA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return matrix;
    }

}
