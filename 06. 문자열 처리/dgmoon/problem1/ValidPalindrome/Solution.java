package problem1.ValidPalindrome;

import java.util.Scanner;

/**
 * 최선 O(1)
 * 최악 O(n)
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            long startTime = System.currentTimeMillis();
            if (input.isEmpty()) {
                System.out.println("not palindrome");
            }

            input = input.replaceAll("[^A-z0-9]+", "");
            input = input.toLowerCase();
            System.out.println("input = " + input);

            if (isPalindrome(input)) {
                System.out.println("palindrome");
            } else {
                System.out.println("not palindrome");
            }
            System.out.println("실행 시간: " + (System.currentTimeMillis() - startTime) + " ms");
        }
    }

    private static boolean isPalindrome(final String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (!input.substring(i, i + 1).equals(input.substring(input.length() - i - 1, input.length() - i))) {
                return false;
            }
        }
        return true;
    }
}