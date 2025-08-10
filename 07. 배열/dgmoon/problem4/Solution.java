package problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        List<Integer> pairs = new ArrayList<>();
        Arrays.sort(nums);

        for (int i : nums) {
            pairs.add(i);

            if(pairs.size() == 2) {
                sum += Collections.min(pairs);
                pairs.clear();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.arrayPairSum((new int[] {1, 3, 4, 2})) = " + solution.arrayPairSum((new int[]{1, 3, 4, 2})));
    }
}