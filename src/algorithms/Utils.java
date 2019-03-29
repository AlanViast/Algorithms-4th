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

}
