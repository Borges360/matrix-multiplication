public class CompareMatrixs {

    public boolean compare(int[][] matrix1, int[][] matrix2, int matrixSize){
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
