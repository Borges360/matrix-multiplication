import java.util.concurrent.CountDownLatch;

public class ThreadRunnableV32 implements Runnable {

    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] matrixResult;
    private final int matrixSize;
    private final int newI;
    private final CountDownLatch latchA;

    public ThreadRunnableV32(int[][] matrix1, int[][] matrix2, int[][] matrixResult, int matrixSize, int newI, CountDownLatch latchA) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.matrixResult = matrixResult;
        this.matrixSize = matrixSize;
        this.newI = newI;
        this.latchA = latchA;
    }

    @Override
    public void run() {

        for (int k = 0; k < matrixSize; k++) {

            for (int j = 0; j < matrixSize; j++) {

                matrixResult[newI][j] = matrixResult[newI][j] + matrix1[newI][k] * matrix2[k][j];
                latchA.countDown();

            }
        }
    }
}
