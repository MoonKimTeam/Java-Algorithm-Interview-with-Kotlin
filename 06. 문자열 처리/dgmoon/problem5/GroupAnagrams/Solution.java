package problem5.GroupAnagrams;

import java.util.*;


/**
 * O(n * k log k + n log n + n log n) = O(n * k log k + n log n)
 * 문자열 정렬 및 키 생성, 각 그룹 정렬, 그룹 전체 정렬
 */
class Solution {
    private static final String[] INPUT = {"eat", "tea", "tan", "ate", "ant", "cat"};

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new TreeMap<>();
        for (String string : strs) {
            String sortedString = Arrays.stream(string.split(""))
                    .sorted()
                    .reduce("", (a, b) -> a + b);

            List<String> strings = map.getOrDefault(sortedString, new ArrayList<>());
            strings.add(string);
            Collections.sort(strings);
            map.put(sortedString, strings);
        }

        return map.values().stream()
                .sorted((o1, o2) -> o2.size() - o1.size())
                .toList();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();
        System.out.println("solution = " + solution.groupAnagrams(INPUT));

        System.out.println("실행 시간: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}