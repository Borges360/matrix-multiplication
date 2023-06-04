import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MatrizMultiplicationV5 {

    public int[][] calculate(int[][] matrix1, int[][] matrix2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];

        final ThreadFactory factory = Thread.ofVirtual().name("routine-", 0).factory();
        try (var executor = Executors.newThreadPerTaskExecutor(factory)) {
            for (int i = 0; i < matrixSize; i++) {

                executor.submit(new ThreadRunnableV32(matrix1, matrix2, matrix, matrixSize, i));
            }
        }
        return matrix;
    }

}
