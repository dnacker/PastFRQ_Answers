package Q1;

/**
 * Solutions to Question 1.
 */
public class NumberCubeRunner {
    /** Returns an array of the values obtained by tossing a number cube numTosses times.
     * @param cube a NumberCube
     * @param numTosses the number of tosses to be recorded
     * Precondition: numTosses > 0
     * @return an array of numTosses values
     */
    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        int[] arr = new int[numTosses];
        for (int i = 0; i < numTosses; i++) {
            arr[i] = cube.toss();
        }
        return arr;
    }

    /** Returns the starting index of a longest run of two or more consecutive repeated values
     * in the array values.
     * @param values an array of integer values representing a series of number cube tosses
     * Precondition: values.length > 0
     * @return the starting index of a run of maximum size;
     * -1 if there is no run
     */
    public static int getLongestRun(int[] values) {
        int indexOfLongest = -1;
        int longestRun = 0;
        int currentPosition = 0;
        while (currentPosition < values.length - 1) {
            if (values[currentPosition] == values[currentPosition + 1]) {
                int currentLongestRun = 2;
                int currentLongestIndex = currentPosition;
                currentPosition++;
                while (currentPosition < values.length - 1 && values[currentPosition] == values[currentPosition + 1]) {
                    currentLongestRun++;
                    currentPosition++;
                }
                if (currentLongestRun > longestRun) {
                    indexOfLongest = currentLongestIndex;
                }
            }
            currentPosition++;
        }
        return indexOfLongest;
    }

    /*
    public static void main(String[] args) {
        int[] testEmpty = {};
        int[] testNegative1 = {1, 3, 4, 6};
        int[] test1 = {1, 1, 3, 4, 6};
        int[] test2 = {1, 1, 3, 4, 4, 4, 6};
        int[] test3 = {1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5};
        System.out.println("actual: " + getLongestRun(testEmpty) + " expected: -1");
        System.out.println("actual: " + getLongestRun(testNegative1) + " expected: -1");
        System.out.println("actual: " + getLongestRun(test1) + " expected: 0");
        System.out.println("actual: " + getLongestRun(test2) + " expected: 3");
        System.out.println("actual: " + getLongestRun(test3) + " expected: 6");
        NumberCube cube = new NumberCube(42);
        System.out.println(Arrays.toString(getCubeTosses(cube, 5)));
        System.out.println(Arrays.toString(getCubeTosses(cube, 10)));
        System.out.println(Arrays.toString(getCubeTosses(cube, 30)));
    }
    */
}
