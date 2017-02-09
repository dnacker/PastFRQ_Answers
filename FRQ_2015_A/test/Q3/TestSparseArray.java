package Q3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestSparseArray {
    List<SparseArrayEntry> list;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(new SparseArrayEntry(1, 4, 4));
        list.add(new SparseArrayEntry(2, 0, 1));
        list.add(new SparseArrayEntry(3, 1, -9));
        list.add(new SparseArrayEntry(1, 1, 5));
    }

    @Test
    public void testGetValueAt() {
        SparseArray myArray = new SparseArray(list, 6, 5);
        String correct = "0\t0\t0\t0\t0\n" +
                "0\t5\t0\t0\t4\n" +
                "1\t0\t0\t0\t0\n" +
                "0\t-9\t0\t0\t0\n" +
                "0\t0\t0\t0\t0\n" +
                "0\t0\t0\t0\t0\n";
        Assert.assertEquals(correct, myArray.toString());
    }

    @Test
    public void testRemoveColumnNewColumns() {
        SparseArray myArray = new SparseArray(list, 6, 5);
        myArray.removeColumn(1);
        Assert.assertEquals(4, myArray.getNumCols());
    }

    @Test
    public void testRemoveColumnFromColumn() {
        SparseArray myArray = new SparseArray(list, 6, 5);
        myArray.removeColumn(1);
        Assert.assertFalse(myArray.contains(new SparseArrayEntry(1, 1, 5)));
    }

    @Test
    public void testRemoveColumnLeft() {
        SparseArray myArray = new SparseArray(list, 6, 5);
        myArray.removeColumn(1);
        Assert.assertTrue(myArray.contains(new SparseArrayEntry(2, 0, 1)));
    }

    @Test
    public void testRemoveColumnRight() {
        SparseArray myArray = new SparseArray(list, 6, 5);
        myArray.removeColumn(1);
        Assert.assertTrue(myArray.contains(new SparseArrayEntry(1, 3, 4)));
    }
}
