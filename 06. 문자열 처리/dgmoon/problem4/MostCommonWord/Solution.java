package problem4.MostCommonWord;

import java.util.*;

/*
O(n) + O(n) + O(n) = O(n)
금지 단어 제거 + 단어 세기 + 최빈 단어
 */
public class Solution {
    private static final String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit";
    private static String[] banned = {"hit"};

    public static void main(String[] args) {
        String[] words = paragraph.replaceAll("[^A-z ]", "").toLowerCase().split(" ");

        List<String> words2 = new ArrayList<>(Arrays.asList(words));
        List<String> banned2 = new ArrayList<>(Arrays.asList(banned));

        words2.removeAll(banned2);


        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words2) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        String maxWord = "";
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxWord = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        System.out.println("maxWord = " + maxWord);
    }
}
