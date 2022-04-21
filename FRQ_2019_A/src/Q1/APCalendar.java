package Q1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class APCalendar
{
    /** Returns true if year is a leap year and false otherwise. */
    public static boolean isLeapYear(int year) {
        /* implementation not shown */
        return new GregorianCalendar().isLeapYear(year);
    }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2) {
        int count = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                count++;
            }
        }
        return count;
    }

    /** Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    public static int firstDayOfYear(int year) {
        return new GregorianCalendar(year, Calendar.JANUARY, 1).get(Calendar.DAY_OF_WEEK) - 1;
    }

    /** Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfYear(int month, int day, int year) {
        return new GregorianCalendar(year, month - 1, day).get(Calendar.DAY_OF_YEAR);
    }

    /** Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     * and 6 denotes Saturday.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year) {
        int offset = firstDayOfYear(year);
        int dayOfYear = dayOfYear(month, day, year);
        return (dayOfYear - 1 + offset) % 7;
    }
    // There may be instance variables, constructors, and other methods not shown.
}