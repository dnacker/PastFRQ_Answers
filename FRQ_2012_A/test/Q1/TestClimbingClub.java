package Q1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for question 1.
 */
public class TestClimbingClub {
    ClimbingClub clubChrono;
    ClimbingClub clubAlpha;

    @Before
    public void init() {
        clubChrono = new ClimbingClub();
        clubAlpha = new ClimbingClub();
    }

    @Test
    public void testAddClimbChrono() {
        clubChrono.addClimb("Monadnock", 274);
        clubChrono.addClimb("Whiteface", 301);
        clubChrono.addClimb("Algonquin", 225);
        clubChrono.addClimb("Monadnock", 344);
        Assert.assertEquals("[[Monadnock, 274], [Whiteface, 301], [Algonquin, 225], [Monadnock, 344]]", clubChrono.toString());
    }

    @Test
    public void testAddClimbAlpha() {
        clubAlpha.addClimbAlphabetical("Monadnock", 274);
        clubAlpha.addClimbAlphabetical("Whiteface", 301);
        clubAlpha.addClimbAlphabetical("Algonquin", 225);
        Assert.assertEquals("[[Algonquin, 225], [Monadnock, 274], [Whiteface, 301]]", clubAlpha.toString());
    }

    @Test
    public void testDistinctPeakNamesChrono() {
        clubChrono.addClimb("Monadnock", 274);
        clubChrono.addClimb("Whiteface", 301);
        clubChrono.addClimb("Algonquin", 225);
        clubChrono.addClimb("Monadnock", 344);
        Assert.assertEquals(4, clubChrono.distinctPeakNames());
    }

    @Test
    public void testDistinctPeakNamesAlpha() {
        clubAlpha.addClimbAlphabetical("Monadnock", 274);
        clubAlpha.addClimbAlphabetical("Whiteface", 301);
        clubAlpha.addClimbAlphabetical("Algonquin", 225);
        clubAlpha.addClimbAlphabetical("Monadnock", 344);
        Assert.assertEquals(3, clubAlpha.distinctPeakNames());
    }
}
