package algorithms;

import java.util.Arrays;

/**
 * @author AlanViast
 */
public class Quick3way extends SortAlgorithms {

    public static void main(String[] args) {
        Comparable[] arr = Utils.randomArrays(10000);
        arr = Utils.concat(arr, arr);

        Quick3way quick3way = new Quick3way();
        quick3way.run(arr.clone());
    }

    @Override
    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;

        Comparable midValue = arr[lo];

        while (i <= gt) {
            int cmp = arr[i].compareTo(midValue);
            if (cmp < 0) {
                exch(arr, lt++, i++);
            } else if (cmp > 0) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }
        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }
}
