package algorithms;

/**
 * 选择排序: 循环整个数组, 再和它后面的所有元素比较, 找到最小的元素并交换它们的位置
 */
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
        selection.run(Utils.randomArrays(1000));
    }
}
