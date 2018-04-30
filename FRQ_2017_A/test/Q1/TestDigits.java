package Q1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Question 1.
 */
public class TestDigits {

    @Test
    public void testConstructorZero() {
        Assert.assertEquals("0", (new Digits(0)).toString());
    }

    @Test
    public void testConstructorOneDigit() {
        for (int i = 1; i <= 9; i++) {
            Assert.assertEquals(i + "", (new Digits(i)).toString());
        }
    }

    @Test
    public void testConstructorManyDigits() {
        Assert.assertEquals("123456789", (new Digits(123456789).toString()));
        Assert.assertEquals("987654321", (new Digits(987654321).toString()));
    }

    @Test
    public void testIsIncreasingOne() {
        Digits one = new Digits(5);
        Assert.assertTrue(one.isStrictlyIncreasing());
    }

    @Test
    public void testIsIncreasingTwoTrue() {
        Digits d = new Digits(12);
        Assert.assertTrue(d.isStrictlyIncreasing());
    }

    @Test
    public void testIsIncreasingTwoFalse() {
        Digits d = new Digits(21);
        Assert.assertFalse(d.isStrictlyIncreasing());
    }

    @Test
    public void testIsIncreasingTwoSameFalse() {
        Digits d = new Digits(11);
        Assert.assertFalse(d.isStrictlyIncreasing());
    }

    @Test
    public void testIsIncreasingMultipleTrue() {
        Assert.assertTrue(new Digits(123).isStrictlyIncreasing());
        Assert.assertTrue(new Digits(13579).isStrictlyIncreasing());
        Assert.assertTrue(new Digits(123456789).isStrictlyIncreasing());
    }

    @Test
    public void testIsIncreasingMultipleFalse() {
        Assert.assertFalse(new Digits(321).isStrictlyIncreasing());
        Assert.assertFalse(new Digits(13597).isStrictlyIncreasing());
        Assert.assertFalse(new Digits(1123456789).isStrictlyIncreasing());
    }
}
