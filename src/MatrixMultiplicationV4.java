import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixMultiplicationV4 {

    private ExecutorService pool;

    int partitionDivider = 8;

    public int[][] calculate(int[][] matrix1, int[][] matrix2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        int partitionSize = matrixSize / partitionDivider;
        pool = Executors.newCachedThreadPool();
        Collection<Future<?>> tasks = new LinkedList<>();
        for (int ih = 0; ih < matrixSize; ih += partitionSize) {
            final int newIh = ih;
            Future<?> future = pool.submit(() -> {
                Collection<Future<?>> tasks2 = new LinkedList<>();
                for (int jh = 0; jh < matrixSize; jh += partitionSize) {
                    Future<?> future2 = pool.submit(new ThreadRunnableV4(matrix1, matrix2, matrix, matrixSize, newIh, jh, partitionSize));
                    tasks2.add(future2);
                }
                waitThreads(tasks2);
            });
            tasks.add(future);
            waitThreads(tasks);

        }
        pool.shutdown();
        return matrix;
    }

    private void waitThreads(Collection<Future<?>> tasks2) {
        for (Future<?> currTask : tasks2) {
            try {
                currTask.get();
            } catch (Throwable thrown) {
                pool.shutdown();
                throw new RuntimeException();
            }
        }
    }

}
