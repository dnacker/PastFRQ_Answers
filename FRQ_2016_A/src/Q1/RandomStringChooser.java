package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write this class.
 */
public class RandomStringChooser {
    private List<String> wordList;

    public RandomStringChooser(String[] list) {
        wordList = new ArrayList<String>();
        for (String s : list) {
            wordList.add(s);
        }
    }

    public String getNext() {
        if(wordList.isEmpty()) {
            return "NONE";
        } else {
            return wordList.remove((int)(Math.random() * wordList.size()));
        }
    }
}
