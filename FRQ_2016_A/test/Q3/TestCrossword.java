package Q3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestCrossword {
    private boolean[][] blackSquares;

    @Before
    public void init() {
        blackSquares = new boolean[][]{{true, false, false, true, true, true, false, false, false},
                {false, false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, true, true, true},
                {false, false, true, false, false, false, true, false, false},
                {true, true, true, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false, false},
                {false, false, false, true, true, true, false, false, true}};
    }

    @Test
    public void testToBeLabeledBlack() {
        Assert.assertFalse(Crossword.toBeLabeled(0, 0, blackSquares));
    }

    @Test
    public void testToBeLabeledWhite() {
        Assert.assertFalse(Crossword.toBeLabeled(1, 1, blackSquares));
    }

    @Test
    public void testToBeLabeledWhiteLabel() {
        Assert.assertTrue(Crossword.toBeLabeled(1, 0, blackSquares));
        Assert.assertTrue(Crossword.toBeLabeled(0, 1, blackSquares));
        Assert.assertTrue(Crossword.toBeLabeled(2, 4, blackSquares));
    }

    @Test
    public void testConstructor() {
        String correct = "B\t1\t2\tB\tB\tB\t3\t4\t5\t\n" +
                "6\t \t \t7\tB\t8\t \t \t \t\n" +
                "9\t \t \t \t10\t \tB\tB\tB\t\n" +
                "11\t \tB\t12\t \t \tB\t13\t14\t\n" +
                "B\tB\tB\t15\t \t \t16\t \t \t\n" +
                "17\t18\t19\t \tB\t20\t \t \t \t\n" +
                "21\t \t \tB\tB\tB\t22\t \tB\t\n";
        Assert.assertEquals(correct, new Crossword(blackSquares).toString());
    }

}
