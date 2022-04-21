package Q4;

/**
 * This class represents a NumberTile.
 * Nothing to implement here.
 */
import java.util.*;

public class NumberTile {
    private int[] numbers;

    public NumberTile(int[] nums) {
        numbers = nums;
    }

    public void rotate() {
        int last = numbers[numbers.length - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            numbers[i] = numbers[i - 1];
        }
        numbers[0] = last;
    }

    public int getLeft() {
        return numbers[3];
    }

    public int getRight() {
        return numbers[1];
    }

    public String toString() {
        return Arrays.toString(numbers);
    }
}
