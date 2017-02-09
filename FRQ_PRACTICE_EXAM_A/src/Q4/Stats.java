package Q4;

import java.util.ArrayList;

/**
 * Created by David on 1/22/2017.
 */
public class Stats {
    private ArrayList<ScoreInfo> scoreList;

    public Stats() {
        scoreList = new ArrayList<ScoreInfo>();
    }

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

    public void recordScores(int[] stuScores) {
        for (int score: stuScores) {
            record(score);
        }
    }

    public String toString() {
        return scoreList.toString();
    }

    public static void main(String[] args) {
        int[] scores = new int[33];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            scores[index] = 5;
            index++;
        }
        for (int i = 0; i < 10; i++) {
            scores[index] = 4;
            index++;
        }
        for (int i = 0; i < 8; i++) {
            scores[index] = 6;
            index++;
        }
        for (int i = 0; i < 3; i++) {
            scores[index] = 2;
            index++;
        }
        for (int i = 0; i < 7; i++) {
            scores[index] = 1;
            index++;
        }

        Stats myStats = new Stats();
        myStats.recordScores(scores);
        System.out.println(myStats);
        myStats.record(3);
        System.out.println(myStats);

    }
}
