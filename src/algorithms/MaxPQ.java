package algorithms;

import java.util.Arrays;

/**
 * 二叉堆数组排序, sink =  2 * k (k一开始等于1)
 *
 * @author AlanViast
 */
public class MaxPQ<Key extends Comparable> {


    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key value) {
        pq[++N] = value;
        swin(N);
    }

    private void swin(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
        System.out.println(Arrays.toString(pq));
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            System.out.println("------------------------");
            System.out.println(String.format("交换前: %s", Arrays.toString(pq)));
            System.out.println(String.format("交换位置: %s, %s", k, j));
            System.out.println(String.format("交换后: %s", Arrays.toString(pq)));
            exch(k, j);
            k = j;
        }
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        System.out.println("重排序后的数组:" + Arrays.toString(pq));
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }


    public static void main(String[] args) {
        Comparable[] arr = Utils.randomArrays(10);
        MaxPQ maxPQ = new MaxPQ(arr.length);
        System.out.println(Arrays.toString(arr));
        for (Comparable comparable : arr) {
            maxPQ.insert(comparable);
        }

        System.out.println(maxPQ.delMax());

    }

}
