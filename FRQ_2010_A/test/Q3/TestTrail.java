package Q3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for question 2.
 */
public class TestTrail {
    Trail trail1;
    Trail trail2;

    @Before
    public void init() {
        trail1 = new Trail(new int[]{100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100});
        trail2 = new Trail(new int[]{100, 100, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100});
    }

    @Test
    public void testIsLevelTrailSegmentTrue() {
        Assert.assertTrue(trail1.isLevelTrailSegment(7, 10));

    }

    @Test
    public void testIsLevelTrailSegmentFalse() {
        Assert.assertFalse(trail1.isLevelTrailSegment(2, 12));
    }

    @Test
    public void testIsDifficultTrue() {
        Assert.assertTrue(trail1.isDifficult());
    }

    @Test
    public void testIsDifficultFalse() {
        Assert.assertFalse(trail2.isDifficult());
    }
}
