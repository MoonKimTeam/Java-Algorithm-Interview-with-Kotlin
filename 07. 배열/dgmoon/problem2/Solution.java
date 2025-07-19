package problem2;

class Solution {
    public int trap(int[] height) {
        int previousMax = 0;
        int maxVolume = 0;

        int previousHeight = 0;
        for (int i = 1; i < height.length; i++) {
            if (previousMax < height[i]) {
                previousMax = height[i];
            }
            maxVolume += previousMax - height[i];
            if (previousHeight < height[i]) {
            }
        }

        return maxVolume;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trap(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}