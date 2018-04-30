package Q3;

import org.junit.Assert;
import org.junit.Test;

public class TestPhrase {

    @Test
    public void testReplaceNthOccurrenceFound1() {
        Phrase phrase = new Phrase("A cat ate late.");
        phrase.replaceNthOccurrence("at", 1,"rane");
        Assert.assertEquals("A crane ate late.", phrase.toString());
    }

    @Test
    public void testReplaceNthOccurrenceFound2() {
        Phrase phrase = new Phrase("A cat ate late.");
        phrase.replaceNthOccurrence("at", 2,"cam");
        Assert.assertEquals("A cat came late.", phrase.toString());
    }

    @Test
    public void testReplaceNthOccurrenceNotFound1() {
        Phrase phrase = new Phrase("A cat ate late.");
        phrase.replaceNthOccurrence("foo", 1,"bar");
        Assert.assertEquals("A cat ate late.", phrase.toString());
    }

    @Test
    public void testReplaceNthOccurrenceNotFound2() {
        Phrase phrase = new Phrase("A cat ate late.");
        phrase.replaceNthOccurrence("at", 4,"bar");
        Assert.assertEquals("A cat ate late.", phrase.toString());
    }

    @Test
    public void testFindLastOccurrenceFound() {
        Phrase phrase = new Phrase("aaaaa");
        int last = phrase.findLastOccurrence("a");
        Assert.assertEquals(4, last);
    }

    @Test
    public void testFindLastOccurrenceNotFound() {
        Phrase phrase = new Phrase("aaaaa");
        int last = phrase.findLastOccurrence("b");
        Assert.assertEquals(-1, last);
    }
}
