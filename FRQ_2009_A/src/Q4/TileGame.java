package Q4;

import java.util.ArrayList;

/**
 * Solutions to Question 4.
 */
public class TileGame {
    private ArrayList<NumberTile> board;

    public TileGame() {
        board = new ArrayList<NumberTile>();
    }

    public TileGame(ArrayList<NumberTile> b) {
        board = b;
    }

    public int getIndexForFit(NumberTile tile) {
        if (board.isEmpty() || (board.get(0).getLeft() == tile.getRight())) {
            return 0;
        }
        if (board.get(board.size() - 1).getRight() == tile.getLeft()) {
            return board.size();
        }
        for (int i = 0; i < board.size() - 1; i++) {
            NumberTile left = board.get(i);
            NumberTile right = board.get(i + 1);
            if (left.getRight() == tile.getLeft() && right.getLeft() == tile.getRight()) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean insertTile(NumberTile tile) {
        for (int i = 0; i < 4; i++) {
            int indexToAdd = getIndexForFit(tile);
            if (indexToAdd != -1) {
                board.add(indexToAdd, tile);
                return true;
            } else {
                tile.rotate();
            }
        }
        return false;
    }

    public String toString() {
        return board.toString();
    }
}
