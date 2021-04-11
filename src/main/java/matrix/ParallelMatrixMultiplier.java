package matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Pavel Burdyug
 * Multiply matrices using multithreading
 */
public class ParallelMatrixMultiplier {

    /**
     * Returns matrices multiplication result
     * @param matrix1 first matrix to multiply
     * @param matrix2 second matrix to multiply
     * @return matrix-result of multiplication
     * @throws IllegalArgumentException when multiplication arguments are incorrect (Matrices must have size mxn and nxk, m, n, k > 0)
     * @throws InterruptedException
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) throws IllegalArgumentException, InterruptedException {
        if (
                matrix1 == null || matrix2 == null ||
                matrix1.length == 0 || matrix2.length == 0 ||
                matrix1[0].length != matrix2.length
        ) {
            throw new IllegalArgumentException("Matrices must have size mxn and nxk, m, n, k > 0");
        }
        double[][] result = new double[matrix1.length][matrix2[0].length];
        List<Thread> threads = new LinkedList<>();
        for (int i = 0;i < matrix1.length;i++) {
            MatrixRowRunnable matrixRowRunnable = new MatrixRowRunnable(i, matrix1[i], matrix2, result);
            Thread rowMultiplyThread = new Thread(matrixRowRunnable);
            rowMultiplyThread.start();
            threads.add(rowMultiplyThread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        return result;
    }
}
