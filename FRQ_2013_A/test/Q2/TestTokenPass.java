package Q2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by david on 1/23/2017.
 */
public class TestTokenPass {

    @Test
    public void testTokenPassConstructorPlayer() {
        TokenPass little = new TokenPass(10);
        Assert.assertTrue(0 <= little.getCurrentPlayer() && little.getCurrentPlayer() < 10);
    }

    @Test
    public void testTokenPassConstructorCount() {
        TokenPass big = new TokenPass(100);
        int[] board = big.getBoard();
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(1 <= board[i] && board[i] <= 10);
        }
    }

    @Test
    public void testDistributeCurrentlayerTokens() {
        TokenPass game = new TokenPass(new int[]{3, 2, 6, 10}, 2);
        game.distributeCurrentPlayerTokens();
        Assert.assertEquals("[5, 3, 1, 12]", game.toString());
    }
}
