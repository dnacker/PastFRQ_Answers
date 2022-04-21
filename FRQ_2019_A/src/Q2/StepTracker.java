package Q2;

public class StepTracker {
    private int minimumActiveSteps;
    private int totalSteps;
    private int activeDays;
    private int totalDays;

    public StepTracker(int min) {
        this.minimumActiveSteps = min;
    }

    public void addDailySteps(int steps) {
        totalDays++;
        totalSteps += steps;
        if (steps >= minimumActiveSteps) {
            activeDays++;
        }
    }

    public int activeDays() {
        return activeDays;
    }

    public double averageSteps() {
        if (totalDays == 0) {
            return 0.0;
        }
        return (double) totalSteps / totalDays;
    }
}
