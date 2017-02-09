package Q1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by david on 1/23/2017.
 */
public class TestClimbingClub {
    ClimbingClub clubChrono;
    ClimbingClub clubAlpha;

    @Before
    public void init() {
        clubChrono = new ClimbingClub();
        clubChrono.addClimb("Monadnock", 274);
        clubChrono.addClimb("Whiteface", 301);
        clubChrono.addClimb("Algonquin", 225);
        clubChrono.addClimb("Monadnock", 344);

        clubAlpha = new ClimbingClub();
        clubAlpha.addClimbAlphabetical("Monadnock", 274);
        clubAlpha.addClimbAlphabetical("Whiteface", 301);
        clubAlpha.addClimbAlphabetical("Algonquin", 225);
        clubAlpha.addClimbAlphabetical("Monadnock", 344);
    }

    @Test
    public void testAddClimbChrono() {
        Assert.assertEquals("[[Monadnock, 274], [Whiteface, 301], [Algonquin, 225], [Monadnock, 344]]", clubChrono.toString());
    }

    @Test
    public void testAddClimbAlpha() {
        Assert.assertEquals("[[Algonquin, 225], [Monadnock, 274], [Monadnock, 344], [Whiteface, 301]]", clubAlpha.toString());
    }

    @Test
    public void testDistinctPeakNamesChrono() {
        Assert.assertEquals(4, clubChrono.distinctPeakNames());
    }

    @Test
    public void testDistinctPeakNamesAlpha() {
        Assert.assertEquals(3, clubAlpha.distinctPeakNames());
    }
}
