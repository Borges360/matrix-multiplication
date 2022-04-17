public class MatrixMultiplicationV1 {

    public int[][] calculate(int[][] matriz1, int [][] matriz2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                for(int k = 0; k < matrixSize; k++){
                    matrix[i][j] = matrix[i][j] + matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return matrix;
    }

}
