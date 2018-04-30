package Q4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestSuccessors {
    private static final int[][] arr = {{15, 5, 9, 10}, {12, 16, 11, 6}, {14, 8, 13, 7}};
    private static final String[] pos = {"[(1, 1), (1, 3), (0, 3), (1, 2)]",
            "[(2, 2), null, (1, 0), (2, 3)]",
            "[(0, 0), (0, 2), (2, 0), (2, 1)]"};

    @Test
    public void testFindPositionFound() {
        Position ans1 = new Position(2, 1);
        Position ans2 = new Position(0, 0);
        Assert.assertEquals(ans1, Successors.findPosition(8, arr));
        Assert.assertEquals(ans2, Successors.findPosition(15, arr));
    }

    @Test
    public void testFindPositionNotFound() {
        Assert.assertNull(Successors.findPosition(4, arr));
        Assert.assertNull(Successors.findPosition(17, arr));
    }

    @Test
    public void testGetSuccessorArrayLength() {
        Position[][] successors = Successors.getSuccessorArray(arr);
        Assert.assertEquals(3, successors.length);
        Assert.assertEquals(4, successors[0].length);
    }

    @Test
    public void testGetSuccessorArray() {
        Position[][] successors = Successors.getSuccessorArray(arr);
        for (int i = 0; i < successors.length; i++) {
            Assert.assertEquals(pos[i], Arrays.toString(successors[i]));
        }
    }
}
