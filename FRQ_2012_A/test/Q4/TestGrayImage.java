package Q4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by david on 1/23/2017.
 */
public class TestGrayImage {

    @Test
    public void testCountWhitePixels() {
        GrayImage img = new GrayImage(new int[][]{{255, 184, 178, 84, 129}, {84,255,255,130,84}, {78,255,0,0,78}, {84,130,255,130,84}});
        Assert.assertEquals(5, img.countWhitePixels());
    }

    @Test
    public void testProcessImage() {
        GrayImage img = new GrayImage(new int[][]{{221, 184, 178, 84, 135},{84, 255, 255, 130, 84},{78, 255, 0, 0, 78},{84, 130, 255, 130, 84}});
        String expected = "221\t184\t100\t84\t135\t\n" +
                "0\t125\t171\t130\t84\t\n" +
                "78\t255\t0\t0\t78\t\n" +
                "84\t130\t255\t130\t84\t\n";
        img.processImage();
        Assert.assertEquals(expected, img.toString());
    }
}
