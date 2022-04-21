package Q4;

public class LightBoard
{
    /** The lights on the board, where true represents on and false represents off.
     */
    private boolean[][] lights;

    /** Constructs a LightBoard object having numRows rows and numCols columns.
     * Precondition: numRows > 0, numCols > 0
     * Postcondition: each light has a 40% probability of being set to on.
     */
    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][];
        for (int i = 0; i < numRows; i++) {
            lights[i] = new boolean[numCols];
            for (int j = 0; j < numCols; j++) {
                lights[i][j] = Math.random() < 0.4;
            }
        }
    }

    /** Evaluates a light in row index row and column index col and returns a status
     * as described in part (b).
     * Precondition: row and col are valid indexes in lights.
     */
    public boolean evaluateLight(int row, int col) {
        int onLightsInColumn = 0;
        for (int i = 0; i < lights.length; i++) {
            if (lights[i][col]) {
                onLightsInColumn++;
            }
        }

        boolean lightStatus = lights[row][col];
        if (lightStatus) {
            if (onLightsInColumn % 2 == 0) {
                return false;
            }
        } else {
            if (onLightsInColumn % 3 == 0) {
                return true;
            }
        }

        return lightStatus;
    }

    // There may be additional instance variables, constructors, and methods not shown.

    // Ignore below. Needed for testing.
    public boolean[][] getLights() {
        return lights;
    }

    public void setLights(boolean[][] lights) {
        this.lights = lights;
    }
}