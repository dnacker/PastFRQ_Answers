package Q3;

/**
 *
 */
public class Square {
    /** Constructs one square of a crossword puzzle grid.
     *  Postcondition:
     *      - The square is black if and only if isBlack is true.
     *      - The square has number num.
     */
    public Square(boolean isBlack, int num) {
        this.isBlack = isBlack;
        this.num = num;
    }

    /** IGNORE CODE BELOW (for testing purposes) */
    private boolean isBlack;
    private int num;
    public String toString() {
        if (isBlack) {
            return "B";
        } else if (num != 0) {
            return num + "";
        } else {
            return " ";
        }
    }
}
