package Q2;

import java.util.Arrays;

/**
 * Created by David on 1/21/2017.
 */
public class TokenPass {
    private int[] board;
    private int currentPlayer;

    /** Creates the board array to be of size playerCount and fills it with
     * random integer values from 1 to 10, inclusive. Initializes currentPlayer to a
     * random integer value in the range between 0 and playerCount-1, inclusive.
     * @param playerCount the number of players
     */
    public TokenPass(int playerCount) {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            board[i] = (int)(Math.random() * 10) + 1;
        }
        currentPlayer = (int)(Math.random() * playerCount);
    }

    /** Distributes the tokens from the current player's position one at a time to each player in
     * the game. Distribution begins with the next position and continues until all the tokens
     * have been distributed. If there are still tokens to distribute when the player at the
     * highest position is reached, the next token will be distributed to the player at position 0.
     * Precondition: the current player has at least one token.
     * Postcondition: the current player has not changed.
     */
    public void distributeCurrentPlayerTokens() {
        int tokensToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;
        int index;
        if (currentPlayer == board.length - 1) {
            index = 0;
        } else {
            index = currentPlayer + 1;
        }
        for (int i = 0; i < tokensToDistribute; i++) {
            board[index]++;
            if (index == board.length - 1) {
                index = 0;
            } else {
                index++;
            }
        }
    }

    /** IGNORE CODE BELOW (for testing purposes) */
    public String toString() {
        return Arrays.toString(board);
    }

    public int[] getBoard() {
        return board;
    }
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public TokenPass(int[] board, int current) {
        this.board = board;
        currentPlayer = current;
    }

    /*
    public static void main(String[] args) {
        TokenPass game = new TokenPass(4);
        System.out.println(game);
        System.out.println(game.currentPlayer);
        game.distributeCurrentPlayerTokens();
        System.out.println(game);
    }
    */
}
