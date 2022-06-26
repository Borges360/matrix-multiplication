import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrixMultiplicationV4 {

    public synchronized int[][] calculate(int[][] matriz1, int[][] matriz2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];
        CountDownLatch latchA = new CountDownLatch((int) (Math.pow(matrixSize, 3)));

        int partitionSize = matrixSize / 4;
        List<Thread> threadsIh = new ArrayList<>();
        for (int ih = 0; ih < matrixSize; ih+= partitionSize) {
            final int newIh = ih;
            Thread threadIh = new Thread(() -> {
                List<Thread> threadsJh = new ArrayList<>();

                for (int jh = 0; jh < matrixSize; jh+= partitionSize) {
                    final int newJh = jh;
                    Thread threadJh = new Thread(() -> {

                        for(int kh = 0; kh < matrixSize; kh+= partitionSize){
                            
                            for(int il = 0; il < partitionSize; il++){
                                
                                for(int kl = 0; kl < partitionSize; kl++){
                                    
                                    for(int jl = 0; jl < partitionSize; jl++){
                                        
                                        matrix[newIh+il][newJh+jl] += matriz1[newIh+il][kh+kl] * matriz2[kh+kl][newJh+jl];
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
