package problem2.ReverseString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * O(n)
 */
public class Solution {
    private static final String[] INPUT = new String[]{"h", "e", "l", "l", "o"};

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> collect = Arrays.stream(INPUT).collect(Collectors.toList());
        Collections.reverse(collect);
        String[] array = collect.toArray(new String[0]);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("실행 시간: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
