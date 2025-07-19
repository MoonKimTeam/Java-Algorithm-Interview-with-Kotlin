package problem1;

import java.util.HashMap;

/**
 * 브루트 포스로 풀면O(n^2)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i + j == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }

        return null;
    }

    // 개선된 버전 - target에서 현재 숫자 뺀 값의 인덱스가 이미 존재하면 그 인덱스, 아니면 값과 인덱스 추가
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i] == nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.twoSum() = " + solution.twoSum(new int[]{2, 6, 11, 15}, 8));
        System.out.println("solution.twoSum2(new int[]{2, 6, 11, 15}, 8) = " + solution.twoSum2(new int[]{2, 6, 11, 15}, 8));
    }
}