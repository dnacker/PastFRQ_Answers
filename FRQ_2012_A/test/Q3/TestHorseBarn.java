package Q3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by david on 1/23/2017.
 */
public class TestHorseBarn {

    @Test
    public void testFindHorseSpaceThere() {
        Horse a = new ActualHorse("Trigger", 1340);
        Horse b = new ActualHorse("Silver", 1210);
        Horse c = new ActualHorse("Lady", 1575);
        Horse d = new ActualHorse("Patches", 1350);
        Horse e = new ActualHorse("Duke", 1410);
        Horse[] horses = {a, null, b, c, null, d, e};
        HorseBarn horsies = new HorseBarn(horses);
        Assert.assertEquals(0, horsies.findHorseSpace("Trigger"));
    }

    @Test
    public void testFindHorseSpaceThere2() {
        Horse a = new ActualHorse("Trigger", 1340);
        Horse b = new ActualHorse("Silver", 1210);
        Horse c = new ActualHorse("Lady", 1575);
        Horse d = new ActualHorse("Patches", 1350);
        Horse e = new ActualHorse("Duke", 1410);
        Horse[] horses = {a, null, b, c, null, d, e};
        HorseBarn horsies = new HorseBarn(horses);
        Assert.assertEquals(6, horsies.findHorseSpace("Duke"));
    }

    @Test
    public void testFindHorseSpaceNotThere() {
        Horse a = new ActualHorse("Trigger", 1340);
        Horse b = new ActualHorse("Silver", 1210);
        Horse c = new ActualHorse("Lady", 1575);
        Horse d = new ActualHorse("Patches", 1350);
        Horse e = new ActualHorse("Duke", 1410);
        Horse[] horses = {a, null, b, c, null, d, e};
        HorseBarn horsies = new HorseBarn(horses);
        Assert.assertEquals(-1, horsies.findHorseSpace("Billy"));
    }

    @Test
    public void testConsolidate() {
        Horse a = new ActualHorse("Trigger", 1340);
        Horse b = new ActualHorse("Silver", 1210);
        Horse d = new ActualHorse("Patches", 1350);
        Horse e = new ActualHorse("Duke", 1410);
        Horse[] horses = {a, null, b, null, null, d, e};
        HorseBarn horsies = new HorseBarn(horses);
        horsies.consolidate();
        Assert.assertEquals("[[Trigger, 1340], [Silver, 1210], [Patches, 1350], [Duke, 1410], null, null, null]", horsies.toString());
    }
}
