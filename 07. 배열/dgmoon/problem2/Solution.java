package problem2;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 투포인터 방식, 스택 방식 둘다 O(n)
 */
class Solution {
    public int trap(int[] height) {
        int maxVolume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax < rightMax) {
                maxVolume += leftMax - height[left];
                left++;
            } else {
                maxVolume += rightMax - height[right];
                right--;
            }
        }

        return maxVolume;
    }

    public int trap2(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int distance = i - stack.peek() - 1;
                int waters = Math.min(height[stack.peek()], height[i]) - height[top];
                volume += distance * waters;
            }

            stack.push(i);
        }

        return volume;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.trap(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) = " + solution.trap(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("solution.trap(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) = " + solution.trap2(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}