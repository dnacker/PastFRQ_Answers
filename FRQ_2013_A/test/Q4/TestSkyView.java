package Q4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by david on 1/23/2017.
 */
public class TestSkyView {

    @Test
    public void testSkyViewConstructor() {
        SkyView one = new SkyView(4, 3, new double[]{0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9});
        SkyView two = new SkyView(3, 2, new double[]{0.3, 0.7, 0.8, 0.4, 1.4, 1.1});
        Assert.assertEquals("0.3 0.7 0.8 \n" +
                "1.1 1.4 0.4 \n" +
                "0.2 0.5 0.1 \n" +
                "0.9 0.6 1.6 \n", one.toString());
        Assert.assertEquals("0.3 0.7 \n" +
                "0.4 0.8 \n" +
                "1.4 1.1 \n",  two.toString());
    }

    @Test
    public void testGetAverage() {
        SkyView one = new SkyView(4, 3, new double[]{0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9});
        Assert.assertEquals(0.8, one.getAverage(1, 2, 0, 1), 0.001);
        Assert.assertEquals(0.7, one.getAverage(0, 2, 0, 1), 0.001);
    }
}
