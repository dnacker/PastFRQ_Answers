package Q3;

public class TemperatureGrid {
    /** A two-dimensional array of temperature values, initialized in the constructor (not shown)
     * Guaranteed not to be null
     */
    private double[][] temps;

    public TemperatureGrid(double[][] grid) {
        temps = grid;
    }

    /** Computes and returns a new temperature value for the given location.
     * @param row a valid row index in temps
     * @param col a valid column index in temps
     * @return the new temperature for temps[row][col]
     * - The new temperature for any element in the border of the array is the
     * same as the old temperature.
     * - Otherwise, the new temperature is the average of the four adjacent entries.
     * Postcondition: temps is unchanged.
     */
    public double computeTemp(int row, int col) {
        if (row > 0 && col > 0 && row < temps.length - 1 && col < temps[0].length - 1) {
            return (temps[row - 1][col] + temps[row + 1][col] + temps[row][col - 1] + temps[row][col + 1]) / 4;
        } else {
            return temps[row][col];
        }
    }

    /** Updates all values in temps and returns a boolean that indicates whether or not all the
     * new values were within tolerance of the original values.
     * @param tolerance a double value >= 0
     * @return true if all updated temperatures are within tolerance of the original values;
     * false otherwise.
     * Postcondition: Each value in temps has been updated with a new value based on the
     * corresponding call to computeTemp.
     */
    public boolean updateAllTemps(double tolerance) {
        double[][] newGrid = new double[temps.length][temps[0].length];
        boolean withinTolerance = true;
        for (int row = 0; row < temps.length; row++) {
            for (int col = 0; col < temps[0].length; col++) {
                double newTemp = computeTemp(row, col);
                if (Math.abs(newTemp - temps[row][col]) > tolerance) {
                    withinTolerance = false;
                }
                newGrid[row][col] = newTemp;
            }
        }
        temps = newGrid;
        return withinTolerance;
    }

    // Ignore these methods. Used for testing.
    public double[][] getTemps() {
        return temps;
    }
}
