package Q4;

/**
 * Created by david on 5/7/2017.
 */
public class Position {
    private int r;
    private int c;

    public Position(int row, int col) {
        r = row;
        c = col;
    }

    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position p = (Position)o;
            return r == p.r && c == p.c;
        }
        return false;
    }

    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}
