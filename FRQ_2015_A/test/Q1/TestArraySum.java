package Q1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestArraySum {
    private int[][] mat1;
    private int[][] mat2;
    private int[] arr1;

    @Before
    public void init() {
        arr1 = new int[] {1, 3, 2, 7, 3};
        mat1 = new int[][] {{1, 3, 2, 7, 3},
                {10, 10, 4, 6, 2},
                {5, 3, 5, 9, 6},
                {7, 6, 4, 2, 1}};
        mat2 = new int[][] {{1, 1, 5, 3, 4},
                {12, 7, 6, 1, 9},
                {8, 11, 10, 2, 5},
                {3, 2, 3, 0, 6}};
    }

    @Test
    public void testArraySum() {
        Assert.assertEquals(16, ArraySum.arraySum(arr1));
    }

    @Test
    public void testRowSums() {
        Assert.assertEquals(Arrays.toString(new int[]{16, 32, 28, 20}), Arrays.toString(ArraySum.rowSums(mat1)));
        Assert.assertEquals(Arrays.toString(new int[]{14, 35, 36, 14}), Arrays.toString(ArraySum.rowSums(mat2)));
    }

    @Test
    public void testIsDiverse() {
        Assert.assertTrue(ArraySum.isDiverse(mat1));
        Assert.assertFalse(ArraySum.isDiverse(mat2));
    }

}
