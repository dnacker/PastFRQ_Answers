package Q1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Question 1.
 */
public class TestFrogSimulation {

    @Test
    public void testOneHopTrue() {
        FrogSimulation sim = new FrogSimulation(5, 1, new int[]{6});
        Assert.assertTrue(sim.simulate());
    }

    @Test
    public void testOneHopFalse() {
        FrogSimulation sim = new FrogSimulation(5, 1, new int[]{4});
        Assert.assertFalse(sim.simulate());
    }

    @Test
    public void testTwoHopTrue() {
        FrogSimulation sim = new FrogSimulation(5, 2, new int[]{2,3});
        Assert.assertTrue(sim.simulate());
    }

    @Test
    public void testTwoHopFalse() {
        FrogSimulation sim = new FrogSimulation(5, 2, new int[]{2,2});
        Assert.assertFalse(sim.simulate());
    }

    @Test
    public void testStopIfNegative() {
        FrogSimulation sim = new FrogSimulation(5, 2, new int[]{-1, 7});
        Assert.assertFalse(sim.simulate());
    }

    @Test
    public void testStopIfOver() {
        FrogSimulation sim = new FrogSimulation(5, 2, new int[]{6, -7});
        Assert.assertTrue(sim.simulate());
    }

    @Test
    public void testAllExamples() {
        int[] e1 = {5, 7, -2, 8, 6};
        int[] e2 = {6, 7, 6, 6};
        int[] e3 = {6, -6, 31};
        int[] e4 = {4, 2, -8};
        int[] e5 = {5, 4, 2, 4, 3};

        FrogSimulation sim = new FrogSimulation(24, 5, e1);
        Assert.assertTrue(sim.simulate());
        sim = new FrogSimulation(24, 5, e2);
        Assert.assertTrue(sim.simulate());
        sim = new FrogSimulation(24, 5, e3);
        Assert.assertTrue(sim.simulate());
        sim = new FrogSimulation(24, 5, e4);
        Assert.assertFalse(sim.simulate());
        sim = new FrogSimulation(24, 5, e5);
        Assert.assertFalse(sim.simulate());
    }

    @Test
    public void testRunSimulations1() {
        int[] testArr = {1, 0, 0, 0};
        FrogSimulation sim = new FrogSimulation(1, 1, testArr);
        Assert.assertEquals(0.25, sim.runSimulations(4), 0.01);
    }

    @Test
    public void testRunSimulations2() {
        int[] testArr = {1, 1, 0, 0};
        FrogSimulation sim = new FrogSimulation(1, 1, testArr);
        Assert.assertEquals(0.50, sim.runSimulations(4), 0.01);
    }

    @Test
    public void testRunSimulations3() {
        int[] testArr = {1, 1, 1, 0};
        FrogSimulation sim = new FrogSimulation(1, 1, testArr);
        Assert.assertEquals(0.75, sim.runSimulations(4), 0.01);
    }

    @Test
    public void testRunSimulationsAll() {
        int[] testArr = {1, 1, 1, 1};
        FrogSimulation sim = new FrogSimulation(1, 1, testArr);
        Assert.assertEquals(1.0, sim.runSimulations(4), 0.01);
    }

    @Test
    public void testRunSimulationsNone() {
        int[] testArr = {0,0,0,0};
        FrogSimulation sim = new FrogSimulation(1, 1, testArr);
        Assert.assertEquals(0.0, sim.runSimulations(4), 0.01);
    }


}
