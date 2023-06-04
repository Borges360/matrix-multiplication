import java.util.HashMap;

public class MatrixMain {

    private static int[][] matrix1;

    private static int[][] matrix2;

    private static int matrixMaxSize = 2048;

    private static int minMaxSize = 256;

    public static int EXECUTIONS = 30;

    public static void main(String[] args) {

        for(int i = minMaxSize; i<=matrixMaxSize; i*=2){
            System.out.println("\nIniciando processamento com matriz de tamanho: " + i);
            final int matrixSize = i;
            createMatrixs(matrixSize);

            ExecuteMatrix executeMatrix = new ExecuteMatrix();
//            int[][] matrixResultV1 = executeMatrix.averageV1(matrix1, matrix2, matrixSize);
            int[][] matrixResultV2 = executeMatrix.averageV2(matrix1, matrix2, matrixSize);
            int[][] matrixResultV31 = executeMatrix.averageV31(matrix1, matrix2, matrixSize);
            int[][] matrixResultV32 = executeMatrix.averageV32(matrix1, matrix2, matrixSize);
            int[][] matrixResultV33 = executeMatrix.averageV33(matrix1, matrix2, matrixSize);
            int[][] matrixResultV4 = executeMatrix.averageV4(matrix1, matrix2, matrixSize);
//            int[][] matrixResultV41 = executeMatrix.averageV41(matrix1, matrix2, matrixSize);
            int[][] matrixResultv5 = executeMatrix.averageV5(matrix1, matrix2, matrixSize);

            System.out.println("Resultado dos tempo de execução com matriz de tamanho: " + i);

            executeMatrix.rankingAlgorithms();
            HashMap<String, int[][]> listMatrix = new HashMap<>();
//            listMatrix.put("Algoritimo V1",matrixResultV1);
            listMatrix.put("Algoritimo V2",matrixResultV2);
            listMatrix.put("Algoritimo V3.1",matrixResultV31);
            listMatrix.put("Algoritimo V3.2",matrixResultV32);
            listMatrix.put("Algoritimo V3.3",matrixResultV33);
            listMatrix.put("Algoritimo V4",matrixResultV4);
            listMatrix.put("Algoritimo V5",matrixResultv5);
//            listMatrix.put("Algoritimo V4.1",matrixResultV41);
            comparationsMatrixs(matrixResultV2, listMatrix,i);

        }

    }

    private static void createMatrixs(int matrixSize){
        matrix1 = MatrixGenerate.create(matrixSize);
        matrix2 = MatrixGenerate.create(matrixSize);
    }

    private static void comparationsMatrixs(int[][] matrixResultV1, HashMap<String, int[][]> matrixs,int i){
        CompareMatrixs compareMatrixs = new CompareMatrixs();
        System.out.println("\nIniciando comparação entre matrizes");
        matrixs.forEach((algoritm,matrix) -> {
            if(compareMatrixs.compare(matrixResultV1,matrix,i)){
                System.out.println(algoritm + " está correto");
            } else {
                System.out.println(algoritm + " não está correto");
            }
        });
    }

}
