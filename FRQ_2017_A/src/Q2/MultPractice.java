package Q2;

/**
 * Answers to Question 2.
 */
public class MultPractice implements StudyPractice {
    private int first;
    private int second;
    public MultPractice(int f, int s) {
        first = f;
        second = s;
    }

    public String getProblem() {
        return first + " TIMES " + second;
    }

    public void nextProblem() {
        second++;
    }
}
