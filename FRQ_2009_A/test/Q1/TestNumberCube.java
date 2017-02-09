package Q1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Run me when you're done with question 1.
 */
public class TestNumberCube {
    private NumberCube cube;

    @Before
    public void init() {
        cube = new NumberCube(42);
    }

    @Test
    public void testGetCubeTosses() {
        int[] first = {3, 4, 1, 3, 1};
        int[] second = {2, 6, 3, 2, 6, 3, 3, 1, 1, 3};
        int[] third = {3, 1, 1, 2, 6, 3, 2, 3, 4, 6, 4, 5, 5, 2, 1, 5, 1, 3, 6, 6, 6, 1, 2, 2, 1, 6, 2, 6, 2, 6};
        Assert.assertArrayEquals(first, NumberCubeRunner.getCubeTosses(cube, 5));
        Assert.assertArrayEquals(second, NumberCubeRunner.getCubeTosses(cube, 10));
        Assert.assertArrayEquals(third, NumberCubeRunner.getCubeTosses(cube, 30));
    }

    @Test
    public void testGetLongestRunEmpty() {
        int[] testEmpty = {};
        System.out.println("actual: " + NumberCubeRunner.getLongestRun(testEmpty) + " expected: -1");
        Assert.assertEquals(-1, NumberCubeRunner.getLongestRun(testEmpty));
    }

    @Test
    public void testGetLongestRunNone() {
        int[] testNegative1 = {1, 3, 4, 6};
        System.out.println("actual: " + NumberCubeRunner.getLongestRun(testNegative1) + " expected: -1");
        Assert.assertEquals(-1, NumberCubeRunner.getLongestRun(testNegative1));
    }

    @Test
    public void testGetLongestRunStart() {
        int[] test1 = {1, 1, 3, 4, 6};
        System.out.println("actual: " + NumberCubeRunner.getLongestRun(test1) + " expected: 0");
        Assert.assertEquals(0, NumberCubeRunner.getLongestRun(test1));
    }

    @Test
    public void testGetLongestRunMiddle() {
        int[] test2 = {1, 1, 3, 4, 4, 4, 6};
        System.out.println("actual: " + NumberCubeRunner.getLongestRun(test2) + " expected: 3");
        Assert.assertEquals(3, NumberCubeRunner.getLongestRun(test2));
    }

    @Test
    public void testGetLongestRunMultiple() {
        int[] test3 = {1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5};
        System.out.println("actual: " + NumberCubeRunner.getLongestRun(test3) + " expected: 6");
        Assert.assertTrue(6 == NumberCubeRunner.getLongestRun(test3) || 14 == NumberCubeRunner.getLongestRun(test3));
    }

}
