import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main04 {
	public static void main(String[] args) {
		String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit.";
		String[] banned = {"hit"};

		System.out.println(solution(paragraph, banned));
	}

	public static String solution(String paragraph, String[] banned) {
		paragraph = paragraph.replaceAll("[^\\w\\s]", "").toLowerCase();
		String[] words = paragraph.split("\\s+");

		HashMap<String, Integer> countTable = new HashMap<>();
		List<String> bannedWords = List.of(banned);
		for(String word : words) {
			if (!bannedWords.contains(word)) {
				countTable.put(word, countTable.getOrDefault(word, 0) + 1);
			}
		}
		return Collections.max(countTable.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
