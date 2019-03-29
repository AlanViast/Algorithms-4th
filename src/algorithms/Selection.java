package algorithms;

public class Selection extends SortAlgorithms {

    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Selection selection = new Selection();
        Integer[] arr = new Integer[]{7, 2, 9, 11, 24, 53, 12, 5};
        selection.run(arr);
    }
}
