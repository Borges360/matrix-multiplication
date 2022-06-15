import java.util.concurrent.atomic.AtomicInteger;

public class MatrixMultiplicationV3 {

    public synchronized int[][] calculate(int[][] matriz1, int [][] matriz2, int matrixSize) {

        int[][] matrix = new int[matrixSize][matrixSize];

        AtomicInteger i = new AtomicInteger();
        for(i.get(); i.get() < matrixSize; i.getAndIncrement()){
            new Thread(() -> {
                for(AtomicInteger k = new AtomicInteger(); k.get() < matrixSize; k.getAndIncrement()){
                    new Thread(() -> {
                        for(AtomicInteger j = new AtomicInteger(); j.get() < matrixSize; j.getAndIncrement()){
                            new Thread(() -> {
                                matrix[i.get()][j.get()] = matrix[i.get()][j.get()] + matriz1[i.get()][k.get()] * matriz2[k.get()][j.get()];
                            });
                        }
                    });
                }
            });
        }
        return matrix;
    }

}
