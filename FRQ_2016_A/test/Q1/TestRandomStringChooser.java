package Q1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestRandomStringChooser {

    @Test
    public void testRandomStringChooserConstructor() {
        String[] wordArray = {"wheels", "on", "fire"};
        RandomStringChooser chooser = new RandomStringChooser(wordArray);
    }

    @Test
    public void testRandomStringChooserGetNext() {
        String[] wordArray = {"wheels", "on", "fire"};
        RandomStringChooser chooser = new RandomStringChooser(wordArray);
        String text = "";
        for (int i = 0; i < 5; i++) {
            text += chooser.getNext();
        }
        Assert.assertTrue(text.contains("wheels"));
        Assert.assertTrue(text.contains("on"));
        Assert.assertTrue(text.contains("fire"));
        Assert.assertEquals("NONENONE",text.substring(12));
    }

    @Test
    public void testRandomLetterChooser() {
        String cat = "cat";
        RandomLetterChooser chooser = new RandomLetterChooser(cat);
        String text = "";
        for (int i = 0; i < 4; i++) {
            text += chooser.getNext();
        }
        Assert.assertTrue(text.contains("c"));
        Assert.assertTrue(text.contains("a"));
        Assert.assertTrue(text.contains("t"));
        Assert.assertEquals("NONE", text.substring(3));
    }

}
