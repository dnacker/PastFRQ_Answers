package Q1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Q1.Scramble.scrambleOrRemove;
import static Q1.Scramble.scrambleWord;

/**
 * Created by david on 1/23/2017.
 */
public class TestScramble {

    //TODO break this up into smaller tests
    @Test
    public void testScrambleWord() {
        String[] testers = {"TAN", "ABRACADABRA", "WHOA", "AARDVARK", "EGGS", "A", "", "APPLE"};
        String[] scrambled = new String[testers.length];
        for (int i = 0; i < testers.length; i++) {
            scrambled[i] = scrambleWord(testers[i]);
        }
        Assert.assertEquals("[TNA, BARCADABARA, WHOA, ARADVRAK, EGGS, A, , PAPLE]", Arrays.toString(scrambled));
    }

    @Test
    public void testScrambleOrRemove() {
        String[] testers = {"TAN", "ABRACADABRA", "WHOA", "AARDVARK", "EGGS", "A", "", "APPLE"};
        List<String> testers2 = new ArrayList<String>();
        for (String s : testers) {
            testers2.add(s);
        }
        scrambleOrRemove(testers2);
        Assert.assertEquals("[TNA, BARCADABARA, ARADVRAK, PAPLE]", testers2.toString());
    }
}
