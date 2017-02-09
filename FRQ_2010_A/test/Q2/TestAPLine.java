package Q2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for question 2.
 */
public class TestAPLine {
    @Test
    public void testConstructor() {
        APLine line1 = new APLine(5, 4, -17);
    }

    @Test
    public void testGetSlopeNegative() {
        APLine line1 = new APLine(5, 4, -17);
        Assert.assertEquals(-1.25, line1.getSlope(), 0.01);
    }

    @Test
    public void testGetSlopePositive() {
        APLine line2 = new APLine(-25, 40, 30);
        Assert.assertEquals(0.625, line2.getSlope(), 0.01);
    }

    @Test
    public void testIsOnLineTrue() {
        APLine line1 = new APLine(5, 4, -17);
        Assert.assertTrue(line1.isOnLine(5, -2));
    }

    @Test
    public void testIsOnLineFalse() {
        APLine line2 = new APLine(-25, 40, 30);
        Assert.assertFalse(line2.isOnLine(5, -2));
    }

}
