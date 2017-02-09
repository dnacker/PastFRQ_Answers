package Q3;

/**
 * Created by David on 1/21/2017.
 */
public class Student {
    private String name;
    private int absences;

    public Student(String name, int absences) {
        this.name = name;
        this.absences = absences;
    }

    /** Returns the name of this Student. */
    public String getName() {
        return name;
    }

    /** Returns the number of times this Student has missed class. */
    public int getAbsenceCount() {
        return absences;
    }

    public String toString() {
        return "[" + name + ", " + absences + "]";
    }
}
