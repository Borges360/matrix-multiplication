import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrixMultiplicationV4 {

    public int[][] calculate(int[][] matriz1, int[][] matriz2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];
        CountDownLatch latchA = new CountDownLatch((int) (Math.pow(matrixSize, 3)));
        AtomicInteger ih = new AtomicInteger();
        int partitionSize = matrixSize / 4;
        List<Thread> threadsIh = new ArrayList<>();
        for (ih.get(); ih.get() < matrixSize; ih.getAndAdd(partitionSize)) {
            final int newIh = ih.get();
            Thread threadIh = new Thread(() -> {
                List<Thread> threadsJh = new ArrayList<>();
                AtomicInteger jh = new AtomicInteger();
                for (jh.get(); jh.get() < matrixSize; jh.getAndAdd(partitionSize)) {
                    final int newJh = jh.get();
                    Thread threadJh = new Thread(() -> {

                        AtomicInteger kh = new AtomicInteger();
                        for(kh.get(); kh.get() < matrixSize; kh.getAndAdd(partitionSize)){
                            final int newKh = kh.get();
                            AtomicInteger il = new AtomicInteger();
                            for(il.get(); il.get() < partitionSize; il.getAndIncrement()){
                                final int newIl = il.get();
                                AtomicInteger kl = new AtomicInteger();
                                for(kl.get(); kl.get() < partitionSize; kl.getAndIncrement()){
                                    final int newKl = kl.get();
                                    AtomicInteger jl = new AtomicInteger();
                                    for(jl.get(); jl.get() < partitionSize; jl.getAndIncrement()){
                                        final int newJl = jl.get();
                                        matrix[newIh+newIl][newJh+newJl] += matriz1[newIh+newIl][newKh+newKl] * matriz2[newKh+newKl][newJh+newJl];
                                        latchA.countDown();
                                    }
                                }
                            }
                        }

                    });
                    threadJh.start();
                    threadsJh.add(threadJh);
                    if (threadsJh.size() % 10 == 0) {
                        waitForThreads(threadsJh);
                    }
                }
            });
            threadIh.start();
            threadsIh.add(threadIh);
            if (threadsIh.size() % 10 == 0) {
                waitForThreads(threadsIh);
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
