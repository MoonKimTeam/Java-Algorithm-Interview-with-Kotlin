public class Main01 {
	public static void main(String[] args) {
		String str1 = "Do geese see God?";
		String str2 = "race a car";
		String str3 = "여보 안경 안보여";
		validate(str1, solution(str1));
		validate(str2, solution(str2));
		validate(str3, solution(str3));

	}

	public static boolean solution(String s) {
		String cleanString = s.toLowerCase().replaceAll("[^a-z0-9]", "");

		int left = 0;
		int right = cleanString.length() - 1;

		while (left < right) {
			if (cleanString.charAt(left) != cleanString.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void validate(String string, boolean isPalindrome) {
		System.out.println("\"" + string + "\" is a palindrome => " + isPalindrome);
	}
}
