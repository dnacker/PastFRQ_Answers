package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by David on 1/21/2017.
 */
public class Scramble {
    /** Scrambles a given word.
     * @param word the word to be scrambled
     * @return the scrambled word (possibly equal to word)
     * Precondition: word is either an empty string or contains only uppercase letters.
     * Postcondition: the string returned was created from word as follows:
     * - the word was scrambled, beginning at the first letter and continuing from left to right
     * - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     * - letters were swapped at most once
     */
    public static String scrambleWord(String word) {
        if (word.isEmpty()) {
            return "";
        }
        String result = "";
        int count = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            String currentLetter = word.substring(i, i + 1);
            String nextLetter = word.substring(i + 1, i + 2);
            if (currentLetter.equals("A") && !nextLetter.equals("A")) {
                result += nextLetter + "A";
                i++;
                count++;
                count++;
            } else {
                result += currentLetter;
                count++;
            }
        }
        if (count < word.length()) {
            result += word.substring(word.length() - 1);
        }
        return result;
    }

    /** Modifies wordList by replacing each word with its scrambled
     * version, removing any words that are unchanged as a result of scrambling.
     * @param wordList the list of words
     * Precondition: wordList contains only non-null objects
     * Postcondition:
     * - all words unchanged by scrambling have been removed from wordList
     * - each of the remaining words has been replaced by its scrambled version
     * - the relative ordering of the entries in wordList is the same as it was
     * before the method was called
     */
    public static void scrambleOrRemove(List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            String scramble = scrambleWord(word);
            if (word.equals(scramble)) {
                wordList.remove(i);
                i--;
            } else {
                wordList.set(i, scramble);
            }
        }
    }

    public static void main(String[] args) {
        String[] testers = {"TAN", "ABRACADABRA", "WHOA", "AARDVARK", "EGGS", "A", "", "APPLE"};
        String[] scrambled = new String[testers.length];
        for (int i = 0; i < testers.length; i++) {
            scrambled[i] = scrambleWord(testers[i]);
        }

        System.out.println(Arrays.toString(scrambled));
        List<String> testers2 = new ArrayList<String>();
        for (String s : testers) {
            testers2.add(s);
        }

        scrambleOrRemove(testers2);
        System.out.println(testers2);
    }
}
