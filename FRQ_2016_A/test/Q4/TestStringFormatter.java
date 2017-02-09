package Q4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for StringFormatter methods.
 */
public class TestStringFormatter {

    @Test
    public void testTotalLetters() {
        List<String> words = new ArrayList<>();
        words.add("A");
        words.add("frog");
        words.add("is");
        Assert.assertEquals(7, StringFormatter.totalLetters(words));
    }

    @Test
    public void testBasicGapWidth() {
        List<String> test1 = new ArrayList<>();
        test1.add("AP");
        test1.add("COMP");
        test1.add("SCI");
        test1.add("ROCKS");

        List<String> test2 = new ArrayList<>();
        test2.add("GREEN");
        test2.add("EGGS");
        test2.add("AND");
        test2.add("HAM");

        List<String> test3 = new ArrayList<>();
        test3.add("BEACH");
        test3.add("BALL");

        Assert.assertEquals(2, StringFormatter.basicGapWidth(test1, 20));
        Assert.assertEquals(1, StringFormatter.basicGapWidth(test2, 20));
        Assert.assertEquals(11, StringFormatter.basicGapWidth(test3, 20));
    }

    @Test
    public void testFormat() {
        List<String> test1 = new ArrayList<>();
        test1.add("AP");
        test1.add("COMP");
        test1.add("SCI");
        test1.add("ROCKS");

        List<String> test2 = new ArrayList<>();
        test2.add("GREEN");
        test2.add("EGGS");
        test2.add("AND");
        test2.add("HAM");

        List<String> test3 = new ArrayList<>();
        test3.add("BEACH");
        test3.add("BALL");

        Assert.assertEquals("AP  COMP  SCI  ROCKS", StringFormatter.format(test1, 20));
        Assert.assertEquals("GREEN  EGGS  AND HAM", StringFormatter.format(test2, 20));
        Assert.assertEquals("BEACH           BALL", StringFormatter.format(test3, 20));
    }
}
