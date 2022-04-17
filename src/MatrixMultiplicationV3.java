import java.util.HashSet;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrixMultiplicationV3 {

    public int[][] calculate(int[][] matriz1, int [][] matriz2, int matrixSize) {

        ExecutorService executor = Executors.newFixedThreadPool(8);
//        ExecutorService executor2 = Executors.newFixedThreadPool(4);
//        ExecutorService executor3 = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch((int) Math.pow(matrixSize,3));

        int[][] matrix = new int[matrixSize][matrixSize];

        AtomicInteger i = new AtomicInteger();
        for(i.get(); i.get() < matrixSize; i.getAndIncrement()){
            executor.submit(() -> {
                for(AtomicInteger k = new AtomicInteger(); k.get() < matrixSize; k.getAndIncrement()){
                    executor.submit(() -> {
                        for(AtomicInteger j = new AtomicInteger(); j.get() < matrixSize; j.getAndIncrement()){
                            executor.submit(() -> {
                                matrix[i.get()][j.get()] = matrix[i.get()][j.get()] + matriz1[i.get()][k.get()] * matriz2[k.get()][j.get()];});
                                latch.countDown();

                    }});
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException E) {
            // handle
        }
        executor.shutdown();
//        executor2.shutdown();
//        executor3.shutdown();
        return matrix;
    }

}
