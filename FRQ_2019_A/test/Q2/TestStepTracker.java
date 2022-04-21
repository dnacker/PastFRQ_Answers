package Q2;

import org.junit.Assert;
import org.junit.Test;

public class TestStepTracker {
    @Test
    public void testInitialValuesReturnZero() {
        StepTracker stepTracker = new StepTracker(10000);
        Assert.assertEquals(0, stepTracker.activeDays());
        Assert.assertEquals(0.0, stepTracker.averageSteps(), 0.0);
    }

    @Test
    public void testAddStepsIsNotActive() {
        StepTracker stepTracker = new StepTracker(10000);
        stepTracker.addDailySteps(9000);
        Assert.assertEquals(0, stepTracker.activeDays());
    }

    @Test
    public void testAddStepsIsActive() {
        StepTracker stepTracker = new StepTracker(10000);
        stepTracker.addDailySteps(10001);
        Assert.assertEquals(1, stepTracker.activeDays());
    }

    @Test
    public void testAddStepsIsActiveExactly() {
        StepTracker stepTracker = new StepTracker(10000);
        stepTracker.addDailySteps(10000);
        Assert.assertEquals(1, stepTracker.activeDays());
    }

    @Test
    public void testAddStepsIsActiveMultipleDays() {
        int minSteps = 100;
        StepTracker stepTracker = new StepTracker(minSteps);
        for (int i = minSteps - 5; i < minSteps + 5; i++) {
            stepTracker.addDailySteps(i);
        }
        Assert.assertEquals(5, stepTracker.activeDays());
    }

    @Test
    public void testAddStepsAverageStepsOneDay() {
        StepTracker stepTracker = new StepTracker(100);
        stepTracker.addDailySteps(100);
        Assert.assertEquals(100.0, stepTracker.averageSteps(), 0.0);
    }

    @Test
    public void testAddStepsAverageStepsMultipleDays() {
        StepTracker stepTracker = new StepTracker(100);
        for (int i = 1 ; i <= 5; i++) {
            stepTracker.addDailySteps(i);
        }
        Assert.assertEquals(3.0, stepTracker.averageSteps(), 0.0);
    }
}
