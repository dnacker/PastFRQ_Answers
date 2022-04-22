package Q4;

public class ScoreInfo {
    private int score;
    private int numStudents;

    public ScoreInfo(int aScore) {
        score = aScore;
        numStudents = 1;
    }

    /** adds 1 to the number of students who earned this score
     */
    public void increment() {
        numStudents++;
    }

    /** @return this score
     */
    public int getScore() {
        return score;
    }

    /** @return the number of students who earned this score
     */
    public int getFrequency() {
        return numStudents;
    }

    // Ignore this method. Used for testing.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ScoreInfo)) {
            return false;
        }
        ScoreInfo scoreInfo = (ScoreInfo) obj;
        return score == scoreInfo.score &&
                numStudents == scoreInfo.numStudents;
    }

    @Override
    public String toString() {
        return String.format("[score=%d, numStudents=%d]", score, numStudents);
    }
}
