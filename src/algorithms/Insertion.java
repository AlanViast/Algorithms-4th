package algorithms;

/**
 * 插入排序: 每次取得一个元素, 并和左边已经有序的所有元素比较, 将其放在对应的位置上, 后面的元素向右移动
 *
 * 适用于集中典型的部分有序的数组
 *      1. 数组中的每个元素距离它的最终位置都不远
 *      2. 一个有序的大数组接一个小数组
 *      3. 数组中只有几个元素的位置不正确
 *
 */
public class Insertion extends SortAlgorithms {

    @Override
    public void sort(Comparable[] arr) {

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        Integer[] arr = new Integer[]{7, 2, 9, 11, 24, 53, 12, 5};
        insertion.run(arr);
    }
}
