package problem6;

/**
 * O(n)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; // 최고 이익
        int min = prices[0]; // 저점

        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }

            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.maxProfit(new int[]) = " + solution.maxProfit(new int[]{8, 1, 5, 3, 6, 4}));
    }
}
