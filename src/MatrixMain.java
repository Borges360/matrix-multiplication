public class MatrixMain {

    private static int[][] matrix1;

    private static int[][] matrix2;

    private static int matrixMaxSize = 1024;

    public static void main(String[] args) {

        for(int i = 4; i<=matrixMaxSize; i*=2){
            System.out.println("Iniciando processamento com matriz de tamanho: " + i);
            final int matrixSize = i;
            createMatrixs(matrixSize);

            ExecuteMatrix executeMatrix = new ExecuteMatrix();
            executeMatrix.averageV1(matrix1, matrix2, matrixSize);
            executeMatrix.averageV2(matrix1, matrix2, matrixSize);
            executeMatrix.averageV31(matrix1, matrix2, matrixSize);
            executeMatrix.averageV32(matrix1, matrix2, matrixSize);
            executeMatrix.averageV4(matrix1, matrix2, matrixSize);
            executeMatrix.averageV41(matrix1, matrix2, matrixSize);
//            System.out.println(executeMatrix.compareMatrixs(executeMatrix.averageV2(matrix1, matrix2, matrixSize), executeMatrix.averageV4(matrix1, matrix2, matrixSize), matrixSize));
            executeMatrix.rankingAlgorithms();
            System.out.println("");
        }

    }

    private static void createMatrixs(int matrixSize){
        matrix1 = MatrixGenerate.create(matrixSize);
        matrix2 = MatrixGenerate.create(matrixSize);
    }

}
