package Q3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDelimiters {
    private String openDel = "a>";
    private String closedDel = "<b";
    private Delimiters delimiters = new Delimiters(openDel, closedDel);

    @Test
    public void testGetDelimitersList() {
        String[] tokens = new String[] { openDel, closedDel, openDel+closedDel, "foo", openDel, "a<", "<bobby", "A>"};
        Assert.assertEquals(Arrays.asList(openDel, closedDel, openDel), delimiters.getDelimitersList(tokens));
    }

    @Test
    public void testIsBalancedSimple() {
        Assert.assertTrue(delimiters.isBalanced(createDelimiterList(openDel, closedDel)));
    }

    @Test
    public void testIsBalancedNotBalancedOpen() {
        Assert.assertFalse(delimiters.isBalanced(createDelimiterList(openDel)));
        Assert.assertFalse(delimiters.isBalanced(createDelimiterList(openDel, openDel)));
    }

    @Test
    public void testIsBalancedNotBalancedClosed() {
        Assert.assertFalse(delimiters.isBalanced(createDelimiterList(closedDel)));
        Assert.assertFalse(delimiters.isBalanced(createDelimiterList(closedDel, closedDel)));
    }

    @Test
    public void testIsBalancedBalancedMultipleOpen() {
        Assert.assertTrue(delimiters.isBalanced(createDelimiterList(openDel, openDel, openDel, closedDel, closedDel, closedDel)));
    }

    @Test
    public void testIsBalancedBalancedMultiplePairs() {
        Assert.assertTrue(delimiters.isBalanced(createDelimiterList(openDel, closedDel, openDel, closedDel, openDel, openDel, closedDel, closedDel)));
    }

    @Test
    public void testIsBalancedBalancedComplex() {
        Assert.assertTrue(delimiters.isBalanced(createDelimiterList(openDel, openDel, closedDel, openDel, openDel, closedDel, closedDel, closedDel)));
    }

    @Test
    public void testIsBalanceNotBalanced() {
        Assert.assertFalse(delimiters.isBalanced(createDelimiterList(openDel, openDel, closedDel, openDel, closedDel, closedDel, closedDel, closedDel)));
        Assert.assertFalse(delimiters.isBalanced(createDelimiterList(closedDel, openDel, closedDel, openDel, openDel, closedDel, closedDel, openDel)));
    }

    private static ArrayList<String> createDelimiterList(String... args) {
        return new ArrayList<>(Arrays.asList(args));
    }
}
