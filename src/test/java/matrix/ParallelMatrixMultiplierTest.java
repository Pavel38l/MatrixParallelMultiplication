package matrix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Burdyug Pavel
 */
public class ParallelMatrixMultiplierTest {

    private ParallelMatrixMultiplier multiplier;

    @Before
    public void setUp() {
        multiplier = new ParallelMatrixMultiplier();
    }

    @Test
    public void multiply() throws InterruptedException {
        double[][] m1 = {{-1, 1}, {2, 0}, {0, 3}};
        double[][] m2 = {{3, 1, 2}, {0, -1, 4}};
        double[][] expectedRes = {{-3, -2, 2}, {6, 2, 4}, {0, -3, 12}};
        double[][] res = multiplier.multiply(m1, m2);
        Assert.assertArrayEquals(expectedRes, res);
    }
}