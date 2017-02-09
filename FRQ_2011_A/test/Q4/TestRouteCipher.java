package Q4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by daackerman on 1/23/2017.
 */
public class TestRouteCipher {

    @Test
    public void testFillBlockNoA() {
        String word = "Surprise";
        RouteCipher cipher = new RouteCipher(2, 4);
        cipher.fillBlock(word);
        Assert.assertEquals("[[S, u, r, p], [r, i, s, e]]", cipher.toString());
    }

    @Test
    public void testFillBlockAs() {
        String word = "Meet at noon";
        RouteCipher cipher = new RouteCipher(3, 5);
        cipher.fillBlock(word);
        Assert.assertEquals("[[M, e, e, t,  ], [a, t,  , n, o], [o, n, A, A, A]]", cipher.toString());
    }

    @Test
    public void testFillBlockOver() {
        String word = "Meet at midnight";
        RouteCipher cipher = new RouteCipher(3, 5);
        cipher.fillBlock(word);
        Assert.assertEquals("[[M, e, e, t,  ], [a, t,  , m, i], [d, n, i, g, h]]", cipher.toString());
    }

    @Test
    public void testEncryptMessageSimple() {
        String word = "Surprise";
        RouteCipher cipher = new RouteCipher(2, 4);
        Assert.assertEquals("Sruirspe", cipher.encryptMessage(word));
    }

    @Test
    public void testEncryptMessageLong() {
        String word = "Meet at midnight";
        RouteCipher cipher = new RouteCipher(2, 3);
        Assert.assertEquals("Mte eati dmnitgAhA", cipher.encryptMessage(word));
    }

}
