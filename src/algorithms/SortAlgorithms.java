package algorithms;

public abstract class SortAlgorithms {

    public void run(Comparable[] arr) {
        sort(arr);
        assert isSorted(arr);
        show(arr);
    }

    public abstract void sort(Comparable[] arr);

    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected void exch(Comparable[] arr, int i, int y) {
        Comparable temp = arr[i];
        arr[i] = arr[y];
        arr[y] = temp;

        System.out.println("--------------交换位置--------------");
        System.out.println(String.format("交换了 %d, %d的位置", i, y));
        show(arr);
    }

    protected void show(Comparable[] arr) {
        for (Comparable item : arr) {
            System.out.print(item + ",");
        }
        System.out.println();
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
