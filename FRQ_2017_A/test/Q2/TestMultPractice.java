package Q2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Question 2.
 */
public class TestMultPractice {

    @Test
    public void testConstructor() {
        MultPractice practice = new MultPractice(1, 1);
    }

    @Test
    public void testImplementsInterface() {
        try {
            MultPractice practice = new MultPractice(1, 1);
            StudyPractice sp = (StudyPractice)practice;
        } catch (ClassCastException e) {
            Assert.fail();
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testGetProblem() {
        MultPractice practice = new MultPractice(4, 8);
        Assert.assertEquals("4 TIMES 8", practice.getProblem());
    }

    @Test
    public void testNextProblem() {
        MultPractice practice = new MultPractice(4, 8);
        practice.nextProblem();
        Assert.assertEquals("4 TIMES 9", practice.getProblem());
    }

    @Test
    public void testSkipProblem() {
        MultPractice practice = new MultPractice(4, 8);
        practice.nextProblem();
        practice.nextProblem();
        Assert.assertEquals("4 TIMES 10", practice.getProblem());
    }

}
