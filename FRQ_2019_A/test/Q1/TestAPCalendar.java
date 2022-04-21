package Q1;

import org.junit.Assert;
import org.junit.Test;

public class TestAPCalendar {
    @Test
    public void testCalendarMethods() {
        Assert.assertTrue(APCalendar.isLeapYear(2016));
        Assert.assertFalse(APCalendar.isLeapYear(2017));

        Assert.assertEquals(60, APCalendar.dayOfYear(3, 1, 2017));
        Assert.assertEquals(61, APCalendar.dayOfYear(3, 1, 2016));

        Assert.assertEquals(2, APCalendar.firstDayOfYear(2019));
    }

    @Test
    public void testNumberOfLeapYears_sameYear() {
        Assert.assertEquals(0, APCalendar.numberOfLeapYears(2017, 2017));
        Assert.assertEquals(1, APCalendar.numberOfLeapYears(2016, 2016));
    }

    @Test
    public void testNumberOfLeapYears_differentYears() {
        Assert.assertEquals(1, APCalendar.numberOfLeapYears(2016, 2019));
        Assert.assertEquals(2, APCalendar.numberOfLeapYears(2016, 2020));
        Assert.assertEquals(0, APCalendar.numberOfLeapYears(2017, 2019));
        Assert.assertEquals(1, APCalendar.numberOfLeapYears(2017, 2020));
        Assert.assertEquals(30, APCalendar.numberOfLeapYears(1900, 2020));
    }

    @Test
    public void testDayOfWeek() {
        Assert.assertEquals(6, APCalendar.dayOfWeek(1, 5, 2019));
        Assert.assertEquals(4, APCalendar.dayOfWeek(1, 10, 2019));

        Assert.assertEquals(2, APCalendar.dayOfWeek(3, 1, 2016));

        Assert.assertEquals(6, APCalendar.dayOfWeek(1, 1, 2022));
        Assert.assertEquals(0, APCalendar.dayOfWeek(1, 2, 2022));
        Assert.assertEquals(0, APCalendar.dayOfWeek(1, 9, 2022));
    }
}
