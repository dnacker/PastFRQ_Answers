package Q4;

import org.junit.Assert;
import org.junit.Test;

public class TestLightBoard {

    @Test
    public void testConstructorInitializes2DArray() {
        LightBoard lightBoard = new LightBoard(4, 5);
        boolean[][] lights = lightBoard.getLights();
        Assert.assertEquals(4, lights.length);
        // Check columns
        for (int i = 0; i < lights.length; i++) {
            Assert.assertEquals(5, lights[i].length);
        }
    }

    @Test
    public void testConstructorAreRandom() {
        LightBoard boardOne = new LightBoard(2, 3);
        LightBoard boardTwo = new LightBoard(2, 3);
        Assert.assertNotEquals(lightsToString(boardOne), lightsToString(boardTwo));
    }

    @Test
    public void testConstructor40PercentOn() {
        int rowCount = 1000;
        int colCount = 1000;
        LightBoard bigBoard = new LightBoard(rowCount, colCount);
        int totalOn = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (bigBoard.getLights()[i][j]) {
                    totalOn++;
                }
            }
        }
        double percentOn = (double) totalOn / (rowCount * colCount);

        Assert.assertEquals(0.4, percentOn, 0.01);
    }

    @Test
    public void testEvaluateLight() {
        LightBoard lightBoard = new LightBoard(1, 1);
        boolean[][] lights = new boolean[][] {
                {true, true, false, true, true},
                {true, false, false, true, false},
                {true, false, false, true, true},
                {true, false, false, false, true},
                {true, false, false, false, true},
                {true, true, false, true, true},
                {false, false, false, false, false}};
        lightBoard.setLights(lights);

        checkLight(lightBoard, 0, 3, false);
        checkLight(lightBoard, 4, 1, false);
        checkLight(lightBoard, 6, 0, true);
        checkLight(lightBoard, 5, 4, true);
    }

    private static void checkLight(LightBoard lightBoard, int row, int col, boolean result) {
        String message = String.format("Checking [%d][%d]", row, col) + "\n" + lightsToString(lightBoard) + "\nlight is on ? " + lightBoard.getLights()[row][col] + "\ncol: \n" + printCol(lightBoard, col);
        Assert.assertEquals(message, result, lightBoard.evaluateLight(row, col));
    }


    private static String lightsToString(LightBoard lightBoard) {
        boolean[][] lights = lightBoard.getLights();
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < lights[0].length; i++) {
            sb.append(" " + i + " ");
        }
        sb.append("\n");

        for (int i = 0; i < lights.length; i++) {
            boolean[] row = lights[i];
            sb.append(i + " ");
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j] ? "[1]" : "[0]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String printCol(LightBoard lightBoard, int colNumber) {
        boolean[][] lights = lightBoard.getLights();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lights.length; i++) {
            boolean[] row = lights[i];
            sb.append(row[colNumber] ? "[1]" : "[0]");
            sb.append("\n");
        }
        return sb.toString();
    }
}
