package algorithms;

import java.util.Arrays;

public abstract class SortAlgorithms {

    private int exchCount = 0;
    private int comparaCount = 0;
    private long sortTime = 0L;


    public void run(Comparable[] arr) {
        long startTime = System.nanoTime();
        sort(arr);
        sortTime = (System.nanoTime() - startTime) / 1000;
        assert isSorted(arr);
        // show(arr);
        statistics();
    }

    public abstract void sort(Comparable[] arr);

    protected boolean less(Comparable v, Comparable w) {
        comparaCount++;
        return v.compareTo(w) < 0;
    }

    protected void exch(Comparable[] arr, int i, int y) {
        exchCount++;
        Comparable temp = arr[i];
        arr[i] = arr[y];
        arr[y] = temp;
/*
        System.out.println("--------------交换位置--------------");
        System.out.println(String.format("交换了 %d, %d的位置, 元素: %s, %s", i, y, arr[i], arr[y]));
        show(arr);
*/

    }

    protected void statistics() {
        System.out.println(String.format("------------------[%s]------------------", this.getClass().toString()));
        System.out.printf("执行时间: %s/ms, 交换次数: %d, 计算次数: %d", sortTime, exchCount, comparaCount);
        System.out.println();
    }

    protected void show(Comparable[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    protected boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
