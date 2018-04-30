package Q3;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    /** The number of rows and columns in the sparse array. */
    private int numRows;
    private int numCols;

    /** The list of entries representing the non-zero elements of the sparse array. Entries are stored in the
     * list in no particular order. Each non-zero element is represented by exactly one entry in the list.
     */
    private List<SparseArrayEntry> entries;

    /** Constructs an empty SparseArray. */
    public SparseArray() {
        entries = new ArrayList<SparseArrayEntry>();
    }

    /** Returns the number of rows in the sparse array. */
    public int getNumRows() {
        return numRows;
    }

    /** Returns the number of columns in the sparse array. */
    public int getNumCols() {
        return numCols;
    }

    /** Returns the value of the element at row index row and column index col in the sparse array.
     * Precondition: 0  row < getNumRows()
     *               0  col < getNumCols()
     */
    public int getValueAt(int row, int col) {
        for (SparseArrayEntry entry : entries) {
            if (entry.getRow() == row && entry.getCol() == col) {
                return entry.getValue();
            }
        }
        return 0;
    }
    /** Removes the column col from the sparse array.
     * Precondition: 0  col < getNumCols()
     */
    public void removeColumn(int col) {
        for (int i = entries.size() - 1; i >= 0; i--) {
            SparseArrayEntry entry = entries.get(i);
            if (entry.getCol() >= col) {
                entries.remove(i);
                if (entry.getCol() > col) {
                    entries.add(new SparseArrayEntry(entry.getRow(), entry.getCol() - 1, entry.getValue()));
                }
            }
        }
        numCols--;
    }

    /** IGNORE CODE BELOW (for testing purposes) */
    //tests getValueAt method
    public String toString() {
        String result = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int value = getValueAt(i, j);
                if (value != 0) {
                    result += getValueAt(i, j);
                } else {
                    result += "0";
                }
                if (j != numCols - 1) {
                    result += "\t";
                }
            }
            result += "\n";
        }
        return result;
    }

    public SparseArray(List<SparseArrayEntry> list, int rows, int cols) {
        entries = list;
        numRows = rows;
        numCols = cols;
    }

    public boolean contains(SparseArrayEntry target) {
        for (SparseArrayEntry entry: entries) {
            if (target.equals(entry)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<SparseArrayEntry> list = new ArrayList<>();
        list.add(new SparseArrayEntry(1, 4, 4));
        list.add(new SparseArrayEntry(2, 0, 1));
        list.add(new SparseArrayEntry(3, 1, -9));
        list.add(new SparseArrayEntry(1, 1, 5));
        SparseArray myArray = new SparseArray(list, 6, 5);
        System.out.println(myArray);

        myArray.removeColumn(1);
        System.out.println(myArray);
    }
}
