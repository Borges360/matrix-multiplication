public class MatrixMain {

    private static int[][] matrix1;

    private static int[][] matrix2;

    private static final int matrixSize = 4096;

    public static void main(String[] args) {

        createMatrixs();

        ExecuteMatrix executeMatrix = new ExecuteMatrix();
//        executeMatrix.averageV1(matrix1, matrix2, matrixSize);
//        executeMatrix.averageV2(matrix1, matrix2, matrixSize);
        executeMatrix.averageV3(matrix1, matrix2, matrixSize);
//        executeMatrix.compareMatrixs(executeMatrix.averageV2(matrix1, matrix2, matrixSize), executeMatrix.averageV3(matrix1, matrix2, matrixSize), matrixSize);


    }

    private static void createMatrixs(){
        matrix1 = MatrixGenerate.create(matrixSize);
        matrix2 = MatrixGenerate.create(matrixSize);
    }

}
