package Q4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestNumberGroup {

    @Test
    public void testInterface() {
        NumberGroup simple = new SimpleGroup(new int[]{1, 2, 3});
        Assert.assertTrue(simple.contains(1));
        Assert.assertFalse(simple.contains(0));
    }

    @Test
    public void testRange() {
        NumberGroup range = new Range(-3, 2);
        for (int i = -3; i <= 2; i++) {
            Assert.assertTrue(range.contains(i));
        }
        Assert.assertFalse(range.contains(-5));
        Assert.assertFalse(range.contains(10));
    }

    @Test
    public void testMultipleGroupsContains() {
        List<NumberGroup> groupList = new ArrayList<NumberGroup>();
        groupList.add(new SimpleGroup(new int[]{1, 2, 3,}));
        groupList.add(new SimpleGroup(new int[]{5, 6}));
        groupList.add(new SimpleGroup(new int[]{-1, -2}));
        MultipleGroups groups = new MultipleGroups(groupList);
        Assert.assertTrue(groups.contains(3));
        Assert.assertTrue(groups.contains(-2));
        Assert.assertFalse(groups.contains(0));
        Assert.assertFalse(groups.contains(4));
    }
}
