package matrix;
/**
 * @author Pavel Burdyug
 */
public class Main {
    public static void main(String[] args) {
        double[][] m1 = {{4, 2}, {9, 0}};
        double[][] m2 = {{3, 1}, {-3, 4}};
        ParallelMatrixMultiplier multiplier = new ParallelMatrixMultiplier();
        try {
            double[][] res = multiplier.multiply(m1, m2);
            for (double[] row : res) {
                for (double num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

