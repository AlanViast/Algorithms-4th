package algorithms;

/**
 * 希尔排序
 * <p>
 * h >= (arr.length / 3)
 * h 的值取决于数组的长度, 大概应该是最小的组元素切分的纬度
 * h的计算公式 h = 3 * h + 1
 * <p>
 * <pre>
 * while (h < length / 3) {
 *     h = 3 * h + 1;
 * }
 * </pre>
 * </p>
 * <p>
 * 对于大规模的乱序数组插入排序较慢, 因为它只会交换相邻的两个元素.
 * 希尔排序为了加快速度简单的改进了插入排序, 交换不相邻的元素以对数组的局部进行排序, 并最终用插入排序将局部的数组排序.
 * <p>
 * 10000个元素时, 验证记录 <br/>
 * ------------------[class algorithms.Selection]------------------<br/>
 * 执行时间: 183507/ms, 交换次数: 9999, 计算次数: 49995000<br/>
 * ------------------[class algorithms.Insertion]------------------<br/>
 * 执行时间: 189966/ms, 交换次数: 25161160, 计算次数: 25171155<br/>
 * ------------------[class algorithms.Shell]------------------<br/>
 * 执行时间: 10853/ms, 交换次数: 161291, 计算次数: 232195<br/>
 */
public class Shell extends SortAlgorithms {

    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        int h = 1;

        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    exch(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = Utils.randomArrays(1000);
        Selection selection = new Selection();
        selection.run(arr.clone());

        Insertion insertion = new Insertion();
        insertion.run(arr.clone());

        Shell shell = new Shell();
        shell.run(arr.clone());

        Merge merge = new Merge();
        merge.run(arr.clone());
    }


}
