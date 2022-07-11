import java.util.*;

public class ExecuteMatrix {

    private static final int EXECUTIONS = MatrixMain.EXECUTIONS;

    private final MatrixMultiplicationV1 matrixMultiplicationV1;

    private final MatrixMultiplicationV2 matrixMultiplicationV2;

    private final MatrixMultiplicationV3 matrixMultiplicationV3;

    private final MatrixMultiplicationV31 matrixMultiplicationV31;

    private final MatrixMultiplicationV32 matrixMultiplicationV32;

    private final MatrixMultiplicationV33 matrixMultiplicationV33;

    private final MatrixMultiplicationV4 matrixMultiplicationV4;

    private final MatrixMultiplicationV41 matrixMultiplicationV41;

    private Map<String,Double> averageTimeExecution;

    public ExecuteMatrix() {
        this.matrixMultiplicationV1 = new MatrixMultiplicationV1();
        this.matrixMultiplicationV2 = new MatrixMultiplicationV2();
        this.matrixMultiplicationV3 = new MatrixMultiplicationV3();
        this.matrixMultiplicationV31 = new MatrixMultiplicationV31();
        this.matrixMultiplicationV32 = new MatrixMultiplicationV32();
        this.matrixMultiplicationV33 = new MatrixMultiplicationV33();
        this.matrixMultiplicationV4 = new MatrixMultiplicationV4();
        this.matrixMultiplicationV41 = new MatrixMultiplicationV41();
        this.averageTimeExecution = new HashMap<>();
    }

    public int[][] averageV1(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV1.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
//            System.out.println("Tempo de execução algoritmo 1 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 1", media);
        System.out.println("Algoritmo 1 média de " + EXECUTIONS + " execuções: " + media + " segundos");
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
//            System.out.println("Tempo de execução algoritmo 2 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 2", media);
        System.out.println("Algoritmo 2 média de " + EXECUTIONS + " execuções: " + media + " segundos");
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
//            System.out.println("Tempo de execução algoritmo 3 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 3", media);
        System.out.println("Algoritmo 3 média de " + EXECUTIONS + " execução: " + media + " segundos");
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
//            System.out.println("Tempo de execução algoritmo 3.1 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 3.1", media);
        System.out.println("Algoritmo 3.1 média de " + EXECUTIONS + " execução: " + media + " segundos");
        return matrix;
    }

    public int[][] averageV32(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV32.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
//            System.out.println("Tempo de execução algoritmo 3.2 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 3.2", media);
        System.out.println("Algoritmo 3.2 média de " + EXECUTIONS + " execução: " + media + " segundos");
        return matrix;
    }

    public int[][] averageV33(int [][] matrix1, int[][] matrix2, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        double media = 0.0;

        for (int i = 0; i < EXECUTIONS; i++) {
            double startTime = System.currentTimeMillis();
            matrix = matrixMultiplicationV33.calculate(matrix1, matrix2, matrixSize);
            double stopTime = System.currentTimeMillis();
            media = media + (stopTime - startTime)/1000;
//            System.out.println("Tempo de execução algoritmo 3.3 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 3.3", media);
        System.out.println("Algoritmo 3.3 média de " + EXECUTIONS + " execução: " + media + " segundos");
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
//            System.out.println("Tempo de execução algoritmo 4 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 4", media);
        System.out.println("Algoritmo 4 média de " + EXECUTIONS + " execução: " + media + " segundos");
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
//            System.out.println("Tempo de execução algoritmo 4.1 - " + i + ": " + (stopTime - startTime)/1000);
        }
        media = media/EXECUTIONS;
        averageTimeExecution.put("Algoritmo 4.1", media);
        System.out.println("Algoritmo 4.1 média de " + EXECUTIONS + " execução: " + media + " segundos");
        return matrix;
    }

    public void rankingAlgorithms(){
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list =
                new LinkedList<>(averageTimeExecution.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        System.out.println("\nRanking:");
        temp.forEach((s, aDouble) -> System.out.println(s + " tempo de execução médio " + aDouble + " segundos"));
    }

}
