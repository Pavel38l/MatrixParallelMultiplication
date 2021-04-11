package matrix;


/**
 * @author Pavel Burdyug
 * Implementation of the task for one thread of matrix multiplication <br>
 * Multiplies one row of the first matrix by the second and forms one row of the resulting matrix
 */
public class MatrixRowRunnable implements Runnable {
    private int rowIndex;
    private double[] matrix1Row;
    private double[][] matrix2;
    private double[][] result;

    /**
     * @param rowIndex row index of the first matrix
     * @param matrix1Row row of the first matrix
     * @param matrix2 second matrix
     * @param result result matrix
     */
    public MatrixRowRunnable(int rowIndex, double[] matrix1Row, double[][] matrix2, double[][] result) {
        this.rowIndex = rowIndex;
        this.matrix1Row = matrix1Row;
        this.matrix2 = matrix2;
        this.result = result;
    }

    public MatrixRowRunnable() {
    }

    @Override
    public void run() {
        System.out.printf("Multiply row %d%n", rowIndex);
        for (int i = 0;i < matrix2[0].length;i++) {
            for (int j = 0; j < matrix1Row.length; j++) {
                result[rowIndex][i] += matrix1Row[j] * matrix2[j][i];
            }
        }
    }
}
