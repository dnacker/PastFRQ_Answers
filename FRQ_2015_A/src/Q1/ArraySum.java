package Q1;

/**
 * Created by daackerman on 1/24/2017.
 */
public class ArraySum {
    /** Returns the sum of the entries in the one-dimensional array arr.
     */
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    /** Returns a one-dimensional array in which the entry at index k is the sum of
     * the entries of row k of the two-dimensional array arr2D.
     */
    public static int[] rowSums(int[][] arr2D) {
        int[] sums = new int[arr2D.length];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = arraySum(arr2D[i]);
        }
        return sums;
    }

    /** Returns true if all rows in arr2D have different row sums;
     * false otherwise.
     */
    public static boolean isDiverse(int[][] arr2D) {
        int[] sums = rowSums(arr2D);
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[i] == sums[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
