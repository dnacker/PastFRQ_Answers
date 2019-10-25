package Q1;

/**
 * Question 1
 */
public class FrogSimulation {
    /** Distance, in inches from the starting position to the goal. */
    private int goalDistance;

    /** Maximum number of hops allowed to reach the goal. */
    private int maxHops;

    /** IGNORE THESE VARIABLES (FOR TESTING PURPOSES) */
    private int[] hops;
    private int step;

    /** Constructs a FrogSimulation where dist is the distance, in inches from the starting
     * position to the goal, and numHops is the maximum number of hops allowed to reach the goal.
     * Precondition: dist > 0; numHops > 0
     */
    public FrogSimulation(int dist, int numHops, int[] hops) {
        goalDistance = dist;
        maxHops = numHops;
        /** IGNORE THESE VARIABLES (FOR TESTING PURPOSES) */
        this.hops = hops;
        step = 0;
    }

    /** Returns an integer representing the distance, in inches, to be moved when the frog hops.
     */
    private int hopDistance() {
        return hops[step++];
    }

    /** Simulates a frog attempting to reach the goal as described in part (a).
     *  Returns true if the frog successfully reached or passed the goal during the simulation;
     *          false otherwise.
     */
    public boolean simulate() {
        int distance = 0;
        int hops = 0;
        while (0 <= distance && distance <= goalDistance && hops < maxHops) {
            distance += hopDistance();
            hops ++;
        }
        return goalDistance <= distance;
    }

    /** Runs num simulations and returns the proportion of simulations in which the frog
     *  successfully reached or passed the goal.
     *  Precondition: num > 0
     */
    public double runSimulations(int num) {
        int countSuccesses = 0;
        for (int i = 0; i < num; i++) {
            if (simulate()) {
                countSuccesses++;
            }
        }
        return (double)countSuccesses / num;
    }

}
