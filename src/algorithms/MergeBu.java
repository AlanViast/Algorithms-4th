package algorithms;

/**
 * @author AlanViast
 */
public class MergeBu extends SortAlgorithms {


    private Comparable[] buffer;

    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        buffer = new Comparable[length];

        for (int sz = 1; sz < length; sz += sz) {
            for (int lo = 0; lo < length - sz; lo += sz + sz) {
                merge(arr, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
    }

    private void merge(Comparable[] arr, int low, int mid, int hi) {
        int i = low, j = mid + 1;

        for (int k = low; k <= hi; k++) {
            buffer[k] = arr[k];
        }

        for (int k = low; k <= hi; k++) {
            if (i > mid) {
                arr[k] = buffer[j++];
            } else if (j > hi) {
                arr[k] = buffer[i++];
            } else if (less(buffer[j], buffer[i])) {
                arr[k] = buffer[j++];
            } else {
                arr[k] = buffer[i++];
            }
        }
    }

    public static void main(String[] args) {
        MergeBu mergeBu = new MergeBu();
        mergeBu.run(Utils.randomArrays(10000));
    }
}
