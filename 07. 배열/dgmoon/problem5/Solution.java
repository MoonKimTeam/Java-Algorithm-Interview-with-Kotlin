package problem5;

import java.util.Arrays;

/**
 * O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] numbers = new int[nums.length];

        int p = 1;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = p;
            p *= nums[i];
        }

        int q = 1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            numbers[i] *= q;
            q *= nums[i];
        }

        System.out.println("numbers = " + Arrays.toString(numbers));

        return numbers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.productExceptSelf(new int[]{1, 3, 5, 7});
    }
}