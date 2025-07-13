package problem6.LongestPalindromicSubstring;

/**
 * O(n^2)
 * 슬라이딩 윈도우로 탐색
 */
class Solution {
    private static final String INPUT = "dcbabcdd";

    public String longestPalindrome(String s) {
        String[] split = s.split("");

        String maxPalindrome = "";
        for (int i = 1; i < split.length - 1; i++) {
            int count = 1;
            while (split[i - count].equals(split[i + count])) {
                maxPalindrome = s.substring(i - count, i + count + 1);
                count++;

                if (i - count < 0 || i + count >= split.length - 1) {
                    break;
                }
            }
        }
        return maxPalindrome;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();
        System.out.println("solution = " + solution.longestPalindrome(INPUT));

        System.out.println("실행 시간: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}