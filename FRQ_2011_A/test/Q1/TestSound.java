package Q1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by daackerman on 1/23/2017.
 */
public class TestSound {
    private Sound test1;
    private Sound test2;

    @Before
    public void init() {
        test1 = new Sound(new int[]{40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223});
        test2 = new Sound(new int[]{0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0});
    }

    @Test
    public void testLimitAmplitude() {
        Assert.assertEquals(5, test1.limitAmplitude(2000));
        Assert.assertEquals("[40, 2000, 17, -2000, -17, -2000, 2000, 1048, -420, 33, 15, -32, 2000, 2000]", test1.toString());
    }

    @Test
    public void testTrimSilence() {
        test2.trimSilenceFromBeginning();
        Assert.assertEquals("[-14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0]", test2.toString());
    }
}
