package Q3;

/**
 * Answers to Question 3.
 */
public class Phrase {
    private String currentPhrase;

    public Phrase(String p) {
        currentPhrase = p;
    }

    public int findNthOccurrence(String str, int n) {
        int count = 1;
        int idx = currentPhrase.indexOf(str);
        while (count < n && 0 <= idx && idx < currentPhrase.length()) {
            count++;
            idx = currentPhrase.indexOf(str, idx + 1);
        }
        return idx;
    }

    public void replaceNthOccurrence(String str, int n, String repl) {
        int indx = findNthOccurrence(str, n);
		if (indx != -1) {
			currentPhrase = currentPhrase.substring(0, indx) + repl + currentPhrase.substring(indx + str.length());
		}
    }

    public int findLastOccurrence(String str) {
        int occur = 1;
        int index = findNthOccurrence(str, occur);
        int current = index;
        while (current != -1) {
            occur++;
            current = findNthOccurrence(str, occur);
            if (current != -1) {
                index = current;
            }
        }
        return index;
    }

    public String toString() {
        return currentPhrase;
    }
}
