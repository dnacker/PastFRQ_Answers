package Q1;

public class WordScrambler {
    private String[] scrambledWords;

    /** @param wordArr an array of String objects
     * Precondition: wordArr.length is even
     */
    public WordScrambler(String[] wordArr) {
        scrambledWords = mixedWords(wordArr);
    }

    /** @param word1 a String of characters
     *	 @param word2 a String of characters
     *	 @return a String that contains the first half of word1 and the second half of word2
     */
    public static String recombine(String word1, String word2) {
        return word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);
    }

    /** @param words an array of String objects
     * Precondition: words.length is even
     *	 @return an array of String objects created by recombining pairs of strings in array words
     *	 Postcondition: the length of the returned array is words.length
     */
    private String[] mixedWords(String[] words) {
        String[] newWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 0) {
                newWords[i] = recombine(words[i], words[i + 1]);
            } else {
                newWords[i] = recombine(words[i], words[i - 1]);
            }
        }
        return newWords;
    }

    // Ignore these methods. Used for testing.
    public String[] getScrambledWords() {
        return scrambledWords;
    }
}
