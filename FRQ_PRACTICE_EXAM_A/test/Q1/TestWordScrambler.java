package Q1;

import org.junit.Assert;
import org.junit.Test;

/* Tests for Question 1. */
public class TestWordScrambler {
    public static final String[] words = {"aa", "bb", "ccc", "ddd"};
    public static final String ans = "[ab, ba, cdd, dcc]";

    @Test
    public void testRecombineBothEven() {
        String a = "ab";
        String b = "cd";
        Assert.assertEquals("ad", WordScrambler.recombine(a, b));
    }

    @Test
    public void testRecombineEvenOdd() {
        String a = "ab";
        String b = "cde";
        Assert.assertEquals("ade", WordScrambler.recombine(a, b));
    }

    @Test
    public void testRecombineOddEven() {
        String a = "abc";
        String b = "de";
        Assert.assertEquals("ae", WordScrambler.recombine(a, b));
    }

    @Test
    public void testRecombineBothOdd() {
        String a = "abc";
        String b = "def";
        Assert.assertEquals("aef", WordScrambler.recombine(a, b));
    }

    @Test
    public void testMixedWords() {
        WordScrambler ws = new WordScrambler(words);
        String[] expected = {"ab", "ba", "cdd", "dcc"};
        Assert.assertArrayEquals(expected, ws.getScrambledWords());
    }
}
