package Q4;

/**
 * IGNORE THIS CLASS (for testing purposes)
 */
public class SimpleGroup implements NumberGroup {
    private int[] numbers;

    public SimpleGroup(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                return true;
            }
        }
        return false;
    }
}
