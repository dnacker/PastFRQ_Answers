package Q4;

/**
 * Answers to Question 4.
 */
public class Successors {
    public static Position findPosition(int num, int[][] intArr) {
        for (int row = 0; row < intArr.length; row++) {
            for (int col = 0; col < intArr[0].length; col++) {
                if (num == intArr[row][col]) {
                    return new Position(row, col);
                }
            }
        }
        return null;
    }

    public static Position[][] getSuccessorArray(int[][] intArr) {
        Position[][] ans = new Position[intArr.length][intArr[0].length];
        for (int row = 0; row < intArr.length; row++) {
            for (int col = 0; col < intArr[0].length; col++) {
                ans[row][col] = findPosition(intArr[row][col] + 1, intArr);
            }
        }
        return ans;
    }

    public static void print(Position[][] pArr) {
        for (Position[] row: pArr) {
            for (Position p: row) {
                System.out.print(p);
            }
            System.out.println();
        }
    }
}
