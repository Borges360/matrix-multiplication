import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixMultiplicationV33 {

    public int[][] calculate(int[][] matrix1, int[][] matrix2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        ExecutorService pool = Executors.newCachedThreadPool();
        Collection<Future<?>> tasks = new LinkedList<Future<?>>();

        for (int i = 0; i < matrixSize; i++) {

            Future<?> future = pool.submit(new ThreadRunnableV32(matrix1, matrix2, matrix, matrixSize, i));
            tasks.add(future);
        }
        for (Future<?> currTask : tasks) {
            try {
                currTask.get();
            } catch (Throwable thrown) {
                System.out.println(thrown.getMessage());
            }
        }
        pool.shutdown();
        return matrix;
    }

}
