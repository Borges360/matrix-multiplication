import java.util.Random;

public class MatrixGenerate {

    public static int[][] create(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = new Random().nextInt(100000);
            }
        }
        return matrix;
    }

}
