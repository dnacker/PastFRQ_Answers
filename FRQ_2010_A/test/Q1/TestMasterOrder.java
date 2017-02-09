package Q1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 * Tests for question 1.
 */
public class TestMasterOrder {
    private MasterOrder order;

    @Before
    public void init() {
        order = new MasterOrder();
        order.addOrder(new CookieOrder("Chocolate Chip", 1));
        order.addOrder(new CookieOrder("Shortbread", 5));
        order.addOrder(new CookieOrder("Macaroon", 2));
        order.addOrder(new CookieOrder("Chocolate Chip", 3));
    }

    @Test
    public void testGetTotalBoxesEmpty() {
        MasterOrder empty = new MasterOrder();
        Assert.assertEquals(0, empty.getTotalBoxes());
    }

    @Test
    public void testGetTotalBoxesOne() {
        MasterOrder one = new MasterOrder();
        one.addOrder(new CookieOrder("foo", 1));
        Assert.assertEquals(1, one.getTotalBoxes());
    }

    @Test
    public void testGetTotalBoxesTwoSameVariety() {
        MasterOrder two = new MasterOrder();
        two.addOrder(new CookieOrder("foo", 1));
        two.addOrder(new CookieOrder("foo", 2));
        Assert.assertEquals(3, two.getTotalBoxes());
    }

    @Test
    public void testGetTotalBoxesSeveral() {
        Assert.assertEquals(11, order.getTotalBoxes());
    }

    @Test
    public void testRemoveVarietyReturnNoRemove() {
        Assert.assertEquals(0, order.removeVariety("Brownie"));

    }

    @Test
    public void testRemoveVarietyReturnSingle() {
        Assert.assertEquals(5, order.removeVariety("Shortbread"));
    }

    @Test
    public void testRemoveVarietyReturnSeveral() {
        Assert.assertEquals(4, order.removeVariety("Chocolate Chip"));
    }

    @Test
    public void testRemoveVarietyListNoRemove() {
        order.removeVariety("Brownie");
        Assert.assertEquals("[[Chocolate Chip, 1], [Shortbread, 5], [Macaroon, 2], [Chocolate Chip, 3]]", order.toString());
    }

    @Test
    public void testRemoveVarietyListSingle() {
        order.removeVariety("Shortbread");
        Assert.assertEquals("[[Chocolate Chip, 1], [Macaroon, 2], [Chocolate Chip, 3]]", order.toString());
    }

    @Test
    public void testRemoveVarietyListSeveral() {
        order.removeVariety("Chocolate Chip");
        Assert.assertEquals("[[Shortbread, 5], [Macaroon, 2]]", order.toString());
    }
}
