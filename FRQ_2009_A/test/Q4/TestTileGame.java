package Q4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Run me when you're done with Question 4.
 */
public class TestTileGame {
    private TileGame test;
    private ArrayList<NumberTile> myBoard;
    private NumberTile first;
    private NumberTile second;
    private NumberTile third;
    private NumberTile fourth;
    private NumberTile fifth;

    @Before
    public void init() {
        first = new NumberTile(new int[]{4, 3, 7, 4});
        second = new NumberTile(new int[]{6, 4, 3, 3});
        third = new NumberTile(new int[]{1, 2, 3, 4});
        fourth = new NumberTile(new int[]{3, 2, 5, 2});
        fifth = new NumberTile(new int[]{5, 9, 2, 2});
        myBoard = new ArrayList<NumberTile>();
        myBoard.add(first);
        myBoard.add(second);
        myBoard.add(third);
        myBoard.add(fourth);
        myBoard.add(fifth);
        test = new TileGame(myBoard);
    }

    @Test
    public void testGetIndexForFitMiddle() {
        NumberTile toInsert = new NumberTile(new int[]{4, 2, 9, 2});
        Assert.assertTrue(3 == test.getIndexForFit(toInsert) || 4 == test.getIndexForFit(toInsert));

    }

    @Test
    public void testGetIndexForFitEmpty() {
        NumberTile tile = new NumberTile(new int[]{1, 1, 1, 1});
        TileGame empty = new TileGame();
        Assert.assertEquals(0, empty.getIndexForFit(tile));
    }

    @Test
    public void testGetIndexForFitFront() {
        NumberTile insertAtFront = new NumberTile(new int[]{-1, 4, -1, -1});
        Assert.assertEquals(0, test.getIndexForFit(insertAtFront));
    }

    @Test
    public void testGetIndexForFitNone() {
        NumberTile noInsert = new NumberTile(new int[]{4, 2, 9, 8});
        Assert.assertEquals(-1, test.getIndexForFit(noInsert));
    }

    @Test
    public void testGetIndexForFitSecond() {
        NumberTile insertSecond = new NumberTile(new int[]{-1, 3, -1, 3});
        Assert.assertEquals(1, test.getIndexForFit(insertSecond));
    }

    @Test
    public void testGetIndexForFitSecondToLast() {
        ArrayList<NumberTile> board = new ArrayList<NumberTile>();
        board.add(first);
        board.add(second);
        board.add(fourth);
        board.add(fifth);
        TileGame game = new TileGame(board);
        NumberTile toAdd = new NumberTile(new int[]{-1, 2, -1, 2});
        Assert.assertEquals(3, game.getIndexForFit(toAdd));
    }

    @Test
    public void testGetIndexForFitLast() {
        NumberTile insertAtEnd = new NumberTile(new int[]{-1, -1, -1, 9});
        Assert.assertEquals(5, test.getIndexForFit(insertAtEnd));
    }


    @Test
    public void testInsertTileAtFront() {
        NumberTile insertAtFront = new NumberTile(new int[]{-1, 4, -1, -1});
        Assert.assertTrue(test.insertTile(insertAtFront));
        boolean isCorrect = false;
        String atFront = "[[-1, 4, -1, -1], [4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [5, 9, 2, 2]]";
        if (atFront.equals(test.toString())) {
            isCorrect = true;
        }
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void testInsertTileAtFrontRotate() {
        NumberTile insertAtFront = new NumberTile(new int[]{-1, -1, -1, 4});
        Assert.assertTrue(test.insertTile(insertAtFront));
        String atFront = "[[-1, 4, -1, -1], [4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [5, 9, 2, 2]]";
        Assert.assertEquals(atFront, test.toString());
    }

    @Test
    public void testInsertTileAtEnd() {
        NumberTile insertAtEnd = new NumberTile(new int[]{-1, -1, -1, 9});
        String atEnd = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [5, 9, 2, 2], [-1, -1, -1, 9]]";
        Assert.assertTrue(test.insertTile(insertAtEnd));
        Assert.assertEquals(atEnd, test.toString());
    }

    @Test
    public void testInsertTileAtEndRotate() {
        NumberTile insertAtEnd = new NumberTile(new int[]{-1, 9, -1, -1});
        String atEnd = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [5, 9, 2, 2], [-1, -1, -1, 9]]";
        Assert.assertTrue(test.insertTile(insertAtEnd));
        Assert.assertEquals(atEnd, test.toString());
    }

    @Test
    public void testInsertTileNoInsert() {
        NumberTile noInsert = new NumberTile(new int[]{-1, -1, -1, -1});
        String same = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [5, 9, 2, 2]]";
        Assert.assertFalse(test.insertTile(noInsert));
        Assert.assertEquals(same, test.toString());
    }

    @Test
    public void testInsertTileInMiddle() {
        //Put one either in the first, third, fourth or last position
        NumberTile toInsert = new NumberTile(new int[]{4, 2, 9, 2});
        Assert.assertTrue(test.insertTile(toInsert));
        String[] possibleCorrectBoards = new String[5];
        possibleCorrectBoards[0] = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [4, 2, 9, 2], [3, 2, 5, 2], [5, 9, 2, 2]]";
        possibleCorrectBoards[1] = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [9, 2, 4, 2], [3, 2, 5, 2], [5, 9, 2, 2]]";
        possibleCorrectBoards[2] = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [4, 2, 9, 2], [5, 9, 2, 2]]";
        possibleCorrectBoards[3] = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [9, 2, 4, 2], [5, 9, 2, 2]]";
        possibleCorrectBoards[4] = "[[4, 3, 7, 4], [6, 4, 3, 3], [1, 2, 3, 4], [3, 2, 5, 2], [5, 9, 2, 2], [2, 4, 2, 9]]";
        boolean isCorrect = false;
        for (int i = 0; i < 5; i++) {
            if (possibleCorrectBoards[i].equals(test.toString())) {
                isCorrect = true;
            }
        }
        Assert.assertTrue(isCorrect);
    }
}
