package Q3;

/**
 * Question 3.
 */
public class CodeWordChecker implements StringChecker {
    private int low;
    private int high;
    private String target;

    public CodeWordChecker(int l, int h, String t) {
        low = l;
        high = h;
        target = t;
    }

    public CodeWordChecker(String t) {
        this(6, 20, t);
    }

    public boolean isValid(String str) {
        return str.length() >= low &&
                str.length() <= high &&
                str.indexOf(target) == -1;
    }
}
