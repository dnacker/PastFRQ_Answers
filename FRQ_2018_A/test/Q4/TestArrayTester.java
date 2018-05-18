package Q4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Question 4.
 */

public class TestArrayTester {
    @Test
    public void testGetColumnLength() {
        int[][] mat = new int[3][4];
        int[] col = ArrayTester.getColumn(mat, 0);
        Assert.assertEquals(3, col.length);
    }

    @Test
    public void testGetColumnFillCorrect() {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] cols = {{1,4,7},
                {2, 5, 8},
                {3, 6, 9}};
        for (int i = 0; i < mat.length; i++) {
            Assert.assertArrayEquals(cols[i], ArrayTester.getColumn(mat, i));
        }
    }

    @Test
    public void testIsLatinTrue() {
        int[][] latin1 = {{4, 5, 6},
                {6, 4, 5},
                {5, 6, 4}};
        int[][] latin2 ={{1,2},
                {2,1}};
        int[][] latin3 = {{1, 2, 3, 4},
                {2, 1, 4, 3},
                {3, 4, 1, 2},
                {4, 3, 2, 1}};

        Assert.assertTrue(ArrayTester.isLatin(latin1));
        Assert.assertTrue(ArrayTester.isLatin(latin2));
        Assert.assertTrue(ArrayTester.isLatin(latin3));
    }

    @Test
    public void testIsLatinFalse() {
        int[][] latin1 = {{1, 2},
                {1, 2}};
        int[][] latin2 = {{1, 1},
                {1, 1}};
        int[][] latin3 = {{1, 2, 3},
                {3, 1, 2},
                {1, 3, 2}};
        int[][] latin4 = {{1, 2, 1},
                {2, 1, 1},
                {1, 1, 2}};

        Assert.assertFalse(ArrayTester.isLatin(latin1));
        Assert.assertFalse(ArrayTester.isLatin(latin2));
        Assert.assertFalse(ArrayTester.isLatin(latin3));
        Assert.assertFalse(ArrayTester.isLatin(latin4));
    }
}
