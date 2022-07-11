public class ThreadRunnableV32 implements Runnable {

    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] matrixResult;
    private final int matrixSize;
    private final int row;

    public ThreadRunnableV32(int[][] matrix1, int[][] matrix2, int[][] matrixResult, int matrixSize, int row) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.matrixResult = matrixResult;
        this.matrixSize = matrixSize;
        this.row = row;
    }

    @Override
    public void run() {

        for (int k = 0; k < matrixSize; k++) {

            for (int j = 0; j < matrixSize; j++) {
                matrixResult[row][j] = matrixResult[row][j] + matrix1[row][k] * matrix2[k][j];
            }
        }
    }
}
