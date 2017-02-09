package Q2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestHiddenWord {
    HiddenWord word;

    @Before
    public void testConstructor() {
        word = new HiddenWord("HARPS");
    }

    @Test
    public void testGetHintCorrect() {
        Assert.assertEquals("HARPS", word.getHint("HARPS"));
    }

    @Test
    public void testGetHintNotThere() {
        Assert.assertEquals("*****", word.getHint("JELLO"));
    }

    @Test
    public void testGetHintAAAAA() {
        Assert.assertEquals("+A+++", word.getHint("AAAAA"));
    }

    @Test
    public void testGetHintMostCorrect() {
        Assert.assertEquals("HAR*S", word.getHint("HARMS"));
    }

    @Test
    public void testGetHintSomeThereSomeNot() {
        Assert.assertEquals("H*++*", word.getHint("HEART"));
    }
}
