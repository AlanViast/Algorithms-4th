package algorithms;

/**
 * 归并排序: 将数组切割成各个小的数组存放在一个新的数组里面, 将其排序后在放回源数组.
 *
 * @author AlanViast
 */
public class Merge extends SortAlgorithms {

    private Comparable[] buffer;

    @Override
    public void sort(Comparable[] arr) {
        buffer = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, int low, int hi) {
        if (hi <= low) {
            return;
        }

        int mid = low + (hi - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, hi);
        merge(arr, low, mid, hi);
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
        Merge merge = new Merge();
        merge.run(Utils.randomArrays(10000));
    }
}
