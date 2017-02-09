package Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by David on 1/21/2017.
 */
public class SeatingChart {
    /** seats[r][c] represents the Student in row r and column c in the classroom. */
    private Student[][] seats;

    /** Creates a seating chart with the given number of rows and columns from the students in
     * studentList. Empty seats in the seating chart are represented by null.
     * @param rows the number of rows of seats in the classroom
     * @param cols the number of columns of seats in the classroom
     * Precondition: rows > 0; cols > 0;
     * rows * cols >= studentList.size()
     * Postcondition:
     * - Students appear in the seating chart in the same order as they appear
     * in studentList, starting at seats[0][0].
     * - seats is filled column by column from studentList, followed by any
     * empty seats (represented by null).
     * - studentList is unchanged.
     */
    public SeatingChart(List<Student> studentList, int rows, int cols) {
        seats = new Student[rows][cols];
        int index = 0;
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (index < studentList.size()) {
                    seats[row][col] = studentList.get(index);
                    index++;
                }
            }
        }
    }

    /** Removes students who have more than a given number of absences from the
     * seating chart, replacing those entries in the seating chart with null
     * and returns the number of students removed.
     * @param allowedAbsences an integer >= 0
     * @return number of students removed from seats
     * Postcondition:
     * - All students with allowedAbsences or fewer are in their original positions in seat
     * - No student in seats has more than allowedAbsences absences.
     * - Entries without students contain null.
     */
    public int removeAbsentStudents(int allowedAbsences) {
        int count = 0;
        for(int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats.length; col++) {
                Student s = seats[row][col];
                if (s != null && s.getAbsenceCount() > allowedAbsences) {
                    seats[row][col] = null;
                    count++;
                }
            }
        }
        return count;
    }

    /** IGNORE CODE BELOW (for testing purposes) */
    public String toString() {
        String result = "";
        for (Student[] row : seats) {
            result += Arrays.toString(row) + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
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
        SeatingChart chart = new SeatingChart(students, 3, 4);
        System.out.println(chart);

        chart.removeAbsentStudents(4);
        System.out.println(chart);
    }
}
