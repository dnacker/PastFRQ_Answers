package Q4;

/**
 * Created by David on 1/21/2017.
 */
public class GrayImage {
    public static final int BLACK = 0;
    public static final int WHITE = 255;

    /** The 2-dimensional representation of this image. Guaranteed not to be null.
     * All values in the array are within the range [BLACK, WHITE], inclusive.
     */
    private int[][] pixelValues;

    /** @return the total number of white pixels in this image.
     * Postcondition: this image has not been changed.
     */
    public int countWhitePixels() {
        int count = 0;
        for (int[] rowArray: pixelValues) {
            for (int val: rowArray) {
                if (val == WHITE) {
                    count++;
                }
            }
        }
        return count;
    }

    /** Processes this image in row-major order and decreases the value of each pixel at
     * position (row, col) by the value of the pixel at position (row + 2, col + 2) if it exists.
     * Resulting values that would be less than BLACK are replaced by BLACK.
     * Pixels for which there is no pixel at position (row + 2, col + 2) are unchanged.
     */
    public void processImage() {
        for (int row = 0; row < pixelValues.length - 2; row++) {
            for (int col = 0; col < pixelValues[0].length - 2; col++) {
                pixelValues[row][col] = Math.max(BLACK, pixelValues[row][col] - pixelValues[row + 2][col + 2]);
            }
        }
    }

    public GrayImage(int[][] pixels) {
        pixelValues = pixels;
    }

    public String toString() {
        String res = "";
        for (int row = 0; row < pixelValues.length; row++) {
            for (int col = 0; col < pixelValues[0].length; col++) {
                res += pixelValues[row][col] + "\t";
            }
            res += "\n";
        }
        return res;
    }
    /*
    public static void main(String[] args) {
        GrayImage first = new GrayImage(new int[][]{{255, 184, 178, 84, 129}, {84,255,255,130,84}, {78,255,0,0,78}, {84,130,255,130,84}});
        GrayImage second = new GrayImage(new int[][]{{221, 184, 178, 84, 135},{84, 255, 255, 130, 84},{78, 255, 0, 0, 78},{84, 130, 255, 130, 84}});

        System.out.println(first.countWhitePixels());
        System.out.println();
        System.out.println(second);
        System.out.println();
        second.processImage();
        System.out.println(second);
    }
    */
}
