package Q4;

import java.util.ArrayList;

public class Stats {
    private ArrayList<ScoreInfo> scoreList = new ArrayList<>();
    // listed in increasing score order; no two ScoreInfo objects contain the same score

    /** Records a score in the database, keeping the database in increasing score order. If no other
     * 	ScoreInfo object represents score, a new ScoreInfo object representing score
     * 	is added to the database; otherwise, the frequency in the ScoreInfo object representing
     * 	score is incremented.
     * 	@param score a score to be recorded in the list
     * 	@return true if a new ScoreInfo object representing score was added to the list;
     * false otherwise
     */
    public boolean record(int score) {
        boolean exists = false;
        int positionToAdd = 0;
        for (int i = 0; i < scoreList.size(); i++) {
            ScoreInfo current = scoreList.get(i);
            if (current.getScore() == score) {
                current.increment();
                exists = true;
            }
            if (current.getScore() < score) {
                positionToAdd++;
            }
        }
        if (!exists) {
            scoreList.add(positionToAdd, new ScoreInfo(score));
        }
        return !exists;
    }

    /** Records all scores in stuScores in the database, keeping the database in increasing score order
     * 	@param stuScores an array of student test scores
     */
    public void recordScores(int[] stuScores) {
        for (int score: stuScores) {
            record(score);
        }
    }

    // Ignore these methods. Used for testing.
    public ArrayList<ScoreInfo> getScoreList() {
        return scoreList;
    }

    public String toString() {
        return scoreList.toString();
    }
}
