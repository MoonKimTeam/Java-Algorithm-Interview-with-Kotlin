import java.time.Instant;

public class Main02 {
	public static void main(String[] args) {
		char[] str1 = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
		char[] str2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		Instant start = Instant.now();
		solution(str1);
		Instant end = Instant.now();
		long nanos = java.time.Duration.between(start, end).toNanos();
		System.out.println("Time: " + nanos + "ns");
		for (char c : str1) {
			System.out.print(c + " ");
		}

		System.out.println();

		start = Instant.now();
		solution(str2);
		end = Instant.now();
		nanos = java.time.Duration.between(start, end).toNanos();
		System.out.println("Time: " + nanos + "ns");
		for (char c : str2) {
			System.out.print(c + " ");
		}
	}

	public static char[] solution(char[] string) {
		for (int i = 0; i < string.length / 2; i++) {
			char temp = string[i];
			string[i] = string[string.length - 1 - i];
			string[string.length - 1 - i] = temp;
		}
		return string;
	}
}
