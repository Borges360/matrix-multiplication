public class ExecuteMatrix {

    private static final int EXECUTIONS = 10;

    private final MatrixMultiplicationV1 matrixMultiplicationV1;

    private final MatrixMultiplicationV2 matrixMultiplicationV2;

    private final MatrixMultiplicationV3 matrixMultiplicationV3;

    private final MatrixMultiplicationV31 matrixMultiplicationV31;

    private final MatrixMultiplicationV4 matrixMultiplicationV4;

    private final MatrixMultiplicationV41 matrixMultiplicationV41;

    public ExecuteMatrix() {
        this.matrixMultiplicationV1 = new MatrixMultiplicationV1();
        this.matrixMultiplicationV2 = new MatrixMultiplicationV2();
        this.matrixMultiplicationV3 = new MatrixMultiplicationV3();
        this.matrixMultiplicationV31 = new MatrixMultiplicationV31();
        this.matrixMultiplicationV4 = new MatrixMultiplicationV4();
        this.matrixMultiplicationV41 = new MatrixMultiplicationV41();
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
        System.out.println("algoritmo 3 média de " + EXECUTIONS + " execução: " + media/EXECUTIONS + " segundos");
        return matrix;
    }

    public int[][] averageV31(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV31.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
            System.out.println("Tempo de execução algoritmo 3.1 - " + i + ": " + (stopTime - startTime)/1000);
        }
        System.out.println("algoritmo 3.1 média de " + EXECUTIONS + " execução: " + media/EXECUTIONS + " segundos");
        return matrix;
    }

    public int[][] averageV4(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV4.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
            System.out.println("Tempo de execução algoritmo 4 - " + i + ": " + (stopTime - startTime)/1000);
        }
        System.out.println("algoritmo 4 média de " + EXECUTIONS + " execução: " + media/EXECUTIONS + " segundos");
        return matrix;
    }

    public int[][] averageV41(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV41.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
            System.out.println("Tempo de execução algoritmo 4.1 - " + i + ": " + (stopTime - startTime)/1000);
        }
        System.out.println("algoritmo 4.1 média de " + EXECUTIONS + " execução: " + media/EXECUTIONS + " segundos");
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
