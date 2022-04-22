package Q4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/* Tests for Question 4. */
public class TestStats {

    Stats stats = new Stats();

    @Test
    public void testRecordAddsNewScoreToEmptyList() {
        stats.record(10);
        Assert.assertEquals(1, stats.getScoreList().size());
        Assert.assertEquals(new ScoreInfo(10), stats.getScoreList().get(0));
    }

    @Test
    public void testRecordIncrementsScore() {
        stats.record(20);
        stats.record(20);
        ScoreInfo expected = new ScoreInfo(20);
        expected.increment();
        Assert.assertEquals(1, stats.getScoreList().size());
        Assert.assertEquals(expected, stats.getScoreList().get(0));
    }

    @Test
    public void testRecordAddsNewScoreInfoToList() {
        stats.record(10);
        stats.record(20);
        Assert.assertEquals(2, stats.getScoreList().size());
        Assert.assertEquals(new ScoreInfo(10), stats.getScoreList().get(0));
        Assert.assertEquals(new ScoreInfo(20), stats.getScoreList().get(1));
    }

    @Test
    public void testRecordKeepsListSorted() {
        stats.record(20);
        stats.record(10);
        Assert.assertEquals(2, stats.getScoreList().size());
        Assert.assertEquals(new ScoreInfo(10), stats.getScoreList().get(0));
        Assert.assertEquals(new ScoreInfo(20), stats.getScoreList().get(1));
    }

    @Test
    public void testRecordReturnsTrueWhenAdding() {
        Assert.assertTrue(stats.record(10));
        Assert.assertTrue(stats.record(20));
    }

    @Test
    public void testRecordReturnsFalseWhenIncrementing() {
        Assert.assertTrue(stats.record(10));
        Assert.assertFalse(stats.record(10));
        Assert.assertFalse(stats.record(10));
    }

    @Test
    public void testRecordScores() {
        stats.recordScores(new int[]{10, 30, 20, 20, 40, 10, 20});
        List<ScoreInfo> expected = new ArrayList<>();
        expected.add(new ScoreInfo(10));
        expected.add(new ScoreInfo(20));
        expected.add(new ScoreInfo(30));
        expected.add(new ScoreInfo(40));
        expected.get(0).increment();
        expected.get(1).increment();
        expected.get(1).increment();
        Assert.assertEquals(expected, stats.getScoreList());
    }
}
