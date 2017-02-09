package Q3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daackerman on 1/23/2017.
 */
public class TestFuelDepot {
    private FuelDepot depot;
    private List<FuelTank> tanks;

    @Before
    public void init() {
        tanks = new ArrayList<FuelTank>();
        tanks.add(new Tank(20));
        tanks.add(new Tank(30));
        tanks.add(new Tank(80));
        tanks.add(new Tank(55));
        tanks.add(new Tank(50));
        tanks.add(new Tank(75));
        tanks.add(new Tank(20));
        FuelRobot filler = new Robot(2, true);
        depot = new FuelDepot(filler, tanks);
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
    public void testMoveRightForward() {
        FuelRobot filler = new Robot(2, true);
        FuelDepot depot1 = new FuelDepot(filler, tanks);
        depot1.moveToLocation(4);
        Assert.assertEquals(4, filler.getCurrentIndex());
    }

    @Test
    public void testMoveRightBackward() {
        FuelRobot filler = new Robot(2, false);
        FuelDepot depot1 = new FuelDepot(filler, tanks);
        depot1.moveToLocation(4);
        Assert.assertEquals(4, filler.getCurrentIndex());
    }

    @Test
    public void testMoveLeftBackward() {
        FuelRobot filler = new Robot(4, true);
        FuelDepot depot1 = new FuelDepot(filler, tanks);
        depot1.moveToLocation(2);
        Assert.assertEquals(2, filler.getCurrentIndex());
    }

    @Test
    public void testMoveLeftForward() {
        FuelRobot filler = new Robot(4, false);
        FuelDepot depot1 = new FuelDepot(filler, tanks);
        depot1.moveToLocation(2);
        Assert.assertEquals(2, filler.getCurrentIndex());
    }




}
