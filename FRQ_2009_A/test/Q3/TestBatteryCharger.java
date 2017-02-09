package Q3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Run me when you're done with Question 3.
 */
public class TestBatteryCharger {
    private BatteryCharger charger = new BatteryCharger(new int[]{50, 60, 160, 60, 80, 100, 100, 120, 150, 150,
            150, 200, 40, 240, 220, 220, 200, 200, 180, 180, 140, 100, 80, 60});

    @Test
    public void testGetChargingCostFirst(){
        Assert.assertEquals(40, charger.getChargingCost(12, 1));
    }

    @Test
    public void testGetChargingCostSecond() {
        Assert.assertEquals(110, charger.getChargingCost(0, 2));
    }

    @Test
    public void testGetChargingCostThird() {
        Assert.assertEquals(550, charger.getChargingCost(22, 7));
    }

    @Test
    public void testGetChargingCostFourth() {
        Assert.assertEquals(3710, charger.getChargingCost(22, 30));
    }

    @Test
    public void testGetChargeStartTimeFirst() {
        Assert.assertEquals(12, charger.getChargeStartTime(1));
    }

    @Test
    public void testGetChargeStartTimeSecond() {
        Assert.assertEquals(22, charger.getChargeStartTime(7));
    }

    @Test
    public void testGetChargeStartTimeThird() {
        Assert.assertEquals(22, charger.getChargeStartTime(30));
    }

    @Test
    public void testGetChargeStartTimeFourth() {
        Assert.assertTrue(0 == charger.getChargeStartTime(2) || 23 == charger.getChargeStartTime(2));
    }
}
