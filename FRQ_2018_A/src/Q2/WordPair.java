package Q2;

/**
 * Question 2.
 */
public class WordPair {
    private String first;
    private String second;

    /** Constructs a WordPair object. */
    public WordPair(String f, String s) {
        first = f;
        second = s;
    }

    /** Returns the first string of this WordPair object. */
    public String getFirst() {
        return first;
    }

    /** Returns the second string of this WordPair object. */
    public String getSecond() {
        return second;
    }

    /** IGNORE THIS CODE (for testing purposes) */
    @Override
    public boolean equals(Object o) {
        if (o instanceof WordPair) {
            WordPair wp = (WordPair)o;
            return (wp.first.equals(first) && wp.second.equals(second)) ||
                    (wp.first.equals(second) && wp.second.equals(first));
        }
        return false;
    }
}
