package Q3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for question 3.
 */
public class TestFuelDepot {
    private FuelDepot depot;
    private FuelDepot depot2;
    private List<FuelTank> tanks1;
    private List<FuelTank> tanks2;

    @Before
    public void init() {
        tanks1 = new ArrayList<FuelTank>();
        tanks2 = new ArrayList<FuelTank>();
        tanks1.add(new Tank(20));
        tanks1.add(new Tank(30));
        tanks1.add(new Tank(80));
        tanks1.add(new Tank(55));
        tanks1.add(new Tank(50));
        tanks1.add(new Tank(75));
        tanks1.add(new Tank(20));
        FuelRobot filler = new Robot(2, true);
        depot = new FuelDepot(filler, tanks1);

        tanks2.add(new Tank(30));
        tanks2.add(new Tank(20));
        tanks2.add(new Tank(40));
        depot2 = new FuelDepot(filler, tanks2);
    }

    @Test
    public void testNextTankToFillOver() {
        Assert.assertTrue(0 == depot.nextTankToFill(50) || 6 == depot.nextTankToFill(50));
    }

    @Test
    public void testNoTankToFill() {
        Assert.assertEquals(2, depot.nextTankToFill(15));
    }

    @Test
    public void testNextTankToFillNotLast() {
        Assert.assertEquals(1, depot2.nextTankToFill(50));
    }

    @Test
    public void testMoveRightForward() {
        FuelRobot filler = new Robot(2, true);
        FuelDepot depot1 = new FuelDepot(filler, tanks1);
        depot1.moveToLocation(4);
        Assert.assertEquals(4, filler.getCurrentIndex());
    }

    @Test
    public void testMoveRightBackward() {
        FuelRobot filler = new Robot(2, false);
        FuelDepot depot1 = new FuelDepot(filler, tanks1);
        depot1.moveToLocation(4);
        Assert.assertEquals(4, filler.getCurrentIndex());
    }

    @Test
    public void testMoveLeftBackward() {
        FuelRobot filler = new Robot(4, true);
        FuelDepot depot1 = new FuelDepot(filler, tanks1);
        depot1.moveToLocation(2);
        Assert.assertEquals(2, filler.getCurrentIndex());
    }

    @Test
    public void testMoveLeftForward() {
        FuelRobot filler = new Robot(4, false);
        FuelDepot depot1 = new FuelDepot(filler, tanks1);
        depot1.moveToLocation(2);
        Assert.assertEquals(2, filler.getCurrentIndex());
    }
}
