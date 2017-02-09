package Q4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by david on 1/23/2017.
 */
public class TestTrio {
    Sandwich sand1;
    Sandwich sand2;
    Salad salad1;
    Salad salad2;
    Drink drink1;
    Drink drink2;

    @Before
    public void init() {
        sand1= new Sandwich("Cheeseburger", 2.75);
        salad1 = new Salad("Spinach Salad", 1.25);
        drink1 = new Drink("Orange Soda", 1.25);
        sand2= new Sandwich("Club Sandwich", 2.75);
        salad2 = new Salad("Coleslaw", 1.25);
        drink2 = new Drink("Cappuccino", 3.50);
    }

    @Test
    public void testTrioConstructor() {
        Trio trio = new Trio(sand1, salad1, drink1);
    }

    @Test
    public void testTrioName() {
        Trio trio1 = new Trio(sand1, salad1, drink1);
        Trio trio2 = new Trio(sand2, salad2, drink2);
        Assert.assertEquals("Cheeseburger/Spinach Salad/Orange Soda Trio", trio1.getName());
        Assert.assertEquals("Club Sandwich/Coleslaw/Cappuccino Trio", trio2.getName());
    }

    @Test
    public void testTrioPrice() {
        Trio trio1 = new Trio(sand1, salad1, drink1);
        Trio trio2 = new Trio(sand2, salad2, drink2);
        Assert.assertEquals(4.00, trio1.getPrice(), 0.001);
        Assert.assertEquals(6.25, trio2.getPrice(), 0.001);
    }

}
