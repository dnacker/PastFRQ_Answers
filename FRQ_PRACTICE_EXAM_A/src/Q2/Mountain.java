package Q2;

/**
 * Created by David on 1/22/2017.
 */
public class Mountain {
    public static boolean isIncreasing(int[] array, int stop) {
        for (int i = 0; i < stop; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(int[] array, int start) {
        for (int i = start; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int getPeakIndex(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isMountain(int[] array) {
        int peak = getPeakIndex(array);
        return peak != -1 && isIncreasing(array, peak) && isDecreasing(array, peak);
    }

    public static void main(String[] args) {
        System.out.println(getPeakIndex(new int[]{11, 22, 33, 22, 11}));
        System.out.println(getPeakIndex(new int[]{11, 22, 11, 22, 11}));
        System.out.println(getPeakIndex(new int[]{11, 22, 33, 55, 77}));
        System.out.println(getPeakIndex(new int[]{99, 33, 55, 77, 120}));
        System.out.println(getPeakIndex(new int[]{99, 33, 55, 77, 55}));
        System.out.println(getPeakIndex(new int[]{33, 22, 11}));

        System.out.println(isMountain(new int[]{1, 2, 3, 2, 1}));
        System.out.println(isMountain(new int[]{1, 2, 1, 2, 1}));
        System.out.println(isMountain(new int[]{1, 2, 3, 1, 5}));
        System.out.println(isMountain(new int[]{1, 4, 2, 1, 0}));
        System.out.println(isMountain(new int[]{9, 3, 5, 7, 5}));
        System.out.println(isMountain(new int[]{3, 2, 1}));

    }
}
