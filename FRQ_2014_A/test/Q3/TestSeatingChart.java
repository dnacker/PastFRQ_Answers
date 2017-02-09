package Q3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daackerman on 1/24/2017.
 */
public class TestSeatingChart {
    private ArrayList<Student> students;
    private SeatingChart chart;

    @Before
    public void init() {
        students = new ArrayList<Student>();
        students.add(new Student("Karen", 3));
        students.add(new Student("Liz", 1));
        students.add(new Student("Paul", 4));
        students.add(new Student("Lester", 1));
        students.add(new Student("Henry", 5));
        students.add(new Student("Renee", 9));
        students.add(new Student("Glen", 2));
        students.add(new Student("Fran", 6));
        students.add(new Student("David", 1));
        students.add(new Student("Danny", 3));
    }

    @Test
    public void testSeatingChartConstructor() {
        chart = new SeatingChart(students, 3, 4);
        String chartPrintOut = "[[Karen, 3], [Lester, 1], [Glen, 2], [Danny, 3]]\n" +
                "[[Liz, 1], [Henry, 5], [Fran, 6], null]\n" +
                "[[Paul, 4], [Renee, 9], [David, 1], null]\n";
        Assert.assertEquals(chartPrintOut, chart.toString());
    }

    @Test
    public void testRemoveAbsentStudents() {
        chart = new SeatingChart(students, 3, 4);
        chart.removeAbsentStudents(4);
        String chartPrintOut = "[[Karen, 3], [Lester, 1], [Glen, 2], [Danny, 3]]\n" +
                "[[Liz, 1], null, null, null]\n" +
                "[[Paul, 4], null, [David, 1], null]\n";
        Assert.assertEquals(chartPrintOut, chart.toString());
    }
}
