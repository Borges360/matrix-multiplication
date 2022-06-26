public class MatrixMultiplicationV41 {

    //Version 4 single Thread
    public int[][] calculate(int[][] matriz1, int[][] matriz2, int matrixSize) {
        final int[][] matrix = new int[matrixSize][matrixSize];
        
        int partitionSize = matrixSize / 4;
        for (int ih = 0; ih < matrixSize; ih += partitionSize) {
            
                for (int jh = 0; jh < matrixSize; jh += partitionSize) {
                    
                        for(int kh = 0; kh < matrixSize; kh += partitionSize){
                            for(int il = 0; il < partitionSize; il++){
                                for(int kl = 0; kl < partitionSize; kl++){
                                    for(int jl = 0; jl < partitionSize; jl++){

                                        matrix[ih+il][jh+jl] += matriz1[ih+il][kh+kl] * matriz2[kh+kl][jh+jl];

                                    }
                                }
                            }
                        }
                }
        }
        return matrix;
    }

}
