package Q1;

import java.util.Arrays;

/**
 * Created by David on 1/22/2017.
 */
public class WordScrambler {
    private String[] scrambleWords;

    public WordScrambler(String[] wordArr) {
        scrambleWords = mixedWords(wordArr);
    }

    public static String recombine(String word1, String word2) {
        return word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);
    }


    /*
    private String[] mixedWords(String[] words) {
        String[] mixed = new String[words.length];
        int index = 0;
        for (int i = 0; i < words.length/2; i++) {
            mixed[index] = recombine(words[2*i], words[2*i + 1]);
            index++;
            mixed[index] = recombine(words[2*i + 1], words[2*i]);
            index++;
        }
        return mixed;
    }
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


    public String toString() {
        return Arrays.toString(scrambleWords);
    }

    /*
    public static void main(String[] args) {
        String[] words = {"apple", "pear", "this", "cat"};
        WordScrambler scrambler = new WordScrambler(words);
        System.out.println(scrambler);
    }
    */
}
