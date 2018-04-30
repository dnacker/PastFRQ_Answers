package Q1;

import java.util.ArrayList;

/**
 * Answers to Question 1.
 */
public class Digits {
    private ArrayList<Integer> digitList;

    public Digits(int num) {
        digitList = new ArrayList<Integer>();
        if (num == 0) {
            digitList.add(0);
        } else {
            while (num > 0) {
                digitList.add(0, num % 10);
                num /= 10;
            }
        }
    }

    public boolean isStrictlyIncreasing() {
        for (int i = 0; i < digitList.size() - 1; i++) {
            if (digitList.get(i) >= digitList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String res = "";
        for (int num : digitList) {
            res += num;
        }
        return res;
    }
}
