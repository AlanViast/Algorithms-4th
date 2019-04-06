package algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Utils {

    private Utils() {
    }

    public static Comparable<Integer>[] randomArrays(int length) {
        Random random = new Random();
        return IntStream.range(0, length).map(i -> random.nextInt(length * length)).boxed().toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomArrays(20)));
    }

    /**
     * 合并两个数组到一个新的数组
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 合并后的数组
     */
    public static Comparable[] concat(Comparable[] arr1, Comparable[] arr2) {
        Comparable[] comparables = new Comparable[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, comparables, 0, arr1.length);
        System.arraycopy(arr2, 0, comparables, arr1.length, arr2.length);
        return comparables;
    }
}
