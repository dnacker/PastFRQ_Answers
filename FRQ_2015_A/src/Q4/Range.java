package Q4;

/**
 * Write this class.
 */
public class Range implements NumberGroup{
    int lowerBound;
    int upperBound;

    public Range(int a, int b) {
        lowerBound = a;
        upperBound = b;
    }

    public boolean contains(int num) {
        return lowerBound <= num && num <= upperBound;
    }
}
