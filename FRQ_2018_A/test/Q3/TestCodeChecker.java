package Q3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Question 3.
 */
public class TestCodeChecker {

    @Test
    public void testConstructorThreeParams() {
        CodeWordChecker cwc = new CodeWordChecker(1, 2, "foo");
    }

    @Test
    public void testConstructorOneParam() {
        CodeWordChecker csc = new CodeWordChecker("foo");
    }

    @Test
    public void testImplementsInterface() {
        CodeWordChecker cwc = new CodeWordChecker(1, 2, "foo");
        Assert.assertTrue(cwc instanceof StringChecker);
    }

    @Test
    public void testNotValidThreeParamsLowBound() {
        CodeWordChecker sc = new CodeWordChecker(5, 8, "$");
        String test = "abcd";
        for (int i = 0; i < test.length(); i++) {
            Assert.assertFalse(sc.isValid(test.substring(0, i)));
        }
    }

    @Test
    public void testNotValidThreeParamsHighBound() {
        CodeWordChecker sc = new CodeWordChecker(1, 2, "$");
        String test = "abcdefg";
        for (int i = 3; i < test.length(); i++) {
            Assert.assertFalse(sc.isValid(test.substring(0, i)));
        }
    }

    @Test
    public void testValidThreeParams() {
        CodeWordChecker sc = new CodeWordChecker(3, 5, "$");
        String test = "abcdefg";
        for (int i = 3; i <= 5; i++) {
            Assert.assertTrue(sc.isValid(test.substring(0, i)));
        }
    }

    @Test
    public void testValidDefaultParamsLength() {
        CodeWordChecker sc = new CodeWordChecker("foo");
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alpha.length(); i++) {
            if (i < 6 || i > 20) {
                Assert.assertFalse(sc.isValid(alpha.substring(0, i)));
            } else {
                Assert.assertTrue(sc.isValid(alpha.substring(0, i)));
            }
        }
    }

    @Test
    public void testValidThreeParamsString() {
        CodeWordChecker sc = new CodeWordChecker(1, 10, "ab");
        Assert.assertFalse(sc.isValid("abc"));
        Assert.assertFalse(sc.isValid("cab"));
        Assert.assertTrue(sc.isValid("acb"));
        Assert.assertTrue(sc.isValid("AB"));
    }

    @Test
    public void testValidOneParamsString() {
        CodeWordChecker sc = new CodeWordChecker("pass");
        Assert.assertTrue(sc.isValid("MyPass"));
        Assert.assertFalse(sc.isValid("Mypassport"));
    }
}
