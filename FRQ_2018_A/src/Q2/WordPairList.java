package Q2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Question 2.
 */
public class WordPairList {
    /** The list of word pairs, initialized by the constructor. */
    private ArrayList<WordPair> allPairs;

    /** Constructs a WordPairList object as described in part(a).
     *  Precondition: words.length >= 2
     */
    public WordPairList(String[] words) {
        allPairs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String first = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String second = words[j];
                allPairs.add(new WordPair(first, second));
            }
        }
    }

    /** Returns the number of matches as described in part (b).
     */
    public int numMatches() {
        int count = 0;
        for (WordPair wp: allPairs) {
            if (wp.getFirst().equals(wp.getSecond())) {
                count++;
            }
        }
        return count;
    }


    /** IGNORE THIS CODE (for testing purposes) */
    public ArrayList<WordPair> getList() {
        return allPairs;
    }
}
