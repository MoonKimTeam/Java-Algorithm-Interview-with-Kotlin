package problem3;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                map.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        
        for (int k = 0; k < nums.length; k++) {
            int target = -nums[k];
            if (map.containsKey(target)) {
                for (int[] pair : map.get(target)) {
                    if (pair[0] != k && pair[1] != k) {
                        List<Integer> numbers = Arrays.asList(nums[pair[0]], nums[pair[1]], nums[k]);
                        Collections.sort(numbers);
                        if (!answers.contains(numbers)) {
                            answers.add(numbers);
                        }
                    }
                }
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("solution.threeSum(new int[]{-1, 0, 1, 2, -1, 5}) = " + solution.threeSum(new int[]{-1, 0, 1, 2, -1, 5}));
    }
}