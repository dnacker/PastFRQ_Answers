package Q2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Tests for Question 2.
 */
public class TestWordPairList {
    @Test
    public void testConstructorTwo() {
        String[] arr = {"a", "b"};
        ArrayList<WordPair> list = new ArrayList<>();
        list.add(new WordPair("a", "b"));

        WordPairList wpList = new WordPairList(arr);

        for (WordPair wp: list) {
            Assert.assertTrue(wpList.getList().contains(wp));
        }
        Assert.assertEquals(list.size(), wpList.getList().size());
    }

    @Test
    public void testConstructorThree() {
        String[] arr = {"a", "b", "c"};
        ArrayList<WordPair> list = new ArrayList<>();
        list.add(new WordPair("a", "b"));
        list.add(new WordPair("a", "c"));
        list.add(new WordPair("b", "c"));

        WordPairList wpList = new WordPairList(arr);

        Assert.assertEquals(list.size(), wpList.getList().size());
        for (WordPair wp: list) {
            Assert.assertTrue(wpList.getList().contains(wp));
        }
    }

    @Test
    public void testConstructorFour() {
        String[] arr = {"a", "b", "c", "d"};
        ArrayList<WordPair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                list.add(new WordPair(arr[i], arr[j]));
            }
        }
        WordPairList wpList = new WordPairList(arr);

        Assert.assertEquals(list.size(), wpList.getList().size());
        for (WordPair wp: list) {
            Assert.assertTrue(wpList.getList().contains(wp));
        }
    }

    @Test
    public void testNumMatchesZero() {
        String[] arr = {"a", "b"};
        WordPairList wpList = new WordPairList(arr);
        Assert.assertEquals(0, wpList.numMatches());
    }

    @Test
    public void testNumMatchesOne() {
        String[] arr = {"a", "b", "a"};
        WordPairList wpList = new WordPairList(arr);
        Assert.assertEquals(1, wpList.numMatches());
    }

    @Test
    public void testNumMatchesTwo() {
        String[] arr = {"a", "a", "b", "b"};
        WordPairList wpList = new WordPairList(arr);
        Assert.assertEquals(2, wpList.numMatches());
    }

    @Test
    public void testNumMatchesThree() {
        String[] arr = {"a", "a", "a"};
        WordPairList wpList = new WordPairList(arr);
        Assert.assertEquals(3, wpList.numMatches());
    }

    @Test
    public void testNumMatchesFour() {
        String[] arr = {"a", "a", "a", "b", "b"};
        WordPairList wpList = new WordPairList(arr);
        Assert.assertEquals(4, wpList.numMatches());
    }

}
