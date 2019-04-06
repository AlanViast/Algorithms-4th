package algorithms;

/**
 * 快速排序, 取数组第一个元素, 把小于该元素的其他元素放置到数组的左边, 大于该元素的放置到右边, 然后再递归子数组.
 *
 * 改进快读排序性能的两点:
 *  1. 对于子数组而言, 快速排序比插入排序慢
 *  2. 因为递归, 快速排序的sort方法在小数组中也会调用自己
 * @author AlanViast
 */
public class Quick extends SortAlgorithms {

    public static void main(String[] args) {
        Quick quick = new Quick();
        quick.run(Utils.randomArrays(100));
    }

    @Override
    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    private void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int index = partition(arr, lo, hi);
        sort(arr, lo, index - 1);
        sort(arr, index + 1, hi);
    }

    private int partition(Comparable[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable value = arr[lo];

        while (true) {
            while (less(arr[++i], value)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(value, arr[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }
}
