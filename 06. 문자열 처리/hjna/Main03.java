import java.util.ArrayList;
import java.util.List;

public class Main03 {
	public static void main(String[] args) {
		String[] input = {
			"id1 8 1 5 1",
			"id2 art can",
			"id3 3 6",
			"id4 own kit dig",
			"id5 art zero"
		};

		solution(input);

		for (String s : input) {
			System.out.println(s);
		}

	}

	public static void solution(String[] input) {

		List<String> letterLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();

		for (String log : input) {
			String[] tokens = log.split(" ", 2);
			if (isDigitLog(tokens[1])) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}
		letterLogs.sort((log1, log2) -> {
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			int cmp = split1[1].compareTo(split2[1]);
			if (cmp == 0) {
				return split1[0].compareTo(split2[0]);
			}
			return cmp;
		});

		int idx = 0;
		for (String log : letterLogs) {
			input[idx++] = log;
		}
		for (String log : digitLogs) {
			input[idx++] = log;
		}
	}

	public static boolean isDigitLog(String logBody) {
		String[] tokens = logBody.split(" ");
		for (String token : tokens) {
			try {
				Double.parseDouble(token);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
}
