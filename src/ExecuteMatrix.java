public class ExecuteMatrix {

    private static final int EXECUTIONS = 9;

    private final MatrixMultiplicationV1 matrixMultiplicationV1;

    private final MatrixMultiplicationV2 matrixMultiplicationV2;

    private final MatrixMultiplicationV3 matrixMultiplicationV3;

    public ExecuteMatrix() {
        this.matrixMultiplicationV1 = new MatrixMultiplicationV1();
        this.matrixMultiplicationV2 = new MatrixMultiplicationV2();
        this.matrixMultiplicationV3 = new MatrixMultiplicationV3();
    }

    public int[][] averageV1(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV1.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
            System.out.println("Tempo de execução algoritmo 1 - " + i + ": " + (stopTime - startTime)/1000);
        }
        System.out.println("algoritmo 1 média de " + EXECUTIONS + " execuções: " + media/EXECUTIONS + " segundos");
        return matrix;
    }

    public int[][] averageV2(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV2.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
            System.out.println("Tempo de execução algoritmo 2 - " + i + ": " + (stopTime - startTime)/1000);
        }
        System.out.println("algoritmo 2 média de " + EXECUTIONS + " execuções: " + media/EXECUTIONS + " segundos");
        return matrix;
    }

    public int[][] averageV3(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV3.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
            System.out.println("Tempo de execução algoritmo 3 - " + i + ": " + (stopTime - startTime)/1000);
        }
        System.out.println("algoritmo 3 média de " + 1 + " execução: " + media/EXECUTIONS + " segundos");
        return matrix;
    }

    public boolean compareMatrixs(int[][] matrix1, int[][] matrix2, int matrixSize){
        for(int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                if(matrix1[i][j]!=matrix2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
