public class ThreadRunnableV4 implements Runnable {

    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] matrixResult;
    private final int matrixSize;
    private final int newIh;
    private final int newJh;
    private final int partitionSize;

    public ThreadRunnableV4(int[][] matrix1, int[][] matrix2, int[][] matrixResult, int matrixSize, int newIh, int newJh, int partitionSize) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.matrixResult = matrixResult;
        this.matrixSize = matrixSize;
        this.newIh = newIh;
        this.newJh = newJh;
        this.partitionSize = partitionSize;
    }

    @Override
    public void run() {

        for(int kh = 0; kh < matrixSize; kh+= partitionSize){

            for(int il = 0; il < partitionSize; il++){

                for(int kl = 0; kl < partitionSize; kl++){

                    for(int jl = 0; jl < partitionSize; jl++){
                        matrixResult[newIh+il][newJh+jl] = matrixResult[newIh+il][newJh+jl] + matrix1[newIh+il][kh+kl] * matrix2[kh+kl][newJh+jl];
                    }
                }
            }
        }
    }
}
