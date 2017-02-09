package Q3;

/**
 * Created by daackerman on 1/24/2017.
 */
public class Crossword {
    /** Each element is a Square with a color (black or white) and a number.
     *  puzzle[r][c] represents the square in row r and column c.
     *  There is at least one row in the puzzle.
     */
    private Square[][] puzzle;

    /** Constructs a crossword puzzle grid.
     *  Precondition: There is at least one row in blackSquares.
     *  Postcondition:
     *      - The crossword grid has the same dimensions as blackSquares.
     *      - The Square object at row r, column c in the crossword puzzle grid is black
     *      if and only if blackSquares[r][c] is true.
     *      - The Squares in the puzzle are labeled according to the crossword labeling rule.
     */
    public Crossword(boolean[][] blackSquares) {
        int numRows = blackSquares.length;
        int numCols = blackSquares[0].length;
        puzzle = new Square[numRows][numCols];
        int number = 1;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (toBeLabeled(row, col, blackSquares)) {
                    puzzle[row][col] = new Square(false, number);
                    number++;
                } else {
                    puzzle[row][col] = new Square(blackSquares[row][col], 0);
                }
            }
        }

    }

    /** Returns true if the square at row r, column c should be labeled with a positive number;
     *          false otherwise.
     *  The square at row r, column c is black if and only if blackSquares[r][c] is true.
     *  Precondition: r and c are valid indexes in blackSquares.
     */
    public static boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
        if (!blackSquares[r][c]) {
            if (r == 0 || c == 0) {
                return true;
            } else if (blackSquares[r - 1][c] || blackSquares[r][c - 1]) {
                return true;
            }
        }
        return false;
    }

    /** IGNORE CODE BELOW (for testing purposes) */
    public String toString() {
        String result = "";
        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[0].length; col++) {
                result += puzzle[row][col] + "\t";
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[][] test = {{true, false, false, true, true, true, false, false, false},
                {false, false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, true, true, true},
                {false, false, true, false, false, false, true, false, false},
                {true, true, true, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false, false},
                {false, false, false, true, true, true, false, false, true}};
        Crossword cw = new Crossword(test);
        System.out.println(cw);
    }
}
