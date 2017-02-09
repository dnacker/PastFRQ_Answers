package Q2;

/**
 * Write this class.
 */
public class HiddenWord {
    private String word;

    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String guess) {
        String hint = "";
        for (int i = 0; i < guess.length(); i++) {
            String currentLetter = guess.substring(i, i + 1);
            if (currentLetter.equals(word.substring(i, i + 1))) {
                hint += currentLetter;
            } else if (word.contains(currentLetter)){
                hint += "+";
            } else {
                hint += "*";
            }
        }
        return hint;
    }
}
