package Q4;

/**
 * Created by David on 1/21/2017.
 */
public class SkyView {
    /** A rectangular array that holds the data representing a rectangular area of the sky. */
    private double[][] view;

    /** Constructs a SkyView object from a 1-dimensional array of scan data.
     * @param numRows the number of rows represented in the view
     * Precondition: numRows > 0
     * @param numCols the number of columns represented in the view
     * Precondition: numCols > 0
     * @param scanned the scan data received from the telescope, stored in telescope order
     * Precondition: scanned.length == numRows * numCols
     * Postcondition: view has been created as a rectangular 2-dimensional array
     * with numRows rows and numCols columns and the values in
     * scanned have been copied to view and are ordered as
     * in the original rectangular area of sky.
     */
    public SkyView(int numRows, int numCols, double[] scanned) {
        view = new double[numRows][numCols];
        int index = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (row % 2 == 0) {
                    view[row][col] = scanned[index];
                } else {
                    view[row][numCols - 1 - col] = scanned[index];
                }
                index++;
            }
        }
    }

    /** Returns the average of the values in a rectangular section of view.
     * @param startRow the first row index of the section
     * @param endRow the last row index of the section
     * @param startCol the first column index of the section
     * @param endCol the last column index of the section
     * Precondition: 0 <= startRow <= endRow < view.length
     * Precondition: 0 <= startCol <= endCol < view[0].length
     * @return the average of the values in the specified section of view
     */
    public double getAverage(int startRow, int endRow,
                             int startCol, int endCol) {
        double sum = 0;
        int count = 0;
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                sum += view[row][col];
                count++;
            }
        }
        return sum / count;
    }

    /** IGNORE CODE BELOW (for testing purposes) */
    public String toString() {
        String res = "";
        for (double[] rowArray: view) {
            for (double data : rowArray) {
                res += data + " ";
            }
            res += "\n";
        }
        return res;
    }

    /*
    public static void main(String[] args) {
        double[] first = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9};
        double[] second = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1};

        SkyView one = new SkyView(4, 3, first);
        SkyView two = new SkyView(3, 2, second);
        System.out.println(one);
        System.out.println(two);

        System.out.println(one.getAverage(1, 2, 0, 1));
    }
    */
}
