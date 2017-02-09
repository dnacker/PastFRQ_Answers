package Q1;

import java.util.Random;

/**
 * This class represents a NumberCube.
 * Nothing to implement here.
 */
public class NumberCube {
    Random rand;

    public NumberCube(int seed) {
        rand = new Random(seed);
    }

    /** @return an integer value between 1 and 6, inclusive
     */
    public int toss() {
        return rand.nextInt(6) + 1;
    }
}
