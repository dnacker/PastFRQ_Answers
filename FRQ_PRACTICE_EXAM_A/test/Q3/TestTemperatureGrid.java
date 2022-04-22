package Q3;

import org.junit.Assert;
import org.junit.Test;

/* Tests for Question 3. */
public class TestTemperatureGrid {

    private TemperatureGrid grid = new TemperatureGrid(new double[][]{
            { 95.5,100.0,100.0,100.0,100.0,110.3 },
            { 0,50.0,50.0,50.0,50.0,0.0 },
            { 0,40.0,40,40.0,40.0,0.0 },
            { 0,20.0,20,20.0,20.0,0.0 },
            { 0,0.0,0.0,0.0,0.0,0.0 },
    });

    @Test
    public void testComputeTempBorder() {
        Assert.assertEquals(95.5, grid.computeTemp(0,0), 0);
        Assert.assertEquals(100.0, grid.computeTemp(0,1), 0);
        Assert.assertEquals(0.0, grid.computeTemp(4,5), 0);
        Assert.assertEquals(110.3, grid.computeTemp(0,5), 0);
    }

    @Test
    public void testComputeTempAverage() {
        Assert.assertEquals(190.0 / 4, grid.computeTemp(1,1), 0);
        Assert.assertEquals(150.0 / 4, grid.computeTemp(2,2), 0);
        Assert.assertEquals(80.0 / 4, grid.computeTemp(3, 3), 0);
    }

    @Test
    public void testUpdateAllTempsDoesNotChangeBorder() {
        grid.updateAllTemps(0.0);
        Assert.assertArrayEquals(new double[]{ 95.5,100.0,100.0,100.0,100.0,110.3 }, grid.getTemps()[0], 0.0);
        Assert.assertArrayEquals(new double[]{ 0,0.0,0.0,0.0,0.0,0.0 }, grid.getTemps()[4], 0.0);
        Assert.assertArrayEquals(new double[]{ 95.5, 0, 0, 0, 0}, getColumn(0), 0.0);
        Assert.assertArrayEquals(new double[]{ 110.3, 0, 0, 0, 0}, getColumn(5), 0.0);
    }

    @Test
    public void testUpdateAllTempsAverage() {
        grid.updateAllTemps(0.0);
        Assert.assertArrayEquals(new double[]{ 0.0, 47.5, 60.0, 60.0, 47.5, 0.0 }, grid.getTemps()[1], 0.0);
        Assert.assertArrayEquals(new double[]{ 0.0, 27.5, 37.5, 37.5, 27.5, 0.0 }, grid.getTemps()[2], 0.0);
        Assert.assertArrayEquals(new double[]{ 0.0, 15.0, 20.0, 20.0, 15.0, 0.0 }, grid.getTemps()[3], 0.0);
    }

    @Test
    public void testUpdateAllTempsOutsideTolerance() {
        Assert.assertFalse(grid.updateAllTemps(0.0));
    }

    @Test
    public void testUpdateAllTempsOutsideToleranceBarely() {
        Assert.assertFalse(grid.updateAllTemps(12.4));
    }

    @Test
    public void testUpdateAllTempsWithinTolerance() {
        Assert.assertTrue(grid.updateAllTemps(12.5));
    }

    private double[] getColumn(int colIdx) {
        double[] column = new double[grid.getTemps().length];
        for (int i = 0; i < column.length; i++) {
            column[i] = grid.getTemps()[i][colIdx];
        }
        return column;
    }
}
