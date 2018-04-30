package Q2;

import org.junit.Assert;
import org.junit.Test;

/* Tests for Question 2. */
public class TestMountain {

    @Test
    public void testGetPeakIndexFound1() {
        int[] arr = {1,2,1};
        Assert.assertEquals(1, Mountain.getPeakIndex(arr));
    }

    @Test
    public void testGetPeakIndexFound2() {
        int[] arr = {1, 2, 3, 2};
        Assert.assertEquals(2, Mountain.getPeakIndex(arr));
    }

    @Test
    public void testGetPeakIndexFound3() {
        int[] arr = {1, 2, 1, 2, 1};
        Assert.assertEquals(1, Mountain.getPeakIndex(arr));
    }

    @Test
    public void testGetPeakIndexNotFound1() {
        int[] arr = {1, 2, 3};
        Assert.assertEquals(-1, Mountain.getPeakIndex(arr));
    }

    @Test
    public void testGetPeakIndexNotFound2() {
        int[] arr = {3, 2, 1};
        Assert.assertEquals(-1, Mountain.getPeakIndex(arr));
    }

    @Test
    public void testGetPeakIndexNotFound3() {
        int[] arr = {1, 1, 1};
        Assert.assertEquals(-1, Mountain.getPeakIndex(arr));
    }

    @Test
    public void testGetPeakIndexNotFound4() {
        int[] arr = {2, 1, 2};
        Assert.assertEquals(-1, Mountain.getPeakIndex(arr));
    }

    @Test
    public void testIsMountainTrue1() {
        int[] arr = {1, 2, 1};
        Assert.assertTrue(Mountain.isMountain(arr));
    }

    @Test
    public void testIsMountainTrue2() {
        int[] arr = {1, 2, 3, 1};
        Assert.assertTrue(Mountain.isMountain(arr));
    }

    @Test
    public void testIsMountainTrue3() {
        int[] arr = {1, 3, 2, 1};
        Assert.assertTrue(Mountain.isMountain(arr));
    }

    @Test
    public void testIsMountainFalse1() {
        int[] arr = {1, 1, 1};
        Assert.assertFalse(Mountain.isMountain(arr));
    }

    @Test
    public void testIsMountainFalse2() {
        int[] arr = {2, 1, 2};
        Assert.assertFalse(Mountain.isMountain(arr));
    }

    @Test
    public void testIsMountainFalse3() {
        int[] arr = {1, 2, 1, 2, 1};
        Assert.assertFalse(Mountain.isMountain(arr));
    }

    @Test
    public void testIsMountainFalse4() {
        int[] arr = {1, 2, 3, 1, 5};
        Assert.assertFalse(Mountain.isMountain(arr));
    }

    @Test
    public void testIsMountainFalse5() {
        int[] arr = {3, 2, 1};
        Assert.assertFalse(Mountain.isMountain(arr));
    }
}
